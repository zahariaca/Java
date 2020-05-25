package com.zahariaca.almasb.tutorials.gamemenu;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 9/15/2016.
 */
public class GameMenu extends Parent {

    public GameMenu(){
        VBox menu0 = new VBox(10);
        VBox menu1 = new VBox(10);

        menu0.setTranslateX(100);
        menu0.setTranslateY(200);
        menu1.setTranslateX(100);
        menu1.setTranslateY(200);

        final int offset = 400;

        MenuButton resumeBtn = new MenuButton("Resume");
        MenuButton optionsBtn = new MenuButton("Options");
        MenuButton exitBtn = new MenuButton("Exit");

        resumeBtn.setOnMousePressed(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            //sets the opacity of gameMenu from 0 to 1 over 0,5 seconds
            ft.setFromValue(1);
            ft.setToValue(0);

            ft.setOnFinished(event1 -> this.setVisible(false));
            ft.play();
        });

        optionsBtn.setOnMousePressed(event -> {
            getChildren().add(menu1);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
            tt.setToX(menu0.getTranslateX() - offset);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
            tt1.setToX(menu0.getTranslateX());

            tt.play();
            tt1.play();

            tt1.setOnFinished(event1 -> getChildren().remove(menu0));
        });

        exitBtn.setOnMousePressed(event -> System.exit(0));

        menu0.getChildren().addAll(resumeBtn,optionsBtn,exitBtn);


        MenuButton soundBtn = new MenuButton("Sound");
        MenuButton videoBtn = new MenuButton("Video");
        MenuButton backBtn = new MenuButton("Back");

        backBtn.setOnMousePressed(event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
            tt.setToX(menu1.getTranslateX() - offset);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(menu1.getTranslateX());

            tt.play();
            tt1.play();

            tt1.setOnFinished(event1 -> getChildren().remove(menu1));
        });

        menu1.getChildren().addAll(soundBtn, videoBtn, backBtn);

        Rectangle bg = new Rectangle(800,600);
        bg.setOpacity(0.4);
        bg.setFill(Color.GRAY);

        this.getChildren().addAll(bg,menu0);

    }


}
