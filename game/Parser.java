package game;


import java.util.HashMap;


/**
 * Parser.java
 * 
 * Class to interpret the user's commands
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

import java.util.Scanner;

public class Parser {
	
	
	 private Game game;
	 private String first = null;
     private String second = null;
     private int words;
     
     
     
     /* A note on Comm and Calls. To create the function where you could add new command names based on existing commands, 
      * I put all possible command names hashmap Comm, which has the value of actual command names. these are the keys to calls, \
      * which calls different classes
      * 
      * String commands holds all callable commands
      */
     
 	 private HashMap<String,String> Comm = new HashMap<String, String>();
    private String[] Commands = {"add", "go","take", "use", "talk", "attack", "pet"};
    private HashMap<String, Command> Calls = new HashMap <String, Command>();
    
    //HasshSet names holds the names of all rooms and items, to make s ure the call is valid
    /**
     * For user input from the keyboard.
     */
    private Scanner keyboard;

    /**
     * Plain constructor
     */
    public Parser(Game game) {
        keyboard = new Scanner(System.in);
        this.game = game;
        
      //Constructs HashMap of commands
   	 for(int i = 0; i < Commands.length; i++) {	
	    		Comm.put(Commands[i], Commands[i]);	
		 }

   	 //Constructs a Hashmap of commands
   	 Calls.put("add", new AddC(this.Comm));
   	 Calls.put("go", new GoC());
   	Calls.put("goto", new GoC());
   	 Calls.put("take", new TakeC());
   	 Calls.put("talk", new TalkC());
   	 Calls.put("attack", new AttackC());
   	 Calls.put("use", new UseC());
   	 
   	 
    }

    /**
     * Let the user make one "turn" at this game.
     * Give the user a description of the room, prompt for
     * a command, and interpret the command.
     * @param game A reference to the object representing the game.
     */
    public void executeTurn(Game game) {
    //
	 first = null;
	 second = null;
	 this.game = game;
	 
        // The room that the user is in.
        Room room = game.getCurrentRoom();
        System.out.println("You are in " + room.getDescription());
        System.out.print("Enter command--> ");
        String command = keyboard.nextLine().toLowerCase();  // user's command
        command.trim();
        
       if (command.contains(" ")) {
    	   int temp = command.indexOf(" ");
    	   this.first = command.substring(0, temp);
    	   this.second = command.substring(temp + 1);
    	   this.words = 2;
    	   while(second.contains(" ")){
    		   temp = second.indexOf(" ");
    		   String temp1 = second.substring(0, temp);
    		   String temp2 = second.substring(temp + 1);
    		   this.second = temp1 + temp2;
    	  }
    	   
       } else { 
    	   this.first = command;
    	   this.words = 1;
       }
     	  if(this.Comm.containsKey(first)) {
     	  String temp = this.Comm.get(first);
     	  this.Calls.get(temp).call(this.first, this.second, this.words, this.game); 
        
       } else {
         	System.out.println("I do not know how to " + command + ".\n");
         	System.out.println( "Options: " + this.Comm.toString() + "\n");
        	
        	

        } 
     
        }
  

	
		
	
    
}

    	



