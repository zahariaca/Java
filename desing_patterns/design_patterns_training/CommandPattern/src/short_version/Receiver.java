package short_version;


public class Receiver {
    String name;
    
    public Receiver(String name) {
    	this.name = name;
    }
    
	public void action() {
		System.out.println("Action " + name + " invoked ");
	}
	
}
