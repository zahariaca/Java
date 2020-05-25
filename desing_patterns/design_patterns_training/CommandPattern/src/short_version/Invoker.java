package short_version;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	private List<Command> listCommands = new ArrayList<Command>();
	
	public void addCommand(Command command){
		listCommands.add(command);
	}
	
	public void invoke() {
		for(Command command : listCommands) {
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
