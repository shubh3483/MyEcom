package com.company.task4_2_2.models;

import java.util.HashMap;

public class Cart {

    public HashMap<String, CartItem> cartItems = new HashMap<>();
    float total, noOfItems;


    /*
        For weight based product
     */
    public void add(Product product, float qty){

        //If the product already exist
        if(cartItems.containsKey(product.name)){
            total-= cartItems.get(product.name).cost();
        }

        //If the product is getting added for the first time
        else{
            CartItem cartItem = new CartItem(product.name,product.pricePerKg,qty);
            cartItems.put(product.name,cartItem);
            noOfItems++;
        }
        total+= product.pricePerKg * qty;
    }

    /*
        For variant based product
     */
    public void add(Product product, Variant variant, float qty){

        String key = product.name + " " + variant.variantType;

        //Checking whether that the product is already present in the cart or not.
        if(cartItems.containsKey(key)){
            cartItems.get(key).qty++;
        }

        //If the product is not present.
        else{
            CartItem cartItem = new CartItem(product.name, variant.price, qty);
            cartItems.put(key,cartItem);
        }
        noOfItems++;
        total+=variant.price * qty;
    }

    /*
        To remove all the products of a particular type
     */
    public void removeAll(Product product){
        if(product.type == ProductType.TYPE_WB){
            removeAllWeightBasedProduce(product);
        }else {
            removeAllVariantsBasedProduct(product);
        }

    }

    /*
        To remove weight based product
     */
    public void removeAllWeightBasedProduce(Product product) {
        total -= cartItems.get(product.name).cost();
        noOfItems--;
        cartItems.remove(product.name);
    }


    /*
        To remove variant based product
     */
    public void removeAllVariantsBasedProduct(Product product){

        /*
            Using for loop because we want to delete all the variants of that particular product.
         */
        for (Variant variant : product.variants) {
            String key = product.name + " " + variant.variantType;
            if(cartItems.containsKey(key)){
                total -= cartItems.get(key).cost();
                noOfItems--;
                cartItems.remove(key);
            }
        }


    }


    /*
        This function is used when we want to decrease the quantity of a particular variant
     */
    public void decrementVBP(Product product, Variant variant){
        String key = product.name + " " + variant.variantType;
        cartItems.get(key).qty--;
        total -= variant.price;
        if(cartItems.get(key).qty == 0){
            cartItems.remove(key);
            noOfItems--;
        }
    }

    public void incrementVBP(Product product, Variant variant){
        String key = product.name + " " + variant.variantType;
        cartItems.get(key).qty++;
        total += variant.price;
    }

    public void changeQtyOfWBP(Product product, float qty){
        total-= cartItems.get(product.name).cost();
        cartItems.get(product.name).qty = qty;
        total+= product.pricePerKg * qty;
    }

    /*public void incrementWBP(Product product,float qty){
        if(cartItems.containsKey(product.name)){
            total+= product.pricePerKg * qty;
        }
    }

    public void decrementWBP(Product product,float qty){
        if(cartItems.containsKey(product.name)){
            total-= product.pricePerKg * qty;
        }
        if(cartItems.get(product.name).qty == 0){
            cartItems.remove(product.name);
            noOfItems--;
        }
    }*/

    @Override
    public String toString() {
        return "Cart\n" +
                cartItems +
                ",\n total=" + total +
                ",\n noOfItems=" + noOfItems +
                '}';
    }
}
