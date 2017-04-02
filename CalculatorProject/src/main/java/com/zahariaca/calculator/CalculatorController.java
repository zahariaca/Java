package com.zahariaca.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.*;
import javafx.stage.Stage;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.ast.StringLiteral;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CalculatorController {
    @FXML
    TextArea textArea = new TextArea("");
    int counter = 0;

    public void keyPressed(KeyEvent keyEvent) {
        System.out.println(keyEvent.getCode());
        switch (keyEvent.getCode()){
            case MINUS: case SUBTRACT:
                textArea.appendText("-");
                break;
            case PLUS: case ADD:
                textArea.appendText("+");
                break;
            case SLASH: case DIVIDE:
                textArea.appendText("/");
                break;
            case ASTERISK: case MULTIPLY:
                textArea.appendText("*");
                break;
            case DELETE:
                delete();
                break;
            case DIGIT1: case NUMPAD1:
                textArea.appendText("1");
                break;
            case DIGIT2: case NUMPAD2:
                textArea.appendText("2");
                break;
            case DIGIT3: case NUMPAD3:
                textArea.appendText("3");
                break;
            case DIGIT4: case NUMPAD4:
                textArea.appendText("4");
                break;
            case DIGIT5: case NUMPAD5:
                textArea.appendText("5");
                break;
            case DIGIT6: case NUMPAD6:
                textArea.appendText("6");
                break;
            case DIGIT7: case NUMPAD7:
                textArea.appendText("7");
                break;
            case DIGIT8:
                if(keyEvent.isShiftDown()){
                    textArea.appendText("*");
                }else{
                    textArea.appendText("8");
                }
                break;
            case NUMPAD8:
                textArea.appendText("8");
                break;
            case DIGIT9:
                if(keyEvent.isShiftDown()){
                    textArea.appendText("(");
                }else{
                    textArea.appendText("9");
                }
                break;
            case NUMPAD9:
                textArea.appendText("9");
                break;
            case DIGIT0:
                if(keyEvent.isShiftDown()){
                    textArea.appendText(")");
                }else{
                    textArea.appendText("0");
                }
                break;
            case NUMPAD0:
                textArea.appendText("0");
                break;
            case EQUALS: case ENTER:
                if(keyEvent.isShiftDown()){
                    textArea.appendText("+");
                }else{
                    calculateResultAndSet();
                }
                break;
            case PERIOD: case DECIMAL:
                textArea.appendText(".");
            default:
                textArea.appendText("");
                break;
        }
    }
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button) {
            Button clickedBtn = (Button) mouseEvent.getSource();
            switch (clickedBtn.getId()){
                case "btnSubtract":
                    textArea.appendText("-");
                    break;
                case "btnAdd":
                    textArea.appendText("+");
                    break;
                case "btnDivide":
                    textArea.appendText("/");
                    break;
                case "btnMultiply":
                    textArea.appendText("*");
                    break;
                case "btnC":
                    textArea.setText("");
                    break;
                case "btnDel":
                    delete();
                    break;
                case "btnOne":
                    textArea.appendText("1");
                    break;
                case "btnTwo":
                    textArea.appendText("2");
                    break;
                case "btnThree":
                    textArea.appendText("3");
                    break;
                case "btnFour":
                    textArea.appendText("4");
                    break;
                case "btnFive":
                    textArea.appendText("5");
                    break;
                case "btnSix":
                    textArea.appendText("6");
                    break;
                case "btnSeven":
                    textArea.appendText("7");
                    break;
                case "btnEight":
                    textArea.appendText("8");
                    break;
                case "btnNine":
                    textArea.appendText("9");
                    break;
                case "btnZero":
                    textArea.appendText("0");
                    break;
                case "btnParanthesis":
                    checkParenthesis();
                    break;
                case "btnEquals":
                    calculateResultAndSet();
                    break;
                case "btnPeriod":
                    textArea.appendText(".");
                    break;
                default:
                    textArea.appendText("TESTING");
                    break;
            }
        }
    }

    public void calculateResultAndSet(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ExpressionParser parser = new SpelExpressionParser();
                double result = parser.parseExpression(textArea.getText()).getValue(Double.class);
                if(result % 1 == 0){
                    textArea.setText(String.valueOf((int) result));
                }else {
                    textArea.setText(String.valueOf(result));
                }
            }
        }).start();
    }

    public void delete(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> items = new LinkedList<String>(Arrays.asList(textArea.getText().split("(?<=[\\W|\\d])|(?=[\\W|\\d])")));
                if(items.get(items.size()-1).toString().equals("(")){
                    counter--;
                }else if(items.get(items.size()-1).toString().equals(")")){
                    counter++;
                }
                items.remove(items.size()-1);
                System.out.println(items.size());
                textArea.setText("");
                ListIterator iterator = items.listIterator();
                while(iterator.hasNext()){
                    textArea.appendText(iterator.next().toString());
                }
            }
        }).start();
    }

    public void checkParenthesis(){
        String[] split = textArea.getText().split("(?<=[\\W|\\d])|(?=[\\W|\\d])");
        if(split[split.length-1].equals(")") || isNumeric(split[split.length-1])){
            if(counter != 0){
                textArea.appendText(")");
                counter--;
            }
        }else{
            textArea.appendText("(");
            counter++;
        }
    }
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        Parent mainRoot = FXMLLoader.load(getClass().getResource("/main/mainGui.fxml"));
        Scene mainScene = new Scene(mainRoot);
        Stage mainStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.show();
        mainStage.setResizable(false);
    }
}
