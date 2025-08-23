package com.Assignment;
class Invoice{
    String partNumber;
    String partDescription;
    int quantity;
    double price;

    public Invoice(String partDescription, String partNumber, double price, int quantity) {
        this.partDescription = partDescription;
        this.partNumber = partNumber;
        this.price = price;
        this.quantity = quantity;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    double getinvoiceamount(){
        return quantity*price;
    }
}

public class Problem_08 {
    public static void main(String[] args) {
        Invoice i1 = new Invoice("bolt", "12SRE95", 100.015,50);
        System.out.println(i1.partDescription);
        System.out.println(i1.partNumber);
        System.out.println(i1.price);
        System.out.println(i1.quantity);
        System.out.println(i1.getinvoiceamount());
        Invoice i2 = new Invoice("pipe", "34YEOS32T", 550,150);
        System.out.println(i2.partDescription);
        System.out.println(i2.partNumber);
        System.out.println(i2.price);
        System.out.println(i2.quantity);
        System.out.println(i2.getinvoiceamount());
    }

}
