package com.thales.designpatterns.command;

public class SwitchCommand implements ICommand{
	private IElement element;

	public SwitchCommand(IElement element) {
		this.element = element;
	}

	@Override
	public void execute() {
		element.switchElement();
	}
}
