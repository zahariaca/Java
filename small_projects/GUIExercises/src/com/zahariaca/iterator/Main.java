package com.zahariaca.iterator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    int i = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{

        TextField txtField = new TextField();
        txtField.autosize();
        txtField.setText("Iterate here");

        Button button = new Button("+1");
        button.setOnAction(event -> {
            i++;
            txtField.setText(String.valueOf(i));
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(8);
        grid.add(txtField, 0,0);
        grid.add(button,0,1);


        Scene scene = new Scene(grid);

        primaryStage.setTitle("Iterator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
