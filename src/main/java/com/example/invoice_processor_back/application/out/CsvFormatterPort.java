package com.example.invoice_processor_back.application.out;

import java.util.List;

import com.example.invoice_processor_back.domain.Invoice;

public interface CsvFormatterPort {
    byte[] formatTollsToCsv(List<Invoice> invoices);
}
