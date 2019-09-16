package com.api.challenge.invoicesynchronizer.service;

import com.api.challenge.invoicesynchronizer.entity.InvoiceEntity;
import com.api.challenge.invoicesynchronizer.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InvoiceService {

    InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceEntity> saveAll(List<InvoiceEntity> invoiceEntities) {
        return invoiceRepository.saveAll(invoiceEntities);
    }

    public List<InvoiceEntity> findAll() {
        return invoiceRepository.findAll();
    }

    public InvoiceEntity findByAccessKey(@NotNull String accessKey) throws NoSuchElementException {
        InvoiceEntity entity = invoiceRepository.findByInvoiceKey(accessKey);

        if(entity == null) {
            throw new NoSuchElementException("Invoice not found");
        }
        return entity;
    }
}
