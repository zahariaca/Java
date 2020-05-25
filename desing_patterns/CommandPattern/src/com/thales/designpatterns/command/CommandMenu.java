package com.thales.designpatterns.command;

import java.util.ArrayList;
import java.util.List;

public class CommandMenu {
	private List<ICommand> listCommands = new ArrayList();
	
	public void addCommand(ICommand command){
		listCommands.add(command);
	}
	
	public void submitCommand() {
		for(ICommand command : listCommands) {
			command.execute();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		listCommands.clear();
	}

	
}
