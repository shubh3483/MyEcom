package com.company.task4_2_2.controller;

import com.company.task4_2_2.models.Product;
import com.company.task4_2_2.models.ProductType;
import com.company.task4_2_2.models.Variant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductOperations {

    String name;
    float minQty;
    float pricePerKg;
    float variantPrice;
    String variantName;
    List<Variant> variants = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    /**
     * Default Constructor
     */

    public ProductOperations() {
    }

    /**
     * The below function is made for taking the weight based product during run time
     */

    void inputWBP(){
        System.out.println("Enter name, min quantity and price per kg of the product");
        name = scanner.next();
        minQty = scanner.nextFloat();
        pricePerKg = scanner.nextFloat();
        Product product = new Product("",name,minQty,pricePerKg);
        addProduct(product);
    }


    /**
     * The below function is made for taking the variant based product during run time
     */

    void inputVBP(){
        System.out.println("Enter name, list of variants");
        name = scanner.next();
        for(int i=1;i<=2;i++)
        {
            System.out.println("Enter "+ i + " variant name and variant price");
            variantName = scanner.next();
            variantPrice = scanner.nextFloat();
            Variant variant = new Variant(variantName,variantPrice);
            variants.add(variant);
        }
        Product product = new Product(" ",name,variants);
        addProduct(product);
    }

    /**
     * This functions adds the products in a hashmap(named "products" in "Product" class) to store the products.
     * @param product
     */

    public void addProduct(Product product){
        String key = product.name;
        Product.products.put(key,product);
    }

    /**
     *  This function is made to delete a product from the admin side(as of now it is available for all)
     */

    public void deleteAProduct(){
        System.out.println("Enter the product name");
        name = scanner.next();
        String key = name;
        Product product = Product.products.get(key);

        /*
            If the product type is WB then we can directly remove this product.
         */

        if(product.type == ProductType.TYPE_WB){
            Product.products.remove(key);
        }

        /*
            If not
         */

        else{
            String removeChoicer;

            /*
                This is the choice given like whether he wants to remove the complete product or only a variant
                of this product
             */

            System.out.println("Type \"V\" to remove a variant and \"A\" to remove the complete element");
            removeChoicer = scanner.next();

            //If chooses to remove the complete product
            if(removeChoicer.equals("A")){
                Product.products.remove(key);
            }

            //Asking the variant type to remove a particular variant of that product.
            else{
                System.out.println("Enter variant name");
                variantName = scanner.next();
                for (Variant variant : product.variants) {
                    if(variant.variantType.equals(variantName))
                        product.variants.remove(variant);
                }
            }
        }
    }


    /**
     *  This function provides the functionality to edit the products.
     */
    public void editAProduct() {
        System.out.println("Enter the product name");
        name = scanner.next();
        String key = name;
        Product product = Product.products.get(key);

        /*
            If the product type is WB then we can edit it the following way.
         */
        if(product.type == ProductType.TYPE_WB){
            System.out.println("Enter name, min quantity and price per kg of the product");
            product.name = scanner.next();
            product.minQty = scanner.nextFloat();
            product.pricePerKg = scanner.nextFloat();
        }

        /*
            If the product is variant based then we have to change it according to the type of variant.
         */
        else{
            int variantNumber;      //This will store the choice for type of variant.
            System.out.println("Enter 1 to change first or 2 to change second variant");
            variantNumber = scanner.nextInt();
            System.out.println("Enter variant name and variant price");
            Variant variant = product.variants.get(variantNumber - 1);
            variant.variantType = scanner.next();
            variant.price = scanner.nextFloat();
        }

    }


    /**
     *  This function will display all the products which a user can buy.
     */
    public static void showAllProducts(){
        for (Map.Entry mapElement : Product.products.entrySet()){
            Product product = (Product) mapElement.getValue();
            System.out.println(product);
        }
    }


}
