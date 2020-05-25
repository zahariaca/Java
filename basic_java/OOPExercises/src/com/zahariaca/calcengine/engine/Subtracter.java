package com.zahariaca.calcengine.engine;

/**
 * Created by azaharia on 27.05.2016.
 */
public class Subtracter extends CalculateBase implements MathProcessing{

    public Subtracter(){ }
    public Subtracter(double leftVal, double rightVal){
        super(leftVal,rightVal);
    }

    @Override
    public void calculate(){
        double result = getLeftVal() - getRightVal();
        setResult(result);
    }

    @Override
    public String getKeyword() {
        return "subtract";
    }

    @Override
    public char getSymbol() {
        return '-';
    }

    @Override
    public double doCalculations(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}
