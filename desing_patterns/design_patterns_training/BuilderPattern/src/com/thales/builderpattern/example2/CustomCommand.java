package com.thales.builderpattern.example2;

public class CustomCommand {
	private final String cmdName;
	private final String cmdDescription;
	private final String telegram;
	
	private CustomCommand(Builder builder) {
		cmdName = builder.cmdName;
		cmdDescription = builder.cmdDescription;
		telegram = builder.telegram;
	}
	
	public static ITelegram getBuilder() {
		return new Builder();
	}
	
	@Override
	public String toString() {
		return "CustomCommand [cmdName=" + cmdName + ", cmdDescription=" + cmdDescription + ", telegram=" + telegram
				+ "]";
	}

	static class Builder implements ITelegram, ICmdName, ICmdDescription, Build{

		private String cmdName;
		private String cmdDescription;
		private String telegram;
		
		public Builder() {
		}
		
		@Override
		public CustomCommand build() {
			return new CustomCommand(this);
		}

		@Override
		public Build setCmdDescription(String description) {
			cmdDescription = description;
			return this;
		}

		@Override
		public ICmdDescription setCmdName(String name) {
			cmdName = name;
			return this;
		}

		@Override
		public ICmdName setTelegram(String val) {
			telegram = val;
			return this;
		}
		
	}
	
	public interface ITelegram{
		ICmdName setTelegram(String val);
	}
	
	public interface ICmdName{
		ICmdDescription setCmdName(String name);
	}
	
	public interface ICmdDescription{
		Build setCmdDescription(String description);
	}
	
	public interface Build{
		CustomCommand build();
	}
}
