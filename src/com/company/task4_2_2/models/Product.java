package com.company.task4_2_2.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Product {



    /*
        Common properties for both types of products
     */
    public String image, name;

    /*
        For variant based product
     */
    public List<Variant> variants;

    /*
        For quantity based product
     */
    public float minQty, pricePerKg;

    /*
        This is to find what type of product it is.
     */
    public int type;


    /*
        Constructor for variant based product
     */
    public Product(String image, String name, List<Variant> variants) {
        type = ProductType.TYPE_VP;
        this.image = image;
        this.name = name;
        this.variants = variants;
    }

    /*
        Constructor for quantity based product
     */
    public Product(String image, String name, float minQty, float pricePerKg) {
        type = ProductType.TYPE_WB;
        this.image = image;
        this.name = name;
        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }

    @Override
    public String toString() {
        return "Product{ \n" +
                "name = '" + name + '\'' +
                ", variants = " + variants +
                ", minQty = " + minQty +
                ", pricePerKg = " + pricePerKg +
                '}';
    }
}
