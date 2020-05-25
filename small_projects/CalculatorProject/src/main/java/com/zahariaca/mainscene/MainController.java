package com.zahariaca.mainscene;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/7/2016.
 */

public class MainController {
    public void handleSwitchToCalculator(ActionEvent actionEvent) throws IOException {
        System.out.println("Switched scenes");
        Parent calculatorRoot = FXMLLoader.load(getClass().getResource("/main/gui.fxml"));
        Scene calculatorScene = new Scene(calculatorRoot);
        Stage calculatorStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        calculatorStage.setScene(calculatorScene);
        calculatorStage.setTitle("Calculator");
        calculatorStage.show();
        calculatorStage.setResizable(false);
    }
}
