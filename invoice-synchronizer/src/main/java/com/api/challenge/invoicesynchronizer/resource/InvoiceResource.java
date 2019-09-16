package com.api.challenge.invoicesynchronizer.resource;

import com.api.challenge.invoicesynchronizer.entity.InvoiceEntity;
import com.api.challenge.invoicesynchronizer.repository.InvoiceRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/invoices")
public class InvoiceResource {

    private InvoiceRepository repository;

    public InvoiceResource(InvoiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{key}")
    InvoiceEntity findByAccessKey(@PathVariable String key) {
        return repository.findByInvoiceKey(key);
    }
}

