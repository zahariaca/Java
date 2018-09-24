package Negative;

public class Dog extends Animal{
	
	public Dog(String name) {
		super(name);
	}
	
	@Override
	public void eat() {
		System.out.println(super.getName() + " " + "is eating DOG food");
	}
	
	public void askOwnerForBath() {
		System.out.println(super.getName() + " " + " is forced to take a bath");
	}

}
