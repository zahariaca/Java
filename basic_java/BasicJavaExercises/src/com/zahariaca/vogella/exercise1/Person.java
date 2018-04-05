package com.zahariaca.vogella.exercise1;

class Person {
	private String mFirstName, mLastName;
	private int mAge;
	private Address address;
	
	public Person(String firstName, String lastName, int age){
		mFirstName = firstName;
		mLastName = lastName;
		mAge = age;
	}
		
	public String getFirstName(){
		return mFirstName;
	}
	public void setFirstName(String firstName){
		mFirstName = firstName;
	}
	
	public String getLastName(){
		return mLastName;
	}
	public void setLastName(String lastName){
		mLastName = lastName;
	}
	
	public int getAge(){
		return mAge;
	}
	public void setAge(int age){
		mAge = age;
	}
	
	public Address getAddress(){
		return address;
	}
	public void setAddress(Address address){
		this.address = address;
	}
	
	public String toString(){
		return " First Name: " + mFirstName + " Last Name:  " + mLastName + " Age:  " + mAge + " Addres is :" + address;
	}
}
