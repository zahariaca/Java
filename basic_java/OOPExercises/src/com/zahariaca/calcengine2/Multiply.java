package com.zahariaca.calcengine2;

/**
 * Created by azaharia on 30.05.2016.
 */
public class Multiply extends CalculateBase {

    public Multiply(){};
    public Multiply(double leftVal, double rightVal){
        super(leftVal,rightVal);
    }

    @Override
    public void calculate(){
        double result = getLeftVal() * getRightVal();
        setResult(result);
    }
}
