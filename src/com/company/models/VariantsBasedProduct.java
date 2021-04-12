package com.company.models;

import java.util.List;

public class VariantsBasedProduct extends Product{

    List<Variant> variants;

    public VariantsBasedProduct(String image, String name, List<Variant> variants) {
        super(image, name);
        this.variants = variants;
    }

    @Override
    public String toString() {
        return "VariantsBasedProduct{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", variants=" + variants +
                '}';
    }
}
