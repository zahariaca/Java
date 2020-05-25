package com.azaharia.abstractfactorypattern.factorypattern.facotry.shapes;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/31/2016.
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square!");
    }
}
