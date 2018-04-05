package com.zahariaca.firsttry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Product p1 = new Product("floor", 35);
        Product p2 = new Product("door", 10);
        Product p3 = new Product("window", 20);

        Collection<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);

        System.out.println(products);
        System.out.println("**********************************");

        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()){
            Product product = productIterator.next();
            System.out.println(product);
        }
        System.out.println("**********************************");

        for(Product product:products){
            System.out.println(product);
        }
        System.out.println("**********************************");

        productIterator = products.iterator();
        while (productIterator.hasNext()){
            Product product = productIterator.next();
            if(product.getWeight() < 30){
                System.out.println(product);
            }else{
                productIterator.remove();
            }
        }

    }
}
