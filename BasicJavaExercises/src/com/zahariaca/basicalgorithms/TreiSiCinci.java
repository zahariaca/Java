import java.util.Scanner;

public class TreiSiCinci {

	public static void main(String[] args) {
		double sum = 0;
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Please input a number:");
		double j = kb.nextDouble();
		kb.close();
		for (int i=0; i<j; i++){
			if(i%3 == 0 || i%5 == 0){
				sum = sum +i;
			}
		}
		System.out.println(sum);

	}

}

/*
	Se considera variabila double sum initializata cu valoarea 0.
	Se creeaza un nou obiect kb de tip Scanner.
	Se afiseaza mesajul "Please input a number:".
	Se accepta de la user o valoare introdusa si se stocheaza valoarea in variabila double j.
	FOR (iteratorul i = 0; cat timp iteratorul mai mic decat valoarea variabile j; iteratorul i creste cu 1 la fiecare iteratie)
		IF ( iteratorul i impartit la 3 are rest 0 sau iteratorul i impartit la 5 are rest 0)
			Stocheaza in variabila sum suma dintre valoarea variabilei sum si iteratorul i.
		END-IF
	END-FOR
	Afiseaza valoarea variabilei sum.
	
*/