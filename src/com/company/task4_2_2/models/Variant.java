package com.company.task4_2_2.models;

public class Variant {

    public String variantType;
    public float price;

    public Variant(String variantType, float price) {
        this.variantType = variantType;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{ " +
                "variant type = '" + variantType + '\'' +
                ", price = " + price +
                "}\n";
    }
}
