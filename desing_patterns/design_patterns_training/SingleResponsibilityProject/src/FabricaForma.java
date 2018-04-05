
public class FabricaForma {
	public Forma getForma(int code) {
		if(code == 1) {
			return new Dreptunghi();
		} else if(code == 2) {
			return new Patrat();
		} else if(code == 3) {
			return new Triunghi();
		}
		return null;
	}
}
