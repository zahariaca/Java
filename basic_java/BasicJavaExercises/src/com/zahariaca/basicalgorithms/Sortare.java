package com.zahariaca.basicalgorithms;//Sortarea descrecatoare/crescatoare a unui array cu Arrays.sort() si Collections.reverseOrder().

import java.util.Arrays;
import java.util.Collections;

public class Sortare {
	
	public static void main (String args[]){
		Integer[] arrayInt = {-50,-45,3,4,1,6,7,100,90,78,56,54,-389,87,34,546,675,345};
		
		System.out.println("Array sortat: "); 
		Arrays.sort(arrayInt, Collections.reverseOrder());
		for(int i = 0; i < arrayInt.length; i++){
			System.out.println(arrayInt[i]);
		}
	}

}


/*
	Se importa java.util.Arrays.
	Se considera array-ul de tip Integer arrayInt.
	Se foloseste metoda sort cu parametrul arrayInt.
	
	*** pentru crescator >>> adaugam la parametrul, dupa array-ul nostru arrayInt, , Collections.reverseOrder().
	
	Afiseaza mesajul "Array sortat: ".
		FOR (iteratorul i = 0; iteratorul i mai mic decat arrayInt.length;
			 iteratorul i creste cu 1 la fiecare iteratie)
			 Afiseaza valoarea elementului din arrayInt de la pozitia iteratorului.

*/