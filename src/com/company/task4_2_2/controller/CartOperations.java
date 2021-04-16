package com.company.task4_2_2.controller;

import com.company.task4_2_2.models.Cart;
import com.company.task4_2_2.models.Product;
import com.company.task4_2_2.models.ProductType;
import com.company.task4_2_2.models.Variant;

import java.util.Scanner;

public class CartOperations {

    Cart cart = new Cart();
    String name;
    float qty;
    int variantSelector;
    Scanner scanner = new Scanner(System.in);

    /**
     *  Default Constructor
     */
    public CartOperations() {

    }


    /**
     *  This function will add items to cart based on WBP and VBP.
     */
    void addItemToCart(){
        System.out.println("Enter product name to be entered into the cart");
        name = scanner.next();
        String key = name;
        Product product = Product.products.get(key);
        if(product.type == ProductType.TYPE_WB){
            System.out.println("It will be given on weight basis.");
            System.out.println("Enter quantity in Kg");
            qty = scanner.nextFloat();
            cart.add(product,qty);
        }
        else{
            System.out.println("There are 2 of its variants choose any one (Enter 1 or 2)");
            variantSelector = scanner.nextInt();
            System.out.println("Enter quantity");
            qty = scanner.nextInt();
            Variant variant = product.variants.get(variantSelector-1);
            cart.add(product,variant,qty);
        }
    }


    /**
     *  This function is used to edit items in cart depending on the type of product.
     */

    void editItemInCart(){
        System.out.println("Enter name of the product you want to edit from cart");
        name = scanner.next();
        String key = name;
        Product product = Product.products.get(key);
        if (product.type == ProductType.TYPE_WB){
            System.out.println("Enter new quantity");
            qty = scanner.nextFloat();
            cart.changeQtyOfWBP(product,qty);
        }
        else {
            System.out.println("Select first(Press 1) or select second(Press 2) variant");
            variantSelector = scanner.nextInt();
            Variant variant = product.variants.get(variantSelector - 1);
            System.out.println("Choose 1 to increment and 2 to decrement");
            variantSelector = scanner.nextInt();
            if(variantSelector == 1){
                cart.incrementVBP(product,variant);
            }
            else
            cart.decrementVBP(product, variant);
        }

    }


    /**
     *  This function is used to delete items from cart.
     */

    void deleteItemFromCart(){

        System.out.println("Enter name of the product you want to remove from cart");
        name = scanner.next();
        String key = name;
        Product product = Product.products.get(key);
        if (cart.cartItems.containsKey(key)) {

            /*
                If the product is a weight based product
             */
            if (product.type == ProductType.TYPE_WB) {
                cart.removeAllWeightBasedProduce(product);
                showCart();
            }

            /*
                If product is a variant based product.
             */
            else {
                System.out.println("Its a variant based product\n");
                cart.removeAllVariantsBasedProduct(product);
                showCart();
            }
        }
        else {
            System.out.println("Not present in cart");
        }
    }

    /**
     *  This function will show the cart summary.
     */

    void showCart(){
        System.out.println(cart);
    }
}
