package com.zahariaca.calcengine.engine;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/23/2016.
 */
public class DynamicHelper {
    double leftVal;
    double rightVal;
    double result;
    MathProcessing theHandler = null;
    private MathProcessing[] handlers;

    public DynamicHelper(MathProcessing[] handlers){
        this.handlers=handlers;
    }

    public String process(String statement){
        String[] parts = statement.split(" ");
        String keyword = parts[0];

        for(MathProcessing handler:handlers){
            if(keyword.equalsIgnoreCase(handler.getKeyword())){
                theHandler=handler;
                break;
            }
        }

        leftVal = Double.parseDouble(parts[1]);
        rightVal = Double.parseDouble(parts[2]);
        result = theHandler.doCalculations(leftVal,rightVal);

        return "DynamicHelper{ " + leftVal + " " + theHandler.getSymbol() + " " + rightVal + " = " + result +  "}";
    }
}
