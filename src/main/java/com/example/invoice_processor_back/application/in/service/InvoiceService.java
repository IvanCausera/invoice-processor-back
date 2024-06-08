package com.example.invoice_processor_back.application.in.service;

import org.springframework.stereotype.Service;

import com.example.invoice_processor_back.application.in.InvoiceUseCase;
import com.example.invoice_processor_back.application.out.CsvFormatterPort;
import com.example.invoice_processor_back.application.out.InvoicePort;
import com.example.invoice_processor_back.application.out.XmlParserPort;
import com.example.invoice_processor_back.domain.Invoice;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceService implements InvoiceUseCase {
    private final InvoicePort invoicePort;
    private final CsvFormatterPort csvFormatterPort;
    private final XmlParserPort xmlParserPort;

    @Override
    public byte[] save(String xml) {
        List<Invoice> invoices = xmlParserPort.parseXmlToInvoices(xml);
        invoicePort.saveAll(invoices);
        return csvFormatterPort.formatTollsToCsv(invoices);
    }

    @Override
    public byte[] getTollCsv() {
        List<Invoice> invoices = invoicePort.findAll();
        return csvFormatterPort.formatTollsToCsv(invoices);
    }
}
