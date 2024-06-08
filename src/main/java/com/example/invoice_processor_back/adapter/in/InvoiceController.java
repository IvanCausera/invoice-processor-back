package com.example.invoice_processor_back.adapter.in;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.invoice_processor_back.application.in.InvoiceUseCase;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceUseCase invoiceUseCase;

    @PostMapping(
        path = "xml",
        consumes = "application/xml",
        produces = "text/csv"
    )
    public ResponseEntity<byte[]> saveInvoice(@RequestBody String xmlInvoice) {
        byte[] csvBytes = invoiceUseCase.save(xmlInvoice);
        return ResponseEntity.ok(csvBytes);
    }

    @GetMapping(
        path = "toll",
        produces = "text/csv"
    )
    public ResponseEntity<byte[]> getTollCsv() {
        byte[] csvBytes = invoiceUseCase.getTollCsv();
        return ResponseEntity.ok(csvBytes);
    }
    
    
}

