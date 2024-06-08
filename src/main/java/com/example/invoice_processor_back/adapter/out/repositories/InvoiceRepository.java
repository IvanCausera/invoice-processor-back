package com.example.invoice_processor_back.adapter.out.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.invoice_processor_back.application.out.InvoicePort;
import com.example.invoice_processor_back.domain.Invoice;


public interface InvoiceRepository extends InvoicePort, MongoRepository<Invoice, String> {

    @Override
    default Invoice save(Invoice invoice) {
        return insert(invoice);
    }

    @Override
    default List<Invoice> saveAll(List<Invoice> invoices) {
        return insert(invoices);
    }
}
