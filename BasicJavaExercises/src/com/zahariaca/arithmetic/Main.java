package com.zahariaca.arithmetic;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.checkNrOfArgs(args);
        main.checkIfNr(args);
        main.print(args);
    }

    private void checkNrOfArgs(String[] args){
        if(args.length != 3){
            System.err.print("Usage: java Arithmetic int1 int2 op");
            return;
        }
    }

    private void checkIfNr(String[] args){
        for (int i=0; i<args.length-1; i++){
            try{
                Integer.parseInt(args[i]);
            }catch(NumberFormatException e){
                System.err.print("Not an integer");
            }
        }
    }

    private void print(String[] args){
        System.out.println(args[0] + args[2] + args[1] + "=" + operand(args));

    }

    public double operand(String[] args){
        char operand = args[2].charAt(0);
        int operand1 = Integer.parseInt(args[0]);
        int operand2 = Integer.parseInt(args[1]);
        double result = 0;

        switch(operand){
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case ':':case '/':
                result = operand1 / operand2;
                break;
            case '%':
                result = operand1 % operand2;
                break;
            default :
                System.err.print("Something went wrong!");
                break;
        }
        return result;
    }
}
