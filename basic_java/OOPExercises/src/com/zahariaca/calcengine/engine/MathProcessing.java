package com.zahariaca.calcengine.engine;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/23/2016.
 */
public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyword();
    char getSymbol();
    double doCalculations(double leftVal, double rightVal);
}
