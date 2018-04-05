/**
 * Created by azaharia on 06.05.2016.
 */
public class SumAndAverage {
    public static void main(String[] args){
        //Exercise 2.2 - SumAndAverage
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int upperRange = 100;
        int lowerRange = 0;
        int lowerRange1 = 0;
        double average;
        System.out.println("Exercise 2.2 - SumAndAverage - for loop");
        for ( int i = lowerRange;i <= upperRange; i++){
            sum1 += i;
        }
        System.out.printf("The sum is :%s%n", sum1);
        average = (double)sum1 / (double)upperRange;
        System.out.printf("The average is : %s%n", average);

        System.out.println("Exercise 2.2 - SumAndAverage - while loop");
        while(lowerRange <= upperRange){
            sum2 += lowerRange;
            ++lowerRange;
        }
        System.out.printf("The sum is :%s%n", sum2);
        average = (double)sum2 / (double)upperRange;
        System.out.printf("The average is : %s%n", average);

        System.out.println("Exercise 2.2 - SumAndAverage - do while loop");
        do {
            sum3 += lowerRange1;
            ++lowerRange1;
        } while (lowerRange1 <= upperRange);
        System.out.printf("The sum is :%s%n", sum3);
        average = (double)sum3 / (double)upperRange;
        System.out.printf("The average is : %s%n", average);

    }
}
