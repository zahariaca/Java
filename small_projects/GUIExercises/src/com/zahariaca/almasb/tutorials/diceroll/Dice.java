package com.zahariaca.almasb.tutorials.diceroll;

import javafx.animation.RotateTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 9/15/2016.
 */
public class Dice extends StackPane {
    public static final int MAX_VAL=6;
    public static final int MIN_VAL=1;

    public final SimpleIntegerProperty valueProperty = new SimpleIntegerProperty();

    public Dice(){
        Rectangle rectangle = new Rectangle(50,50);
        //rectangle.setOpacity(0.8);

        Text text = new Text();
        text.setFill(Color.WHITE);
        text.textProperty().bind(valueProperty.asString());

        this.setAlignment(Pos.CENTER);
        this.setOnMouseClicked(event -> roll());
        getChildren().addAll(rectangle,text);
    }
    public void roll() {
        RotateTransition rt = new RotateTransition(Duration.seconds(1), this);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setOnFinished(event -> {
            valueProperty.set((int)(Math.random() * (MAX_VAL - MIN_VAL + 1)) + MIN_VAL);
        });
        rt.play();

    }
}
