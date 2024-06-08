package com.example.invoice_processor_back.adapter.out.xml;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import com.example.invoice_processor_back.application.out.XmlParserPort;
import com.example.invoice_processor_back.domain.Invoice;

@Component
public class XmlParserIml implements XmlParserPort {

    @Override
    public List<Invoice> parseXmlToInvoices(String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(InvoicesWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            InvoicesWrapper wrapper = (InvoicesWrapper) unmarshaller.unmarshal(reader);
            return wrapper.getInvoices();
        } catch (JAXBException e) {
            throw new RuntimeException("Error parsing XML", e);
        }
    }
    
}

