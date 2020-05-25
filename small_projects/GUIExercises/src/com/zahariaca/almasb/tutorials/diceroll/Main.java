package com.zahariaca.almasb.tutorials.diceroll;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 9/15/2016.
 */
public class Main extends Application {
    private SimpleIntegerProperty target1 = new SimpleIntegerProperty();

    private Parent createContent(){

        Pane root = new Pane();
        root.setPrefSize(800,600);

        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        dice1.setTranslateX(100);
        dice1.setTranslateY(200);

        dice2.setTranslateX(300);
        dice2.setTranslateY(200);

        Button target = new Button("New target");
        target.setOnAction(event -> {
            target1.set((int) (Math.random() * (Dice.MAX_VAL * 2 + 1 )));
        });

        target.setTranslateX(400);
        target.setTranslateY(200);

        SimpleBooleanProperty bool = new SimpleBooleanProperty();
        bool.bind(target1.isEqualTo(dice1.valueProperty.add(dice2.valueProperty)));

        Text message = new Text();
        message.textProperty().bind(target1.asString().concat(" ").concat(bool.asString()));
        message.setTranslateX(100);
        message.setTranslateY(100);

        root.getChildren().addAll(dice1,dice2,message,target);

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());

        primaryStage.setTitle("DiceRollTutorial");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
