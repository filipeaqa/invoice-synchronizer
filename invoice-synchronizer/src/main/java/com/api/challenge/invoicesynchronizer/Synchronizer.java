package com.api.challenge.invoicesynchronizer;

import com.api.challenge.invoicesynchronizer.client.response.Response;
import com.api.challenge.invoicesynchronizer.entity.InvoiceEntity;
import com.api.challenge.invoicesynchronizer.mapper.InvoiceMapper;
import com.api.challenge.invoicesynchronizer.service.ArquiveiService;
import com.api.challenge.invoicesynchronizer.service.CursorHelper;
import com.api.challenge.invoicesynchronizer.service.CursorService;
import com.api.challenge.invoicesynchronizer.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class Synchronizer {

    private static final Logger log = LoggerFactory.getLogger(Synchronizer.class);
    private InvoiceService invoiceService;
    private ArquiveiService arquiveiService;
    private CursorService cursorService;


    Synchronizer(InvoiceService invoiceService,
                 ArquiveiService arquiveiService,
                 CursorService cursorService) {
        this.invoiceService = invoiceService;
        this.arquiveiService = arquiveiService;
        this.cursorService = cursorService;
    }

    void synchronize() {
        log.info("M=synchronize, I=Starting invoice Synchronization");

        Long currentCursor = cursorService.getCurrent();
        log.info("M=synchronize, I=Current cursor pointer: {}", currentCursor);

        Response response = arquiveiService.readFromAPI(currentCursor);
        if(response == null || response.getCount() <= 0  || response.getData() ==  null) {
            log.info("M=synchronize, I=No new invoices to sync");
        } else {
            List<InvoiceEntity> entities = InvoiceMapper.dataToEntities(response.getData());
            invoiceService.saveAll(entities);
            log.info("M=synchronize, I=Synchronized {} invoices", response.getData().size());

            Long nextCursor = CursorHelper.extractCursor(response.getPage());
            cursorService.updateCursor(nextCursor);
            log.info("M=synchronize, I=Updating cursor to {}", nextCursor);
        }
    }

}
