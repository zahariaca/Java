package facade;

public class Memory {
	public void load(long position, byte[] data) {
		System.out.println(Memory.class.getSimpleName()+ " data loaded at " + position);
	}
}
