package com.zahariaca.vogella.exercise1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person("Alex","Zaharia",24);
		Person person2 = new Person("Andrei", "Popescu", 23);
		person2.setFirstName("Ion");
		System.out.println(person1);
		System.out.println(person2);
		
		Person pers = new Person ("Lars", "Vogella", 34);
		pers.setAge(35);
		
		Address address = new Address();
	    address.setCity("Heidelberg");
	    address.setCountry("Germany");
	    address.setNumber("104");
	    address.setPostalCode("69214");
	    address.setStreet("Musterstr");
	    
	    pers.setAddress(address);
	    pers.getAddress().setNumber("105");
	    
	    System.out.println(pers);
	}

}
