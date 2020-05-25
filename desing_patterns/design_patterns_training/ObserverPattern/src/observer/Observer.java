package observer;
public abstract class Observer {
	
	protected Subject subject;

	public abstract void update();

	@Override
	public String toString() {
		return "Clasa " + getClass().getName();
	}
}