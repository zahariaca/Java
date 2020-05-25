package com.zahariaca.calcengine.engine;

/**
 * Created by azaharia on 27.05.2016.
 */
public class Divider extends CalculateBase implements MathProcessing {
    public Divider(){ }
    public Divider(double leftVal, double rightVal){
        super(leftVal, rightVal);
    }

    public void calculate(){
        double result = getLeftVal() / getRightVal();
        setResult(result);
    }
    @Override
    public String getKeyword() {
        return "divide";
    }

    @Override
    public char getSymbol() {
        return '/';
    }

    @Override
    public double doCalculations(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}
