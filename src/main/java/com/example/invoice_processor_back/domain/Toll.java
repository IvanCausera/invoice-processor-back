package com.example.invoice_processor_back.domain;

import lombok.Data;

@Data
public class Toll {
    private String tollType;
    private int quantity;
    private double sum2000;
    private double sum2001;
    private double sum2010;
    private double sumOthers;

    public Toll(String tollType) {
        this.tollType = tollType;
        this.sum2000 = 0.0;
        this.sum2001 = 0.0;
        this.sum2010 = 0.0;
        this.sumOthers = 0.0;
    }

    public void addAmount(String conceptCode, double amount) {
        switch (conceptCode) {
            case "2000":
                this.sum2000 += amount;
                break;
            case "2001":
                this.sum2001 += amount;
                break;
            case "2010":
                this.sum2010 += amount;
                break;
            default:
                this.sumOthers += amount;
                break;
        }
    }

    public void incrementQuantity(int increment){
        this.quantity += increment;
    }

    public double getAverage2000() {
        return this.quantity == 0 ? 0 : this.sum2000 / this.quantity;
    }

    public double getAverage2001() {
        return this.quantity == 0 ? 0 : this.sum2001 / this.quantity;
    }

    public double getAverage2010() {
        return this.quantity == 0 ? 0 : this.sum2010 / this.quantity;
    }

    public double getAverageOthers() {
        return this.quantity == 0 ? 0 : this.sumOthers / this.quantity;
    }
}
