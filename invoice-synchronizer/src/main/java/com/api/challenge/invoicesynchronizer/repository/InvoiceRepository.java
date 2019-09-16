package com.api.challenge.invoicesynchronizer.repository;

import com.api.challenge.invoicesynchronizer.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

    InvoiceEntity findByInvoiceKey(String invoiceKey);
}
