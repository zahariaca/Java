/**
 * Created by azaharia on 09.05.2016.
 */
public class NestedLoop {
    public static void main(String[] args){
        System.out.println("Exercise 2.3 - ExtractDigit ");

        int size = 5;

        for ( int row = 1; row <= size; row++){
            for (int col = 1; col <= size; col ++) {
                System.out.print("# ");

            }
            System.out.println();
        }

        System.out.println();
        System.out.println("*****************************************************");


        System.out.println("Exercise 2.3 - CheckerBoard ");

        int size2 = 7;

        for ( int row2 = 1; row2 <= size; row2++){
            for (int col2 = 1; col2 <= size; col2 ++) {
                if (row2 % 2 == 0) {
                    System.out.print("# ");
                }else{
                    System.out.print(" #");
                }

            }
            System.out.println();
        }

        System.out.println();
        System.out.println("*****************************************************");


        System.out.println("Exercise 2.3 - TimeTable ");
        int size3 = 9;
        System.out.print("* |");
        for(int i = 1; i<=size3;i++ ) {

            System.out.format("%6d", i);
        }
        System.out.println();

        System.out.println("------------------------------------------------------------");
        for (int row3 = 1; row3 <= size3; row3++){
            System.out.format("%d |", row3);
            for (int col3 = 1; col3 <= size3; col3++){
                int product = row3 * col3;
                System.out.format("%6d",product);
            }
            System.out.printf("%n");
        }

        System.out.println();
        System.out.println("*****************************************************");

        System.out.println("Exercise 2.3 - PrintPatern ");

        int size4 = 7;
        for ( int row4 = size4; row4 >= 1; row4--){
            for (int col4 = row4; col4 <= size4; col4++) {
                System.out.print("# ");

            }
            System.out.println();
        }

        System.out.println();
        System.out.println("*****************************************************");

        System.out.println("Exercise 2.3 - PrintPatern ");
        for ( int row4 = 1; row4 <= size4; row4++){
            for (int col4 = row4; col4 <= size4; col4++) {
                System.out.print("# ");

            }
            System.out.println();
        }

        System.out.println();
        System.out.println("*****************************************************");

        System.out.println("Exercise 2.3 - PrintPatern ");

        size4 = 7;
        for ( int row4 = size4; row4 >= 1; row4--){
            for (int col4 = row4; col4 <= size4; col4++) {
                System.out.print("# ");

            }
            System.out.println();
        }

        System.out.println();
        System.out.println("*****************************************************");
    }
}
