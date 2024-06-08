package com.example.invoice_processor_back.application.in;

public interface InvoiceUseCase {
    byte[] save(String xml);
    byte[] getTollCsv();
}
