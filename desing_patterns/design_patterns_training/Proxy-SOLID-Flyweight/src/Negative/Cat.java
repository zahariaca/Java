package Negative;

public class Cat extends Animal{
	
	public Cat(String name) {
		super(name);
	}
	
	@Override
	public void eat() {
		System.out.println(super.getName() + " " + "is eating CAT food");
	}
	
	public void cleanItself() {
		System.out.println(super.getName() + " " + "this cat is taking a bath");
	}

}
