package com.zahariaca.guijavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventDispatchChain;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
    Button button;

    public static void main(String[] args) {
        launch(args);       // call the launch method from Application

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");       //set the title of our Stage(Window)

        button = new Button();  //Create the button
        button.setText("Click me!");    //Text that is displayed on the button
        //button.setOnAction(this);   //set the action that happens when the button is clicked to a handle method inside THIS class
       /* button.setOnAction(new EventHandler<ActionEvent>() {        //create an anonymous inner class that handles what the button does when it is clicked
            @Override
            public void handle(ActionEvent event) {
                System.out.println("IT WORKS OMG OMG!");
            }
        });                                                         //Good job dumb dumb...took you long enough to understand this
        */

        button.setOnAction((ActionEvent e) -> System.out.println("HELO WORLD WITH LAMBDA EXPRESSIONS!!!!!!"));        //need more research on LAMBDA EXPRESSIONS

        StackPane layout = new StackPane(); //create a layout object
        layout.getChildren().add(button);   //add the button to the center of the layout

        //primaryStage.setScene(new Scene(root, 300, 275));
        Scene scene = new Scene(layout,300,250);       //create a scene object
        primaryStage.setScene(scene);       //set primary scene of our program
        primaryStage.show();        //show that primary scene
    }


}
