package Positive;

public class Cat extends Animal{
	
	public Cat(String name) {
		super(name);
	}
	
	@Override
	public void eat() {
		System.out.println(super.getName() + " " + "is eating CAT food");
	}

}
