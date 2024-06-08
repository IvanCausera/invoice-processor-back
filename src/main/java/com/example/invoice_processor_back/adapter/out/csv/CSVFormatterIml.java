package com.example.invoice_processor_back.adapter.out.csv;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import com.example.invoice_processor_back.application.out.CsvFormatterPort;
import com.example.invoice_processor_back.domain.Toll;


@Component
public class CSVFormatterIml implements CsvFormatterPort {
    private static final String[] HEADERS = {"tipopeaje", "2000", "2001", "2010", "OTROS"};

    @Override
    public byte[] formatTollsToCsv(Map<String, Toll> tollMap) {
        try {
            StringWriter writer = new StringWriter();
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader(HEADERS).build();
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
}
