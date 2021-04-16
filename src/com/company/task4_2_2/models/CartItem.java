package com.company.task4_2_2.models;

public class CartItem {

    String name;
    float untPrice ,qty;

    float cost(){
        return untPrice * qty;
    }

    public CartItem(String name, float untPrice, float qty) {
        this.name = name;
        this.untPrice = untPrice;
        this.qty = qty;
    }


    @Override
    public String toString() {
        return "\n" + name +
                String.format(", (%.2f X %.2f = %.2f",untPrice,qty,untPrice * qty ) + " )";
    }
}
