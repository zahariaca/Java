package com.zahariaca.custom;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/10/2016.
 */
public class Menu extends Parent{

    public Menu() {
        VBox menu = new VBox();

        MenuButton calculator = new MenuButton("Calculator");
        MenuButton calculator2 = new MenuButton("Calculator");
        MenuButton calculator3 = new MenuButton("Calculator");

        menu.getChildren().addAll(calculator,calculator2,calculator3);

        this.getChildren().addAll(menu);
    }
}
