package com.thales.designpatterns.command;
public class Main {
	
	//### singleton with lazy implementation
	static Logger logger = Logger.getInstance();
	static CommandMenu commandMenu = new CommandMenu();
	
	public static void main(String[] args) {
		logger.log("Start program");
		
		Point point1 = new Point("point:dem_sad_349");
		Point point2 = new Point("point:dem_sad_350");
		Track track1 = new Track("track:dem_sad_351");
		Track track2 = new Track("track:dem_sad_352");
		
	    SwitchCommand switchCommand1 = new SwitchCommand(point1);
	    SwitchCommand switchCommand2 = new SwitchCommand(point2);
	    
	    ActivateCommand activateCommand1 = new ActivateCommand(point2);
	    ActivateCommand activateCommand2 = new ActivateCommand(point1);
	    
	    commandMenu.addCommand(activateCommand1);
	    commandMenu.addCommand(switchCommand1);
	    commandMenu.addCommand(switchCommand2);
	    commandMenu.addCommand(activateCommand2);
	    
	    commandMenu.submitCommand();
	    
	   
	    
		logger.log("Finalizare program");
	}
	
	
	
}
