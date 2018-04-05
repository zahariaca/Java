package com.zahariaca.imperialtostandard.engine;

/**
 * Created by azaharia on 30.05.2016.
 */
public class Converter extends ConverterBase {
    public Converter(){}
    public Converter(double conversionVal,double constant){
        super(conversionVal, constant);
    }

    @Override
    public void calculate(){
        double result = getConversionVal() * getConstant();
        setResult(result);
    }
}
