package com.example.invoice_processor_back.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "invoices")
@XmlRootElement(name = "factura")
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoice {
    @Id
    @XmlElement(name = "numpseudofactura")
    private String id;
    @XmlElement
    private String cups;
    @XmlElement
    private String tipopeaje;
    @XmlElementWrapper(name = "listaconceptos")
    @XmlElement(name = "concepto")
    private List<Concept> listaconceptos;
}
