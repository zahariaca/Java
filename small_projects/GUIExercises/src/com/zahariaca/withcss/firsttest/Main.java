package com.zahariaca.withcss.firsttest;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 9/15/2016.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btn = new Button("Button");

        TextField txt = new TextField();
        txt.setTranslateX(200);

        Pane root = new Pane();
        root.setPrefSize(800,600);
        root.getChildren().addAll(btn, txt);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("test.css");
        primaryStage.setTitle("Css Test");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
