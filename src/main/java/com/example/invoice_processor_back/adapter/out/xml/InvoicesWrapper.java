package com.example.invoice_processor_back.adapter.out.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.invoice_processor_back.domain.Invoice;

import java.util.List;

@XmlRootElement(name = "facturasctd")
public class InvoicesWrapper {
    @XmlElement(name = "factura")
    private List<Invoice> invoices;

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
