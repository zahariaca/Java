package observer;
import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	Logger logger = new Logger();
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		logger.log("Observatorii vor fi notificati cu starea " + state);
		notifyAllObservers();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			logger.log("Update observer " + observer);
			observer.update();
		}
	}
}