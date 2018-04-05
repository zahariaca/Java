package Negative;

public class Main {
	//NEGATIVE
	public static void eat(Animal animal) {
		animal.eat();
	}
	
	public static void bath(Animal animal) {
		if (animal instanceof Dog) {
			((Dog) animal ).askOwnerForBath();
		} else if (animal instanceof Cat) {
			((Cat) animal).cleanItself();
		} else {
			System.out.println("Bad luck");
		}
			
	}
	
	public static void crash(Animal animal) {
		try {
			((Dog) animal).askOwnerForBath();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Animal animal1 = new Dog("Scooby Doo");
		Animal animal2 = new Cat("Toma");
		Dog dog1 = new Dog("Gigel the dog");
		Cat cat1 = new Cat("Gina the cat");

		Main.bath(animal1);
		Main.bath(animal2);
		Main.bath(dog1);
		Main.bath(cat1);
		
		Main.crash(cat1);
	}
	
	

}
