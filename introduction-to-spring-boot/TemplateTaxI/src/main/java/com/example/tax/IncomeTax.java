package com.example.tax;

public class IncomeTax  implements Tax{
    /*
    1. Create the following attributes.
        a. taxableAmount (double)
        b. taxAmount (double)
        c. isTaxPayed (boolean)
    2. Make this class an implementation of Tax interface and override the interface methods.
    3. Using constructor initialize the isTaxPayed boolean false.
     */

    private double taxableAmount;
    private double taxAmount;
    private boolean isTaxPayed;

    public IncomeTax(){
        this.isTaxPayed = false;
    }

    @Override
    public void setTaxableAmount(int amount) {
       this.taxableAmount = amount;
    }

    @Override
    public void calculateTaxAmount() {
        taxAmount = taxableAmount * 0.30;

    }

    @Override
    public double getTaxAmount() {
        return taxAmount;
    }

    @Override
    public String getTaxType() {
        return "income";
    }

    @Override
    public boolean isTaxPayed() {
        return isTaxPayed;
    }

    @Override
    public void payTax() {
        System.out.println("Hi! Income Tax Paid");
        this.isTaxPayed = true;
    }
}
