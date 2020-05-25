package com.zahariaca.ooptest.invoiceitem;

/**
 * Created by azaharia on 31.05.2016.
 */
public class InvoiceItem {
    private String id;
    private int qty;
    private String description;
    private double unitPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public InvoiceItem(String id, int qty, String description, double unitPrice) {
        this.id = id;
        this.qty = qty;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public double getTotal(){
        return unitPrice * qty;
    }

    public String toString(){
        return "InvoiceItem[ id= " +id +
                ", description= " + description +
                ", qty= " + qty +
                ", unitPrice= " + unitPrice + " ]";
    }
}
