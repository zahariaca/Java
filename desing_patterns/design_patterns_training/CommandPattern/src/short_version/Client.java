package short_version;
public class Client {
	
	public static void main(String[] args) {
		Invoker commandMenu = new Invoker();
		Receiver receiver = new Receiver("test");

		Command command = new Command(receiver);

		commandMenu.addCommand(command);
	    
	    commandMenu.invoke();
	}
	
	
	
}
