
public class Main {
	public static void main(String[] args) {
		FabricaForma shape = new FabricaForma();
		Forma f1 = shape.getForma(ShapeEnum.DREPTUNGHI.getValue());
		System.out.println(f1 + " " + f1.arie(2, 3));
		Forma f2 = shape.getForma(ShapeEnum.PATRAT.getValue());
		System.out.println(f2 + " " + f2.arie(5, 1));
		Forma f3 = shape.getForma(ShapeEnum.TRIUNGHI.getValue());
		System.out.println(f3 + " " + f3.arie(6, 4));
		Forma f4 = new ResponsabilitateMultipla();
		System.out.println(f4.arie(2, 2));
	}
}
