package com.thales.designpatterns.command;

public class ActivateCommand implements ICommand{
	
	private Point point;
	
	public ActivateCommand(Point point){
		this.point = point;
	}
	
	@Override
	public void execute() {
		point.activateElement();
	}

}
