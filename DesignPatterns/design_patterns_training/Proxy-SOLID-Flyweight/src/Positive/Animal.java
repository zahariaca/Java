package Positive;

public abstract class Animal {
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public abstract void eat();
}
