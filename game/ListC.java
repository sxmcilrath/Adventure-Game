package game;

public class ListC implements Command{
	private String[] commands;


	
	public ListC(String[] commands) {
		this.commands = commands;
	}
	public void call(String first, String second, Player player) {
		System.out.println( "Options: ");
     	for(int i = 0; i < commands.length; i++) {        	
     		System.out.println(commands[i]);     
     	}
	}
}

