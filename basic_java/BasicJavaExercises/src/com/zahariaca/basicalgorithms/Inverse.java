//Afisati inversul arrayului


public class Inverse {

	public static void main(String[] args) {
		char[] letters ={'a','b', 'c', 'd', 'e'};
		for (int i= letters.length - 1; i>=0; i--){
			System.out.println(letters[i]);
		}
	}

}

/*
	Se considera un array de tip char numit letters
	For (iteratorul i = nr de elemente array - 1; cat timp iteratorul i este mai mare sau egal cu 0;
		 iteratorul i scade cu 1 la fiecare iteratie)
		 Afiseaza elemntul din array de la pozitia echivalenta valorii iteratorului.
*/