package com.company.models;

import java.util.List;
import java.util.Objects;

public class Product {

    /*
        Common properties for both types of products
     */
    String image, name;

    /*
        For variant based product
     */
    public List<Variant> variants;

    /*
        For quantity based product
     */
    float minQty, pricePerKg;

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
}
