package decorator;

public class Main {

	static Logger logger = new Logger();

	public static void main(String[] args) {
		Shape circle = new Circle();
		Shape redCircle = new RedShapeDecorator(new Circle());
		Shape redRectangle = new RedShapeDecorator(new Rectangle());

		logger.log("################");
		logger.log("Circle with normal border");
		circle.draw();

		logger.log("################");
		logger.log("\nCircle of red border");
		redCircle.draw();

		logger.log("################");
		logger.log("\nRectangle of red border");
		redRectangle.draw();
	}
}
