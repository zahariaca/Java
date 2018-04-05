package com.zahariaca.javafx2;

import javafx.application.Application;
import javafx.scene.AccessibleAction;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * Created by Alex on 6/7/2016.
 */
public class Main extends Application {
    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        window.setTitle("Hello World!");

        Label label1 = new Label("Welcome to the first scene!");
        Button button1 = new Button("Go to scene 2!");
        button1.setOnAction(event -> window.setScene(scene2));

        //Layout 1 - children are laid out in vertical column

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 300, 200);

        Button button2 = new Button("Go to scene 1!");
        button2.setOnAction(event -> window.setScene(scene1));

        //Layout 2 - childern are laid out in  stackpane

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600,300);

        window.setScene(scene1);
        window.show();

    }
}