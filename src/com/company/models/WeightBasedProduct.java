package com.company.models;

public class WeightBasedProduct extends Product{

    float minQty, pricePerKg;

    public WeightBasedProduct(String image, String name, float minQty, float pricePerKg) {
        super(image, name);
        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }

    @Override
    public String toString() {
        return "WeightBasedProduct{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", minQty=" + minQty +
                ", pricePerKg=" + pricePerKg +
                '}';
    }
}
