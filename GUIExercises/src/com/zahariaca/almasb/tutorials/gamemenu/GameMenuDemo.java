package com.zahariaca.almasb.tutorials.gamemenu;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 9/15/2016.
 */
public class GameMenuDemo extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {


        Pane root = new Pane();
        root.setPrefSize(800,600);

        Rectangle bg = new Rectangle(800,600);
        bg.setFill(Color.BLACK);

        InputStream is = Files.newInputStream(Paths.get("res/images/menu_bg.png"));
        Image img = new Image(is);
        is.close();

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(800);
        imgView.setFitHeight(600);

        GameMenu gameMenu = new GameMenu();
        gameMenu.setVisible(false);


        root.getChildren().addAll(bg, gameMenu);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ESCAPE){
                if (!gameMenu.isVisible()){
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
                    //sets the opacity of gameMenu from 0 to 1 over 0,5 seconds
                    ft.setFromValue(0);
                    ft.setToValue(1);

                    //sets the gameMenu as visible first so that the ft animation can happen. otherwise the gameMenu would be invisible
                    gameMenu.setVisible(true);
                    ft.play();
                }else{
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
                    //sets the opacity of gameMenu from 0 to 1 over 0,5 seconds
                    ft.setFromValue(1);
                    ft.setToValue(0);

                    ft.setOnFinished(event1 -> gameMenu.setVisible(false));
                    ft.play();
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }


}
