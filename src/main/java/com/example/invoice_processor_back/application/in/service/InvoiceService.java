package com.example.invoice_processor_back.application.in.service;

import org.springframework.stereotype.Service;

import com.example.invoice_processor_back.application.in.InvoiceUseCase;
import com.example.invoice_processor_back.application.out.CsvFormatterPort;
import com.example.invoice_processor_back.application.out.InvoicePort;
import com.example.invoice_processor_back.application.out.XmlParserPort;
import com.example.invoice_processor_back.domain.Concept;
import com.example.invoice_processor_back.domain.Invoice;
import com.example.invoice_processor_back.domain.Toll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return csvFormatterPort.formatTollsToCsv(extractTolls(invoices));
    }

    @Override
    public byte[] getTollCsv() {
        List<Invoice> invoices = invoicePort.findAll();
        return csvFormatterPort.formatTollsToCsv(extractTolls(invoices));
    }

    private Map<String, Toll> extractTolls(List<Invoice> invoices){
        Map<String, Toll> tollMap = new HashMap<>();
            for (Invoice invoice : invoices) {
                String tollType = invoice.getTipopeaje();
                Toll tollDto = tollMap.getOrDefault(tollType, new Toll(tollType));
                tollDto.incrementQuantity(1);
                for (Concept concept : invoice.getListaconceptos()) {
                    tollDto.addAmount(concept.getCodconcepto(), concept.getImporte());
                }
                tollMap.put(tollType, tollDto);
            }
        return tollMap;
    }
}
