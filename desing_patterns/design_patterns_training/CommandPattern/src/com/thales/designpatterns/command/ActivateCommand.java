package com.thales.designpatterns.command;

public class ActivateCommand implements ICommand{
	
	private IElement element;
	
	public ActivateCommand(IElement element){
		this.element = element;
	}
	
	@Override
	public void execute() {
		element.activateElement();
	}

}
