package com.zahariaca.javafxwithcalculus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application  {
    Calculator calculator= new Calculator(0,0);


    public static void main(String[] args){
        launch(args);

    }

    public void start(Stage primaryStage) throws Exception{

        TextField textView = new TextField();
        textView.setPrefColumnCount(9);
        textView.setPrefHeight(400);

        Button button = new Button("Calculate!");
        //button.setOnAction(event ->  new AlertBox(calculator).display("Calculation"));
        button.setOnAction(event -> textView.setText(calculator.toString()));
        Button btn0 = new Button("0");
        btn0.setOnAction(event -> calculator.tryToSet(0));
        Button btn1 = new Button("1");
        btn1.setOnAction(event -> calculator.tryToSet(1));
        Button btn2 = new Button("2");
        //btn2.setOnAction(event -> calculator.tryToSet(2));
        btn2.setOnAction(event -> textView.appendText("2"));
        Button btn3 = new Button("3");
        btn3.setOnAction(event -> calculator.tryToSet(3));
        Button btn4 = new Button("4");
        btn4.setOnAction(event -> calculator.tryToSet(4));
        Button btn5 = new Button("5");
        btn5.setOnAction(event -> calculator.tryToSet(5));
        Button btn6 = new Button("6");
        btn6.setOnAction(event -> calculator.tryToSet(6));
        Button btn7 = new Button("7");
        btn7.setOnAction(event -> calculator.tryToSet(7));
        Button btn8 = new Button("8");
        btn8.setOnAction(event -> calculator.tryToSet(8));
        Button btn9 = new Button("9");
        btn9.setOnAction(event -> calculator.tryToSet(9));
        Button btnPlus = new Button("+");
        btnPlus.setOnAction(event -> textView.appendText("+"));
        Button btnMinus = new Button("-");

        Label label1 = new Label("Calculate - only simple number 0-9");

        HBox hbox = new HBox();
        hbox.getChildren().add(button);

        VBox vbox = new VBox();
        vbox.getChildren().add(textView);

        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(5);
        grid.setHgap(5);

        grid.add(btn7,0,0);
        grid.add(btn8,1,0);
        grid.add(btn9,2,0);
        grid.add(btn4,0,1);
        grid.add(btn5,1,1);
        grid.add(btn6,2,1);
        grid.add(btn1,0,2);
        grid.add(btn2,1,2);
        grid.add(btn3,2,2);
        grid.add(btn0,0,3);
        grid.add(btnPlus,1,3);
        grid.add(btnMinus,2,3);


        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setTop(label1);
        pane.setCenter(grid);
        pane.setBottom(hbox);
        pane.setRight(vbox);


        Scene scene = new Scene(pane,250,200);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
