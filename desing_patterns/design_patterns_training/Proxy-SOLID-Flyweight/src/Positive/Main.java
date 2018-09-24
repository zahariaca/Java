package Positive;

public class Main {
	
	// POSITIVE
	public static void eat(Animal animal) {
		animal.eat();
	}
	
	public static void main(String[] args) {
		Animal animal1 = new Dog("Scooby Doo");
		Animal animal2 = new Cat("Tom");
		Dog dog1 = new Dog("Gigel the dog");
		Cat cat1 = new Cat("Gina the cat");
		
		Main.eat(animal1);
		Main.eat(animal2);
		Main.eat(dog1);
		Main.eat(cat1);
	}
	
	

}
