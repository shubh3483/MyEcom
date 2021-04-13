package com.company.models;

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
        return String.format(" Unit Price : %.2f, Quantity %.2f, Total %.2f\n",untPrice,qty,untPrice * qty );
    }
}
