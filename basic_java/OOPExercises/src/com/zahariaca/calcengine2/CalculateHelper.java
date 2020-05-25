package com.zahariaca.calcengine2;

/**
 * Created by azaharia on 30.05.2016.
 */
public class CalculateHelper {
    MathBase command;
    double leftVal;
    double rightVal;
    double result;

    public void process(String statement){
        //add 1.0 2.0
        String[] parts = statement.split(" ");
        String commandString = parts[0];
        leftVal = Double.parseDouble(parts[1]);
        rightVal = Double.parseDouble(parts[2]);

        setCommandString(commandString);
        CalculateBase calculator = null;
        switch (command){
            case Add:
                calculator = new Adder(leftVal, rightVal);
                break;
            case Subtract:
                calculator = new Subtract(leftVal, rightVal);
                break;
            case Multiply:
                calculator = new Multiply(leftVal, rightVal);
                break;
            case Divide:
                calculator = new Divide(leftVal, rightVal);
                break;
        }
        calculator.calculate();
        result = calculator.getResult();
    }

    public void setCommandString(String commandString){
        if(commandString.equalsIgnoreCase(MathBase.Add.toString())){
            command = MathBase.Add;
        }else if(commandString.equalsIgnoreCase(MathBase.Subtract.toString())){
            command = MathBase.Subtract;
        }else if(commandString.equalsIgnoreCase(MathBase.Multiply.toString())){
            command = MathBase.Multiply;
        }else if(commandString.equalsIgnoreCase(MathBase.Divide.toString())){
            command = MathBase.Divide;
        }
    }

    public String toString(){
        char symbol = ' ';

        switch (command){
            case Add:
                symbol = '+';
                break;
            case Subtract:
                symbol = '-';
                break;
            case Multiply:
                symbol = '*';
                break;
            case Divide:
                symbol = '/';
                break;
        }
        return leftVal + " " +  symbol + " " + rightVal + " = " + result;
    }

}
