package com.Assignment.lab_4.problem_01;

public class ElectricalProduct extends Product {
    public ElectricalProduct(String name, String product_ID, String category_ID, int unitprice,String voltageRange, String  wattage,double price) {
        super(name, product_ID, category_ID, unitprice);
        this.price = price;
        this.voltageRange = voltageRange;
        this.wattage = wattage;
    }
    private String voltageRange;
    private String wattage;
    private double price;

    public void setVoltageRange(String voltageRange) {
        this.voltageRange = voltageRange;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }


    public String disp_Info() {
        final StringBuilder sb = new StringBuilder("ElectricalProduct{");
        sb.append("price=").append(price);
        sb.append(", voltageRange=").append(voltageRange);
        sb.append(", wattage=").append(wattage);
        sb.append(", category_ID='").append(category_ID).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", product_ID='").append(product_ID).append('\'');
        sb.append(", unitPrice=").append(unitPrice);
        sb.append('}');
        return sb.toString();
    }
}
