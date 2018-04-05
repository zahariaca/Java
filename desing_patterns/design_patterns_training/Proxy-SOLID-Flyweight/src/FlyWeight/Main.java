package FlyWeight;

import java.util.Random;
import java.util.HashMap;

/*
 * Interface to be implmeneted by all objects
 */
interface Human {
	public void mission();
	public void setName(String name);
}

/*
 * Class witch implements the HUMAND interfaces and provides 
 * implementation for the methods + extra info
 */
class Faraon implements Human {
	
	private final String TASK;
	private String name;
	
	public Faraon() {
		this.TASK = "Rule over peasents";
	}
	
	@Override
	public void mission() {
		System.out.println("Faraonul " + this.name + " shall " + this.TASK);
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}

/*
 * Class witch implements the HUMAND interfaces and provides 
 * implementation for the methods + extra info
 */
class Servitor implements Human {

	private final String TASK;
	private String name;
	
	public Servitor() {
		this.TASK = "SERVE VALI";
	}
	
	public void mission() {
		System.out.println("Eu servitorul " + this.name + " shall " + this.TASK);
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}

/*
 * Factory to create objects for the desired 2 classes
 * It only creates one object per class and saves it in a map where the KEY is the type of the object
 * If the same object type is desired again then it is delivered from the MAP
 */
class HumanFactory {
	
	private static HashMap <String, Human> hm = new HashMap<String, Human>();

	public static Human getHuman(String type) {
		Human p = null;

		if (hm.containsKey(type)) {
			p = hm.get(type);
		} else {
			switch(type) {
				case "Servitor":
					System.out.println("Servitor Created");
					p = new Servitor();
					break;
				case "Faraon":
					System.out.println("Faraon Created");
					p = new Faraon();
					break;
				default :
					System.out.println("Unreachable code!");
			}

			hm.put(type, p);
		}
		
		return p;
	}
}

public class Main {
	
	private static String[] humanType = {"Servitor", "Faraon"};

	public static void main(String args[]) {

		for (int i = 0; i < 10; i++) {
			Human p = HumanFactory.getHuman(getRandHumanType());
			p.setName("VALI");
			p.mission();
		}
	}

	public static String getRandHumanType() {
		Random r = new Random();
		int randInt = r.nextInt(humanType.length);
		return humanType[randInt];
	}
}
