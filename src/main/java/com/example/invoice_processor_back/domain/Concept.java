package com.example.invoice_processor_back.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "concepto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Concept {
    @XmlElement
    private String codconcepto;
    @XmlElement
    private double importe;
}
