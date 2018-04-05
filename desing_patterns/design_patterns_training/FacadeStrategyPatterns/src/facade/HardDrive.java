package facade;

public class HardDrive {
	public byte[] read(long address, int size){
		System.out.println(HardDrive.class.getSimpleName() + ": " + size + " bytes read from " + address);
		return new byte[size];
	}
}
