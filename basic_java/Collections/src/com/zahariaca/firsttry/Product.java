package com.zahariaca.firsttry;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/24/2016.
 */
public class Product {
    private String name;
    private int weight;

    public String getName(){return name;}
    public void setName(){this.name=name;}
    public int getWeight(){return weight;}
    public void setWeight(){this.weight=weight;}

    public Product(String name, int weight){
        this.name=name;
        this.weight=weight;
        toString();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
