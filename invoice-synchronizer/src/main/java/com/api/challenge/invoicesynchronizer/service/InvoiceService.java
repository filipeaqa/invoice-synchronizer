package com.api.challenge.invoicesynchronizer.service;

import com.api.challenge.invoicesynchronizer.entity.InvoiceEntity;
import com.api.challenge.invoicesynchronizer.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceEntity> saveAll(List<InvoiceEntity> invoiceEntities) {
        return invoiceRepository.saveAll(invoiceEntities);
    }
}
