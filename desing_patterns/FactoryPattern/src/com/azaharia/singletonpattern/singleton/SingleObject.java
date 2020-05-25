package com.azaharia.singletonpattern.singleton;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/31/2016.
 */

public class SingleObject {
    private static SingleObject instance = new SingleObject();

    private SingleObject() {}

    public static SingleObject getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("This is the message from Singleton");
    }
}
