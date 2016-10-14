package com.chat.test;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Alex on 6/7/2016.
 */


public class LoginDialog {
    private String username;
    private String password;
    private static boolean cancelled;

    public void display(){
        Label label1 = new Label();
        Label username = new Label();
        Label password = new Label();

        TextField usernameField = new TextField();
        TextField passwordField = new TextField();

        Button okButton;
        Button closeButton;

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Login");
        window.setMinWidth(250);


        label1.setText("Please enter your credentials!");
        username.setText("Username");
        password.setText("Password");


        okButton = new Button("OK");
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setUsername(usernameField.getText());
                setPassword(passwordField.getText());
                cancelled = false;
                window.close();
            }
        });
        closeButton = new Button("Close the window!");
        closeButton.setOnAction(event -> {
            cancelled = true;
            window.close();
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(8);
        grid.add(username,0,0);
        grid.add(password,0,1);
        grid.add(usernameField,1,0);
        grid.add(passwordField,1,1);
        grid.add(okButton,0,2);
        grid.add(closeButton,1,2);

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(5,5,5,5));
        layout.setTop(label1);
        layout.setCenter(grid);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean isCancelled(){
        return cancelled;
    }
}
