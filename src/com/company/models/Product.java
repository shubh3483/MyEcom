package com.company.models;

import java.util.Objects;

public class Product {

    String image, name;

    public Product(String image, String name) {
        this.image = image;
        this.name = name;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(image, product.image) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, name);
    }
}
