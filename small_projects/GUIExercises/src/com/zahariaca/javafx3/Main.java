package com.zahariaca.javafx3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("New Window Demo");
        Button button = new Button("Click me!");
        button.setOnAction(event -> AlertWindow.display("Window", "Message goes here!"));

        StackPane layout1 = new StackPane();
        layout1.getChildren().add(button);
        Scene mainScene = new Scene(layout1,400,200);



        primaryStage.setScene(mainScene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
