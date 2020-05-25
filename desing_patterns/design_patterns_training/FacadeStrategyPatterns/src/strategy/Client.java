package strategy;

import java.util.ArrayList;

public class Client {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("specify compress strategy: RAR or ZIP");
			return;
		}
		
		String strategy = args[0];
		CompressionContext compressContext = new CompressionContext();
		if ("RAR".equals(strategy)){
			compressContext.setCompressionStrategy(new RarCompressionStrategy());
		} else if ("ZIP".equals(strategy)) {
			compressContext.setCompressionStrategy(new ZipCompressionStrategy());
		}
		
		compressContext.createArchive(new ArrayList<>());
		
	}
}
