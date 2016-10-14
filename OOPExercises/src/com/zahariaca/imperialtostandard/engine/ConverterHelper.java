package com.zahariaca.imperialtostandard.engine;

/**
 * Created by azaharia on 30.05.2016.
 */
public class ConverterHelper {
    protected static final double IMP_MULTIPLIER = 2.54;
    protected static final double CM_MULTIPLIER = 0.3937;

    ConversionOptions command;
    double conversionVal;
    double result;

    public void process(String statements) throws InvalidStatementException{
        String[] parts = statements.split(" ");
        if(parts.length != 2){
            throw new InvalidStatementException("EXCEPTION only 2 parameters must be input: ", statements);
        }

        String commandString = parts[0];
        try {
            conversionVal = Double.parseDouble(parts[1]);
        }catch (NumberFormatException e){
            throw new InvalidStatementException("EXCEPTION Non-numeric data: ", statements, e);
        }

        setCommandString(commandString);

        if(command == null){
            throw new InvalidStatementException("EXCEPTION Invalid command: ", statements);
        }

        ConverterBase converter = null;
        switch (command){
            case InchesToCentimeters:
                converter = new Converter(conversionVal, IMP_MULTIPLIER);
                converter.calculate();
                result = converter.getResult();
                break;
            case CentimeterToInches:
                converter = new Converter(conversionVal, CM_MULTIPLIER);
                converter.calculate();
                result = Math.round(converter.getResult());
                break;
        }
    }

    private void setCommandString(String commandString){
        if(commandString.equalsIgnoreCase(ConversionOptions.InchesToCentimeters.toString())){
            command = ConversionOptions.InchesToCentimeters;
        }else if(commandString.equalsIgnoreCase(ConversionOptions.CentimeterToInches.toString())){
            command = ConversionOptions.CentimeterToInches;
        }
    }

    @Override
    public String toString(){
        String str = "";
        switch (command) {
            case InchesToCentimeters:
                str = conversionVal + " " + " * " + IMP_MULTIPLIER + " = " + result;
                break;
            case CentimeterToInches:
                str = conversionVal + " " + " * " + CM_MULTIPLIER + " = " + result;
                break;
        }
        return str;
    }

}
