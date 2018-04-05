package com.thales.designpatterns.command;

public class Track implements IElement{
	Logger logger = Logger.getInstance();
	
	String trackName;
	
	public Track(String trackName) {
		this.trackName = trackName;
	}

	@Override
	public void switchElement() {
		logger.log("Track " + trackName + " switched");
	}

	@Override
	public void activateElement() {	
		logger.log("Track " + trackName + " activated");
	}

}
