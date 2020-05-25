package facade;

public class Client {
	public static void main(String[] args) {
		ComputerFacade computerFacade = new ComputerFacade();
		computerFacade.start();
	}
}
