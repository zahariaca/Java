package Positive;

public class Dog extends Animal{
	
	public Dog(String name) {
		super(name);
	}
	
	@Override
	public void eat() {
		System.out.println(super.getName() + " " + "is eating DOG food");
	}

}
