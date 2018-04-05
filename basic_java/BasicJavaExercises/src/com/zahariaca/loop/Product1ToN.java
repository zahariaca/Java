/**
 * Created by azaharia on 06.05.2016.
 */
public class Product1ToN {
    public static void main(String[] args){
        int lowerRange = 1;
        int upperRange = 13;
        double product = 1;

        System.out.println("Exercise 2.2 - Product1ToN ");
        for (int i = lowerRange; i <= upperRange; i++){
            product *= i;
        }
        System.out.printf("The product is: %s%n", product);
        System.out.println("*****************************************************");

        System.out.println("Exercise 2.2 - HarmonicSum ");
        int maxRange = 5000;
        double sumL2R = 0.0d;
        double sumR2L = 0.0d;
        for (double j = 1; j <= maxRange; j++){
            sumL2R += (1/j);
        }
        System.out.printf("The product is: %s%n", sumL2R);

        for (double k = maxRange; k >= 1; k--){
            sumR2L += (1/k);
        }
        System.out.printf("The product is: %s%n", sumR2L);
        System.out.println("*****************************************************");

        System.out.println("Exercise 2.2 - ComputePI ");
        int maxDenominator = 10000000;
        double sumPI = 0.0d;
        for ( int denominator = 1; denominator <= maxDenominator; denominator+= 2){
            if (denominator % 4 == 1){
                sumPI += 1.0/denominator;
            }else if (denominator % 4 == 3){
                sumPI -= 1.0/denominator;
            }else{
                System.out.println("The computere has gone crazy!");
            }
        }
        sumPI = sumPI * 4;
        System.out.printf("Pi is: %s%n", sumPI);
        if (sumPI == Math.PI){
            System.out.println("Good job");
        }else {
            System.out.println("Almost there");
        }
        System.out.println("*****************************************************");

        System.out.println("Exercise 2.2 - CozaLozaWoza ");
        int lower = 1;
        int upper = 110;
        boolean printed;
        for (int number = lower ; number <= upper; ++number){
            printed = false;
            System.out.print(" ");
            if ( number % 3 == 0){
                System.out.print("Coza");
                printed = true;
            }else if ( number % 5 == 0 ){
                System.out.print("Loza");
                printed = true;
            }else if (number % 7 == 0){
                System.out.print("Woza");
                printed = true;
            }else if ( number % 3 == 0 && number % 5 == 0){
                System.out.print("CozaLoza");
                printed = true;
            }else if ( ! (number % 3 ==0 || number % 5 == 0 || number % 7 == 0 || number % 11 ==0)){
                System.out.print(number);
                printed = true;
            }
            if ( number % 11 == 0 ){
                System.out.print(number);
                System.out.println();
                printed = true;
            }
        }
        System.out.println("*****************************************************");

        System.out.println("Exercise 2.2 - Fibonacci ");
        int m = 0;
        int fminus2 = 1;
        int fminus1 = 1;
        int fn = 0;
        int nMax = 20;

        while ( m <= nMax ){
            System.out.printf(" %s",fn);
            fminus2 = fminus1;
            fminus1 = fn;
            fn = fminus2 + fminus1;
            m++;
        }
        System.out.println();
        System.out.println("*****************************************************");

//        System.out.println("Exercise 2.2 - Tribonacci ");
//        int n = 0;
//        int tfminus3 = 1;
//        int tfminus2 = 0;
//        int tfminus1 = 0;
//        int tfn = 0;
//        int nTMax = 20;
//
//        while ( n <= nTMax ){
//            System.out.printf(" %s",tfn);
//            tfminus3 = tfminus2;
//            tfminus2 = tfminus1;
//            tfminus1 = tfn;
//            tfn = tfminus1 + tfminus2 +tfminus3 ;
//            n++;
//        }
//        System.out.println();
//        System.out.println("*****************************************************");

        System.out.println("Exercise 2.2 - ExtractDigit ");
        
        int number = 1325257698;
        while( number > 0){
            int digit = number % 10;
            System.out.printf(" %s",digit);
            number = number / 10;
        }
        
        System.out.println();
        System.out.println("*****************************************************");
    }
}
