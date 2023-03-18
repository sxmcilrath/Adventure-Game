package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddC implements Command{
	private Map<String,Command> Calls = new HashMap<String, Command>();
	 private Scanner keyboard;
	
	public AddC(HashMap <String,Command> Calls) {
		keyboard = new Scanner(System.in);
		this.Calls = Calls;
	}
	public void call(String first, String second, Player player) {
		if(second != "") {
		System.out.println("What would command would you like to assign " + second + " too?\n");
		System.out.print("Enter command--> ");
        String command = keyboard.nextLine().toLowerCase();
        
        //if the key exists, gets its value and assigns the new word to the value
        if (this.Calls.containsKey(command)) {
        	this.Calls.put(second, this.Calls.get(command));
        	System.out.println(second + " now " + command + "s.");
        } else {
        	System.out.println(command + " is not a command");
        }
		} else { System.out.println("Cannot add blank command");}
	}
}
