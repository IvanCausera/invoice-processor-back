package com.example.invoice_processor_back.adapter.out.csv;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import com.example.invoice_processor_back.application.out.CsvFormatterPort;
import com.example.invoice_processor_back.domain.Concept;
import com.example.invoice_processor_back.domain.Invoice;
import com.example.invoice_processor_back.domain.Toll;


@Component
public class CSVFormatterIml implements CsvFormatterPort {

    @Override
    public byte[] formatTollsToCsv(List<Invoice> invoices) {
        try {
            Map<String, Toll> tollMap = extractTolls(invoices);
            StringWriter writer = new StringWriter();
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader("tipopeaje", "2000", "2001", "2010", "OTROS").build();
            CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat);
            for (Toll tollDto : tollMap.values()) {
                csvPrinter.printRecord(
                        tollDto.getTollType(),
                        tollDto.getAverage2000(),
                        tollDto.getAverage2001(),
                        tollDto.getAverage2010(),
                        tollDto.getAverageOthers()
                );
            }
            csvPrinter.flush();
            csvPrinter.close();
            return writer.toString().getBytes();
        } catch (IOException e) {
            throw new RuntimeException("Error parsing CSV", e);
        }
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
