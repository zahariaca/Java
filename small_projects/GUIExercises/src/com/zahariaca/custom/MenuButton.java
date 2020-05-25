package com.zahariaca.custom;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/10/2016.
 */
public class MenuButton extends StackPane {
    private Text text;

    public MenuButton(String text){
        this.text=new Text(text);
        this.text.setFont(this.text.getFont().font(20));
        this.text.setFill(Color.AZURE);

        Rectangle bg = new Rectangle(300,50);
        bg.setFill(Color.SILVER);
        bg.setOpacity(0.9);

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(bg,this.text);

    }


}
