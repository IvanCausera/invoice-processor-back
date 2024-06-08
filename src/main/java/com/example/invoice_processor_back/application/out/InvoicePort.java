package com.example.invoice_processor_back.application.out;

import java.util.List;

import com.example.invoice_processor_back.domain.Invoice;


public interface InvoicePort {
    Invoice save(Invoice invoice);
    List<Invoice> saveAll(List<Invoice> invoice);
    List<Invoice> findAll();

}