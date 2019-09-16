package com.api.challenge.invoicesynchronizer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String invoiceKey;
    private Double totalAmount;

    public InvoiceEntity(Long id, String invoiceKey, Double totalAmount) {
        this.id = id;
        this.invoiceKey = invoiceKey;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public InvoiceEntity() {};

    public void setTotal(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setInvoiceKey(String invoiceKey) {
        this.invoiceKey = invoiceKey;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public String getInvoiceKey() {
        return invoiceKey;
    }

}
