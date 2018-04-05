package openclosed.good;

public class RectangleShape extends Shape {
	private double width;
	private double height;
	
	@Override
	public double getArea() {
		return width * height;
	}

}
