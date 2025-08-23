package com.Assignment.lab_4.problem_01;

public abstract class Product {
    String name;
    String product_ID;
    String category_ID;
    int unitPrice;
    public Product(String name , String product_ID, String category_ID , int unitprice ){
        this.name = name;
        this.product_ID = product_ID;
        this.category_ID = category_ID;
        this.unitPrice = unitprice;
    }
    public abstract  String  disp_Info();
}
