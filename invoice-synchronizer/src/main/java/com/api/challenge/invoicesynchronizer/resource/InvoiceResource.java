package com.api.challenge.invoicesynchronizer.resource;

import com.api.challenge.invoicesynchronizer.entity.InvoiceEntity;
import com.api.challenge.invoicesynchronizer.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/invoices")
public class InvoiceResource {

    private InvoiceService service;

    public InvoiceResource(InvoiceService repository) {
        this.service = repository;
    }

    @GetMapping("/{accessKey}")
    ResponseEntity<InvoiceEntity> findByAccessKey(@PathVariable String accessKey) throws NoSuchElementException {
        InvoiceEntity entity = service.findByAccessKey(accessKey);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping
    List<InvoiceEntity> findAll() {
        return service.findAll();
    }
}

