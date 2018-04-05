package openclosed.good;

public class AreaCalculatorShape {

	public double getShapeArea(Shape[] shapes) {
	    double area = 0;
	    for (Shape shape : shapes) {
	        area += shape.getArea();
	    }

	    return area;
	}
}
