package com.zahariaca.calcengine.engine;

/**
 * Created by azaharia on 27.05.2016.
 */
public class CalculateHelper {
    private static final char ADD_SYMBOL = '+';
    private static final char MINUS_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';
    MathCommand command;
    double leftVal;
    double rightVal;
    double result;

    public void process(String statement) throws InvalidStatementException{
        //add 1.0 2.0
        String[] parts = statement.split(" ");
        if(parts.length != 3){
            throw new InvalidStatementException("Incorrect number of fields: ", statement);
        }

        String commandString = parts[0]; //add
        try {
            leftVal = Double.parseDouble(parts[1]); //1.0
            rightVal = Double.parseDouble(parts[2]); //2.0
        }catch (NumberFormatException e){
            throw new InvalidStatementException("Non-numeric data: ", statement, e);
        }

        setCommandFromString(commandString);

        if (command == null){
            throw new InvalidStatementException("Invalid command: ", statement);
        }

        CalculateBase calcutor = null;
        switch (command){
            case Add:
                calcutor = new Adder(leftVal, rightVal);
                break;
            case Subtract:
                calcutor = new Subtracter(leftVal, rightVal);
                break;
            case Multiply:
                calcutor = new Multiplier(leftVal, rightVal);
                break;
            case Divide:
                calcutor = new Divider(leftVal, rightVal);
        }

        calcutor.calculate();
        result = calcutor.getResult();
    }

    private void setCommandFromString(String commandString){
        if(commandString.equalsIgnoreCase(MathCommand.Add.toString())){
            command = MathCommand.Add;
        }else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString())){
            command = MathCommand.Subtract;
        }else if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString())){
            command = MathCommand.Multiply;
        }else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString())){
            command = MathCommand.Divide;
        }
    }

    @Override
    public String toString(){
        char symbol = ' ';

        switch (command){
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = MINUS_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
        }
        return leftVal + " " + symbol + " " + rightVal + "=" + result;
    }

}
