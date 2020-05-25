//Afisati minimul sau maximul din array


public class MinimMaxim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] arrayInt = {50,45,3,4,1,6,7,100,90,78,56,54,389};
			int min = arrayInt[0];
			for (int i=0; i <= arrayInt.length -1; i++ ){
				if (arrayInt[i] < min){
					min = arrayInt[i];
				}
			}
			System.out.println(min);
	}

}

/*
	Se considera un array de tip integer numit arrayInt.
	Variabila de tip integer min este egala cu primul element al array.
	FOR(iteratorul i = 0; cat timp iteratorul i este mai mic sau egal decat numarul de elemente din array; 
		iteratorul i creste 1 la fiecare iteratie)
		IF ( elemntul din array de la pozitia echivalenta valorii iteratorului < variabila min)
			variabila min preia valoarea elementului din array de la pozitia echivalenta valorii iteratorului
		END-IF
	END-FOR
	Afiseaza valoarea variabilei min
	
	***pentru maxim >>> elemntul din array de la pozitia echivalenta valorii iteratorului > variabila min
 */
