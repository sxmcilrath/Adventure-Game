package game;

import java.util.HashMap;
import java.util.Scanner;

public class AddC implements Command{
	private HashMap<String,String> Comm = new HashMap<String, String>();
	 private Scanner keyboard;

	
	public AddC(HashMap <String,String> Comm) {
		keyboard = new Scanner(System.in);
		this.Comm = Comm;
	}
	public void call(String first, String second, int words, Game game) {
		System.out.println("What would command would you like to assign " + second + " too?\n");
		System.out.print("Enter command--> ");
        String command = keyboard.nextLine().toLowerCase();
        
        //if the key exists, gets its value and assigns the new word to the value
        if (this.Comm.containsKey(command)) {
        	this.Comm.put(second, this.Comm.get(command));
        }
	}
}
