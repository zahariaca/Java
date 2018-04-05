package com.azaharia.abstractfactorypattern.factorypattern.facotry.colors;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/31/2016.
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println ("RED");
    }
}
