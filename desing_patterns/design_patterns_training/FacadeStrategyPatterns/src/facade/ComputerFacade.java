package facade;

public class ComputerFacade {
	private CPU cpu;
	private Memory ram;
	private HardDrive hardDrive;
	
	private static final long BOOT_ADRESS = 12113;
	
	public ComputerFacade() {
		this.cpu = new CPU();
		this.ram = new Memory();
		this.hardDrive = new HardDrive();
	}
	
	public void start() {
		System.out.println("Start...........");
		byte[] data = hardDrive.read(BOOT_ADRESS, 10);
		ram.load(BOOT_ADRESS, data);
		cpu.execute(BOOT_ADRESS);
		System.out.println("end.............");
	}
}
