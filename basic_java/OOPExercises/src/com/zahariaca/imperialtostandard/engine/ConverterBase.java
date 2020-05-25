package com.zahariaca.imperialtostandard.engine;

/**
 * Created by azaharia on 30.05.2016.
 */
public abstract class ConverterBase {
    private double conversionVal;
    private double constant;
    private double result;

    public double getConversionVal(){return conversionVal;}
    public void setConversionVal(double conversionVal){ this.conversionVal = conversionVal; }
    public double getConstant(){return constant;}
    public void setConstant(double cosntant){this.constant=cosntant;}
    public double getResult(){return result;}
    public void setResult(double result){ this.result = result;}

    public ConverterBase(){}
    public ConverterBase(double conversionVal, double constant){
        this.conversionVal = conversionVal;
        this.constant = constant;
    }

    public abstract void calculate();
}
