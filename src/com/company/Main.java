package com.company;

import com.company.models.Product;
import com.company.models.Variant;
import com.company.models.VariantsBasedProduct;
import com.company.models.WeightBasedProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Creates variantsBasedProduct
        List<Variant> variants = new ArrayList<>(
                Arrays.asList(new Variant("500g",90),
                        new Variant("1Kg",160))
        );

        VariantsBasedProduct variantsBasedProduct = new VariantsBasedProduct("abc","Kiwi",variants);
        System.out.println(variantsBasedProduct);

        //Created products for testing
        Product product1 = new Product("a","");
        Product product2 = new Product("a","");
        System.out.println(product1.hashCode());
        System.out.println(product2.hashCode());
        System.out.println(product1.equals(product2));

        //Creating actual products
        Product apple = new WeightBasedProduct("","Apple",1,100);
        Product kiwi = new VariantsBasedProduct("","Kiwi",new ArrayList<>(
                Arrays.asList(
                        new Variant("500g",90),
                        new Variant("1Kg",150)
                )
        ));

        List<Product> products = new ArrayList<>(
                Arrays.asList(apple,kiwi)
        );

        System.out.println(products);
    }
}
