package com.thales.designpatterns.command;

public class Point implements IElement{
	Logger logger = Logger.getInstance();
    String pointName;
    
    public Point(String pointName) {
    	this.pointName = pointName;
    }
    
	@Override
	public void switchElement() {
		logger.log("Point " + pointName + " switch ");
	}
	@Override
	public void activateElement() {
		logger.log("Point " + pointName + " activate ");
		
	}
	
	
}
