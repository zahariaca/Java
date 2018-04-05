package com.thales.builderpattern.example2;

public class Main {
	public static void main(String[] args) {
		CustomCommand custom = CustomCommand.getBuilder().setTelegram("Signal")
				.setCmdName("MS").setCmdDescription("Set Signal State").build();
		
		System.out.println("Signal telegram : " + custom);
	}
}
