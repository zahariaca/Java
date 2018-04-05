package com.zahariaca.gungame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main extends Application {
    private Rectangle target = new Rectangle(40,40);
    private Gun gun = new Gun();
    private int score = 0;
    private Text scoreText = new Text("Score is: 0");
    private Text nrOfBullets = new Text("You have: " + gun.getClip().getBullets() + " bullets!");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        target.setFill(Color.RED);
        target.setOnMouseClicked(event -> {
            if(!gun.getClip().isEmpty()) {
                if(gun.getMode() == FireMode.SINGLE){
                    score += 100;
                }else if(gun.getMode() == FireMode.TRIPLE){
                    score += 300;
                }else if(gun.getMode() == FireMode.AUTOMATIC){
                    score += gun.getClip().getBullets()*100;
                }

                scoreText.setText("Score is: " + score);
            }
        });

        scoreText.setTranslateX(500);
        scoreText.setTranslateY(62);
        nrOfBullets.setTranslateX(300);
        nrOfBullets.setTranslateY(62);

        ToggleGroup group = new ToggleGroup();
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton chk = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
                switch (chk.getText()){
                    case "Single":
                        gun.setMode(FireMode.SINGLE);
                        break;
                    case "Triple":
                        gun.setMode(FireMode.TRIPLE);
                        break;
                    case "Automatic":
                        gun.setMode(FireMode.AUTOMATIC);
                        break;
                    default:
                        gun.setMode(FireMode.SINGLE);
                        break;
                }
            }
        });


        RadioButton single = new RadioButton("Single");
        single.setTranslateX(10);
        single.setTranslateY(50);
        single.setSelected(true);
        single.setToggleGroup(group);
        RadioButton triple = new RadioButton("Triple");
        triple.setTranslateX(85);
        triple.setTranslateY(50);
        triple.setToggleGroup(group);
        RadioButton auto = new RadioButton("Automatic");
        auto.setTranslateX(160);
        auto.setTranslateY(50);
        auto.setToggleGroup(group);


        Pane targetArea = new Pane();
        targetArea.setPrefSize(600,400);
        targetArea.getChildren().add(target);

        Pane scoreArea = new Pane();
        scoreArea.setPrefSize(600,150);
        scoreArea.getChildren().addAll(scoreText, nrOfBullets, single, triple, auto);


        BorderPane root = new BorderPane();
        root.setCenter(targetArea);
        root.setTop(scoreArea);




        Scene scene= new Scene(root);
        scene.setOnMouseClicked(event -> {
            if(event.getButton()== MouseButton.PRIMARY) {
                gun.fire();
                nrOfBullets.setText("You have: " + gun.getClip().getBullets() + " bullets!");
            }else{
                gun.reload();
                nrOfBullets.setText("You have: " + gun.getClip().getBullets() + " bullets!");
            }
        });

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() ->{
            Platform.runLater(() -> {
                target.setTranslateX(Math.random() * 500);
                target.setTranslateY(Math.random() * 300);
            });
        }, 0, 1, TimeUnit.SECONDS);


        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.show();
    }
}
