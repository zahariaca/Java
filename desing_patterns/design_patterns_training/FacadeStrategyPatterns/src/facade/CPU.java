package facade;

public class CPU {
	public void execute(long address) {
		System.out.println(CPU.class.getSimpleName() + " executed on CPU from " + address);
	}
}
