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
	
	
	 private Player player;
	 private String first = null;
     private String second = null;

     
     
     
   
     /**HashmMap Calls holds all callable commands
     * String[] Commands holds the main game commands
      * 
      */
      
     
    private String[] commands = {"add", "go","take", "use", "talk", "attack", "pet", "list", "look", "craft", "pull", "drop"};
    private HashMap<String, Command> Calls = new HashMap <String, Command>();
    
    /**
     * HashSet names holds the names of all rooms and items, to make sure the call is valid
     * For user input from the keyboard.
     */
    private Scanner keyboard;

    /**
     * Plain constructor
     * 
     * creates a hashMap of commands and their class call
     */
    public Parser(Game game) {
        keyboard = new Scanner(System.in);
        this.player = game.getPlayer();
        
 

   	String[] add = {"add", "new"};
   	for(int i = 0; i < add.length; i++) {
   	 Calls.put(add[i], new AddC(this.Calls));
   	}
   	
	String[] pull = {"pull", "switch"};
   	for(int i = 0; i < add.length; i++) {
   	 Calls.put(pull[i], new PullC());
   	}
   	
   	String[] drop = {"drop", "dump"};
   	for(int i = 0; i < drop.length; i++) {
   	 Calls.put(drop[i], new DropC());
   	}
   	
   	String[] craft = {"craft", "smelt", "mold", "form", "make"};
   	for(int i = 0; i < craft.length; i++) {
   	 Calls.put(craft[i], new CraftC());
   	}
   	
   	String[] look = {"look", "see", "check", "view", "notice"};
   	for(int i = 0; i < look.length; i++) {
   	 Calls.put(look[i], new LookC());
   	}
   	
 	String[] list = {"list", "command", "commands", "listall", "options", "option", "help"};
   	for(int i = 0; i < list.length; i++) {
   	 Calls.put(list[i], new ListC(this.commands));
   	}
   
   	 String[] go = {"go", "goto", "move", "to", "towards"};
   	for(int i = 0; i < go.length; i++) {
   	 Calls.put(go[i], new GoC()); 
   	}
   	
   	String[] take = {"take", "grab", "get", "snatch", "reach"};
   	for(int i = 0; i < take.length; i++) {
   	 Calls.put(take[i], new TakeC());
   	}
   	
   	String[] talk = {"talk", "converse", "share", "yell", "read"};
   	for(int i = 0; i < talk.length; i++) {
   	 Calls.put(talk[i], new TalkC());
   	}
   	 
   	String[] attack = {"attack", "fight", "hit",};
   	for(int i = 0; i < attack.length; i++) {
   	 Calls.put(attack[i], new AttackC());
   	}
   	
   	String[] use = {"use", "light", "eat"};
   	for(int i = 0; i < use.length; i++) {
   	 Calls.put(use[i], new UseC());
   	}
   	
	String[] pet = {"pet", "interact"};
   	for(int i = 0; i < pet.length; i++) {
   	 Calls.put(pet[i], new PetC());
   	}
   	 
   	 
    }

    /**
     * Let the user make one "turn" at this game.
     * Give the user a description of the room, prompt for
     * a command, and interpret the command.
     * @param game A reference to the object representing the game.
     */
    public void executeTurn() {
    //
	 first = null;
	 second = null;
	 
     
        System.out.print("Enter command--> ");
        String command = keyboard.nextLine().toLowerCase();  // user's command
        command.trim();
        
       if (command.contains(" ")) {
    	   int temp = command.indexOf(" ");
    	   this.first = command.substring(0, temp);
    	   this.second = command.substring(temp + 1);
    	   while(second.contains(" ")){
    		   temp = second.indexOf(" ");
    		   String temp1 = second.substring(0, temp);
    		   String temp2 = second.substring(temp + 1);
    		   this.second = temp1 + temp2;
    	  }
    	   
       } else { 
    	   this.first = command;
    	   this.second = "";
       }
     
       if(this.Calls.containsKey(first)) {
     	  this.Calls.get(first).call(this.first, this.second, this.player); 
       } else {
         	System.out.println("I do not know how to " + command);
         	this.Calls.get("list").call(this.first, this.second, this.player);
         	}
        	

        } 
     
        }
  

	
		
	
    


    	



