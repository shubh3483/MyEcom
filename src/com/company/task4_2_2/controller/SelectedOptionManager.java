package com.company.task4_2_2.controller;

import java.util.Scanner;

public class SelectedOptionManager {

    public static void startChooser(){
        ProductOperations productOperations = new ProductOperations();
        CartOperations cartOperations = new CartOperations();
        int inputChecker = 0;
        Scanner scanner = new Scanner(System.in);

        String message = "Choose corresponding number to perform the operation\n" +
                " 1 - Add a product\n 2 - Edit a product\n 3 - Delete a product\n 4 - Add item to cart\n" +
                " 5 - Edit item in cart\n 6 - Delete item from cart\n 7 - See all products\n 8 - Go to cart \n" +
                " 0 - For exit\n Enter your choice : ";

        System.out.println(message);
        inputChecker = scanner.nextInt();

        /**
         *  This while function is made to give choices to the user until and unless they choose to exit it.
         */
        while (inputChecker != 0){
            switch (inputChecker){
                case 1 :
                    System.out.println("Enter \"V\" for variant based product and \"W\" for weight based product");
                    String productTypeSelector;
                    productTypeSelector = scanner.next();
                    if(productTypeSelector.equals("W")){
                        productOperations.inputWBP();
                    }
                    else if(productTypeSelector.equals("V"))
                        productOperations.inputVBP();
                    else {
                        System.out.println("pls Enter correct choice");
                    }
                    break;

                case 2 : productOperations.editAProduct();
                    break;

                case 3 : productOperations.deleteAProduct();
                    break;

                case 4 : cartOperations.addItemToCart();
                    break;

                case 5 : cartOperations.editItemInCart();
                    break;

                case 6 : cartOperations.deleteItemFromCart();
                    break;

                case 7 : productOperations.showAllProducts();
                    break;

                case 8 : cartOperations.showCart();

            }
            System.out.println();
            System.out.println(message);
            inputChecker = scanner.nextInt();
        }
    }
}
