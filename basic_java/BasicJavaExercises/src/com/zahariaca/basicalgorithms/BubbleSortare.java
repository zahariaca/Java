//Sortarea descrescatoare/crescatoare a unui array de tip integer


public class BubbleSortare {

	public static void main(String[] args) {
		int[] arrayInt = {-50,-45,3,4,1,6,7,100,90,78,56,54,-389,87,34,546,675,345};
		int t,j = 0;
		boolean check = false;
		
		while (check == false){
			check = true;
			for(int i = 0; i < arrayInt.length -1; i++){
				if(arrayInt[i] < arrayInt[i +1]){
					t = arrayInt[i +1];
					arrayInt[i +1] = arrayInt[i];
					arrayInt[i] = t;
					check = false;					
				}
			}
			j++;
		}
		System.out.println("Array sortat: ");
		for(int i = 0; i < arrayInt.length; i++){
			System.out.println(arrayInt[i]);
		}
		System.out.printf("Numarul de iteratii: %s %n",j-1);
	}
}


/*
	Se considera array-ul de tip integer arrayInt.
	Se considera variabila de tip integer t si variabila j egala cu 0.
	Se considera variabila de tip boolean check care are valoarea FALSE.
	WHILE ( variabila check este FALSE)
		Seteaza valoarea variabilei check ca TRUE.
		FOR (iteratorul i = 0; iteratorul i mai mic decat arrayInt.length-1; 
			 iteratorul i creste cu 1 la fiecare iteratie)
			 IF ( elementul din arrayInt de la pozitia iteratorului i mai mic decat
			 	  elementul din arrayInt de la pozitia iteratorului i + 1)
			 	  
			 *** pentru sortare crescatoare >>> ( elementul din arrayInt de la pozitia iteratorului i mai mare decat
			 	  elementul din arrayInt de la pozitia iteratorului i + 1)
			 	  
			 	 Variabila t primeste elementul din arrayInt de la pozitia iteratorului +1.
			 	 Elementul din arrayInt de la pozitia iteratorului i este inlocuit de 
			 	 	elementul din arrayInt de la pozitia iteratorului +1.
			 	 Elementul din arrayInt de la pozitia iteratorului +1 este inlocuit de
			 	 	elementul din variabila t.
			 	 Seteaza valoarea variabilei check ca FALSE.
			 END-IF
		END-FOR
		Varibila j creste cu 1 la fiecare iteratie.
	END-WHILE
		Afiseaza mesajul "Sorted array: ".
		FOR (iteratorul i = 0; iteratorul i mai mic decat arrayInt.length;
			 iteratorul i creste cu 1 la fiecare iteratie)
			 Afiseaza valoarea elementului din arrayInt de la pozitia iteratorului.
		END-FOR
		Afiseaza mesajul "Number of iterations: " si valoarea variabilei j-1.
	
*/
