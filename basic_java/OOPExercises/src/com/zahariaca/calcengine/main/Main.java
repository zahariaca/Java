package com.zahariaca.calcengine.main;


import com.zahariaca.calcengine.engine.*;

public class Main {

    public static void main(String[] args) {
/*      double [] leftVal = {100.0d, 25.0d, 225.0d, 11.0d};
        double [] rightVal = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];*/

        //useMathEquations();
        //useCalculateBase();
        //useCalculateHelper();
        useDynamicHelper();


    }

    public static void useDynamicHelper(){

        String[] statements ={
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };
        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new Subtracter(),
                new Multiplier(),
                new Divider()
        });
        for (String statement:statements){
            System.out.println(helper.process(statement));
        }
    }

    static void useCalculateHelper(){
        String[] statements = {
                "add 1.0",
                "add xx 25.0",
                "addX 0.0 0.0",
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };

        CalculateHelper helper = new CalculateHelper();
        for (String statement:statements){
            try {
                helper.process(statement);
                System.out.printf("The result is: %s%n", helper.toString());
            }catch (InvalidStatementException e){
                System.out.println(e.getMessage());
                if(e.getCause() != null){
                    System.out.println(" Original exception: " + e.getCause().getMessage());
                }
            }
        }
    }

    static void useMathEquations() {
            MathEquation[] equations = new MathEquation[4];
            equations[0] = new MathEquation('d', 100.0d, 50.0d);
            equations[1] = new MathEquation('a', 25.0d, 92.0d);
            equations[2] = new MathEquation('s', 225.0d, 17.0d);
            equations[3] = new MathEquation('m', 11.0d, 3.0d);

            for (MathEquation equation : equations) {
                equation.execute();
                System.out.printf("The result is: %s%n", equation.getResults());
            }
            System.out.println("**************************************************");

            double leftDouble = 9.0d;
            double rightDouble = 4.0d;
            MathEquation equationOverload = new MathEquation('d');
            equationOverload.execute(leftDouble, rightDouble);
            System.out.printf("The overload result is: %s%n", equationOverload.getResults());
        }
    static void useCalculateBase() {
        System.out.println();
        System.out.println("Solution through inheritance");
        System.out.println();

        CalculateBase[] calculate = {
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d),
                new Divider(100.0d, 50.0d)
        };
        for (CalculateBase calculator : calculate) {
            calculator.calculate();
            System.out.printf("result= %s%n", calculator.getResult());
        }
    }
}
