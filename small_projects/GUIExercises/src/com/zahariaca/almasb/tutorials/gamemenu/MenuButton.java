package com.zahariaca.almasb.tutorials.gamemenu;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MenuButton extends StackPane {
    private Text text;

    public MenuButton(String text){
        this.text = new Text(text);
        this.text.setFont(this.text.getFont().font(20));
        this.text.setFill(Color.WHITE);

        Rectangle bg = new Rectangle(250,25);
        bg.setOpacity(0.6);
        bg.setFill(Color.BLACK);
        bg.setEffect(new GaussianBlur(4));

        this.setAlignment(Pos.CENTER_LEFT);
        this.setRotate(-0.5);
        this.getChildren().addAll(bg, this.text);

        this.setOnMouseEntered(event -> {
            this.setTranslateX(10);
            this.text.setFill(Color.BLACK);
            bg.setFill(Color.WHITE);
        });
        this.setOnMouseExited(event -> {
            this.setTranslateX(0);
            this.text.setFill(Color.WHITE);
            bg.setFill(Color.BLACK);
        });

        DropShadow drop = new DropShadow(50, Color.WHITE);
        drop.setInput(new Glow());

        this.setOnMousePressed(event -> this.setEffect(drop));
        this.setOnMouseReleased(event -> this.setEffect(null));
    }

}