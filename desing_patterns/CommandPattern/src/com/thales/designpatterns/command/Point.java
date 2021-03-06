package com.thales.designpatterns.command;

public class Point implements IElement{
	Logger logger = Logger.getInstance();
    String pointName;
    
    public Point(String pointName) {
    	this.pointName = pointName;
    }
    
	@Override
	public void switchElement() {
		logger.log("Receiver " + pointName + " switch ");
	}
	@Override
	public void activateElement() {
		logger.log("Receiver " + pointName + " activate ");
		
	}
	
	
}
