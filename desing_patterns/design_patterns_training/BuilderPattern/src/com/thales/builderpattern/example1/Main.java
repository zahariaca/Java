package com.thales.builderpattern.example1;

public class Main {
	public static void main(String [] args) {
		Command bp = new Command.Builder()
				.setCommandNumber("EI")
				.setElementNumber("23")
				.setOperatorPlace("0100111")
				.setSequenceNumber("22")
				.setTelegramNumber("12")
				.setTelegramType("EE")
				.build();
		
		System.out.println("Telegram is : " + bp.toString());
	}
}
