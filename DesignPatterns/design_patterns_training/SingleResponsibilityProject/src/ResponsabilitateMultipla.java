
public class ResponsabilitateMultipla extends Forma{

	int suma;
	@Override
	public double arie(int x, int y) {
		this.suma = x + y;
		System.out.println("Arie multipla: Suma este : " + this.suma + " Aria este : " + (x / y));
		return x / y;
	}
	
}
