package com.zahariaca.javafxwithcalculus;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Alex on 6/7/2016.
 */
public class AlertBox {
    private Calculator calculator;
    private int x;
    private int y;

    public AlertBox() {
    }

    public AlertBox(Calculator calc){
        this.calculator=calc;
    }

    public void display(String title){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Button button = new Button("Close window!");
        button.setOnAction(event -> window.close());

        Label label1 = new Label(calculator.toString());
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label1,button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
