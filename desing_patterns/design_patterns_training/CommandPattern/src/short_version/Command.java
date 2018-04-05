package short_version;

public class Command {
	private Receiver element;
	public Command(Receiver element) {
		this.element = element;
	}

	public void execute() {
		element.action();
	}
	
	

}
