package com.zahariaca.custom;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 9/15/2016.
 */
public class Main extends Application {

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(350,300);
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        root.setPrefSize(300,150);

        Menu menu = new Menu();
        root.getChildren().add(menu);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Test Custom Component");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
