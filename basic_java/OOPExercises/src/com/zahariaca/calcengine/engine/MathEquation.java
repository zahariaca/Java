package com.zahariaca.calcengine.engine;

/**
 * Created by azaharia on 05.05.2016.
 */
public class MathEquation {
    private double leftVal;
    private double rightVal;
    private double results;
    private char opCodes;

    public double getLeftVal(){
        return leftVal;
    }
    public void setLeftVal(double leftVal){
        this.leftVal = leftVal;
    }
    public double getRightVal(){
        return rightVal;
    }
    public void setRightVal(double rightVal){
        this.rightVal = rightVal;
    }
    public double getResults(){
        return results;
    }
    public char getOpCodes(){
        return opCodes;
    }
    public void setOpCodes(char opCodes){
        this.opCodes = opCodes;
    }

    public MathEquation() {

    }
    public MathEquation(char opCodes){
        this.opCodes = opCodes;
    }
    public MathEquation(char opCodes, double leftVal, double rightVal){
        this(opCodes);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public void execute(){
        switch (opCodes) {
            case 'a':
                results = leftVal + rightVal;
                break;
            case 's':
                results = leftVal - rightVal;
                break;
            case 'd':
                if (rightVal != 0.0d) {
                    results = leftVal / rightVal;
                } else {
                    System.out.println("Cannot divide by 0");
                    results = 0.0d;
                }
                break;
            case 'm':
                results = leftVal * rightVal;
                break;
            default:
                System.out.println("Error - invalid opCode");
                results = 0.0d;
                break;
        }
    }

    public void execute(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }
}
