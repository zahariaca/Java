package observer;
public class Main {
	
	static Logger logger = new Logger();

	public static void main(String[] args) {
		Subject subject = new Subject();
		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		logger.log("###########################");
		logger.log("First state change: 15");
		subject.setState(15);

		logger.log("###########################");
		logger.log("Second state change: 10");
		subject.setState(10);
	}
}
