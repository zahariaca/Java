package com.zahariaca.javatpoint.basicsofjava.palindromenumber;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/13/2016.
 */
public class PalindromeNumber {
    private char[] arr;

    public PalindromeNumber(int number){
        String numberToProcess= Integer.toString(number);
        arr = numberToProcess.toCharArray();
        if(testPalindrome() == true){
            System.out.printf("The number: %s is a palindrome %n", number);
        }else{
            System.out.printf("The number: %s is not a palindrome %n", number);
        }
    }
    public boolean testPalindrome(){
        int length=arr.length;
        boolean test = false;
        for(int i = 1 ; i < length; i++){
            if(!(arr[i-1]==arr[length-i])){
                test = false;
                break;
            }
            test=true;
        }
        return test;
    }
}
