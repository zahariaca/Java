package com.zahariaca.javafxwithcalculus;

/**
 * Created by Alex on 6/7/2016.
 */
public class Calculator {
    private int x;
    private int y;
    private int sum;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Calculator(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void calculate(){
        sum = getX()+getY();
    }

    public void tryToSet(int x){
        if (this.x == 0){
            setX(x);
        }else if (!(this.x==0)){
            setY(x);
        }
    }

    @Override
    public String toString() {
        calculate();
        return x + " + "+ y + " = "+ sum;
    }
}
