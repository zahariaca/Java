package openclosed.bad;

public class AreaCalculator {
	public double getAreaBad(Rectangle[] shapes) {
        double area = 0;
        for (Rectangle r : shapes) {
            area += r.getHeight() * r.getWidth();
        }

        return area;
    }
	
	// an improved solution, but not the best (check a much better solution in 'good' package)
	public double getAreaGood(Object[] shapes) {
	    double area = 0;
	    for (Object o :  shapes) {
	        if (o instanceof Rectangle) {
	            Rectangle rectangle = (Rectangle) o;
	            area += rectangle.getHeight() * rectangle.getWidth();
	        }
	        else if (o instanceof Circle) {
	            Circle circle = (Circle) o;
	            area += circle.getRadius() * circle.getRadius() * Math.PI;
	        }
	    }

	    return area;
	}
}
