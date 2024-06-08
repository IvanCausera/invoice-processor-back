package com.example.invoice_processor_back.application.out;

import java.util.Map;

import com.example.invoice_processor_back.domain.Toll;

public interface CsvFormatterPort {
    byte[] formatTollsToCsv(Map<String, Toll> invoices);
}
