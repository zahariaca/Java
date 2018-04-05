package openclosed.good;

public class CircleShape extends Shape {
	private double radius;
	
	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}

}
