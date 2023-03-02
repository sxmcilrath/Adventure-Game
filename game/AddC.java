package game;

import java.util.HashMap;
import java.util.Scanner;

public class AddC implements Command{
	private HashMap<String,Command> Calls = new HashMap<String, Command>();
	 private Scanner keyboard;
	 private Game game;
	
	public AddC(HashMap <String,Command> Calls, Game game) {
		keyboard = new Scanner(System.in);
		this.Calls = Calls;
		this.game = game;
	}
	public void call(String first, String second, Game game) {
		if(second != "") {
		System.out.println("What would command would you like to assign " + second + " too?\n");
		System.out.print("Enter command--> ");
        String command = keyboard.nextLine().toLowerCase();
        
        //if the key exists, gets its value and assigns the new word to the value
        if (this.Calls.containsKey(command)) {
        	this.Calls.put(second, this.Calls.get(command));
        	game.print(second + " now " + command + "s.");
        } else {
        	game.print(command + " is not a command");
        }
		} else { game.print("Cannot add blank command");}
	}
}
