import java.util.ArrayList;

//Proxy pattern
public class Proxy {

	public static void main(String[] args) {
		JavaFrameWork frameWork = new JavaFrameWork();
		frameWork.start("sim1");
		frameWork.start("sim2");
		frameWork.stop("sim1");
		frameWork.stop("sim2");
	}
}

interface IJavaFrameWork {
	void start(String simName);
	void stop(String simName);
}

class Simulator implements IJavaFrameWork {

	private String simName;

	public Simulator(String simName){
		this.simName = simName;
	}

	@Override
	public void start(String simName) {
		System.out.println("Starting " + simName);
		heavyProcessing(simName);
	}

	@Override
	public void stop(String simName) {
		System.out.println("Stopping " + simName);
	}

	private void heavyProcessing(String simName){
		System.out.println("HEAVY PROCESSING START " + this.simName);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("HEAVY PROCESSING STOP " + this.simName);
	}

	public String getSimName(){
		return this.simName;
	}
}

class JavaFrameWork implements IJavaFrameWork {

	private ArrayList<Simulator> simulators;

	public JavaFrameWork(){
		simulators = new ArrayList<>();
	}


	private boolean containsSimulator(String sim) {
		for (Simulator simulator : simulators) {
			if (simulator.getSimName().equals(sim)) {
				return true;
			}
		}

		return false;
	}
	
	private Simulator getSimulator(String sim) {
		for (Simulator simulator : simulators) {
			if (simulator.getSimName().equals(sim)) {
				return simulator;
			}
		}
		return null;
	}

	@Override
	public void start(String simName) {
		if (!containsSimulator(simName)) {
			simulators.add(new Simulator(simName));
		}
		
		Simulator sim = getSimulator(simName);
		
		if (sim != null) {
			sim.start(simName);
		}
	}


	@Override
	public void stop(String simName) {
		if (!containsSimulator(simName)) {
			simulators.add(new Simulator(simName));
		}
		
		Simulator sim = getSimulator(simName);
		
		if (sim != null) {
			sim.stop(simName);
		}
	}
}