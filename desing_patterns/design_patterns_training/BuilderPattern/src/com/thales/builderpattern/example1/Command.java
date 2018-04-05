package com.thales.builderpattern.example1;

public class Command {

	private String telegramType;
	private String operatorPlace;
	private String telegramNumber;
	private String sequenceNumber;
	private String elementNumber;
	private String commandNumber;
	
	private Command(Builder builder) {
		super();
		this.telegramType = builder.telegramType;
		this.operatorPlace = builder.operatorPlace;
		this.telegramNumber = builder.telegramNumber;
		this.sequenceNumber = builder.sequenceNumber;
		this.elementNumber = builder.elementNumber;
		this.commandNumber = builder.commandNumber;
	}
	
	
	
	@Override
	public String toString() {
		return "BuilderPattern [telegramType=" + telegramType + ", operatorPlace=" + operatorPlace + ", telegramNumber="
				+ telegramNumber + ", sequenceNumber=" + sequenceNumber + ", elementNumber=" + elementNumber
				+ ", commandNumber=" + commandNumber + "]";
	}



	static class Builder{
		private String telegramType;
		private String operatorPlace;
		private String telegramNumber;
		private String sequenceNumber;
		private String elementNumber;
		private String commandNumber;
		
		public Builder setTelegramType(String telegramType) {
			this.telegramType = telegramType;
			return this;
		}
		public Builder setOperatorPlace(String operatorPlace) {
			this.operatorPlace = operatorPlace;
			return this;
		}
		public Builder setTelegramNumber(String telegramNumber) {
			this.telegramNumber = telegramNumber;
			return this;
		}
		public Builder setSequenceNumber(String sequenceNumber) {
			this.sequenceNumber = sequenceNumber;
			return this;
		}
		public Builder setElementNumber(String elementNumber) {
			this.elementNumber = elementNumber;
			return this;
		}
		public Builder setCommandNumber(String commandNumber) {
			this.commandNumber = commandNumber;
			return this;
		}
		
		public Command build() {
			return new Command(this);
		}
		
	}
	
}
