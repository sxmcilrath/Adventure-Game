package game;

import java.util.ArrayList;
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
	private HashMap<String, Integer> Comm = new HashMap<String, Integer>();
	
	// private ArrayList<ArrayList> CommandTypes = new ArrayList<ArrayList();
	 private ArrayList<String> Command = new ArrayList<String>();      
	 private int size = 3;
	 private String[][] Commands = {{"north","south","east","west"}, {"drop", "take", "use", "throw"} ,{"help", "leave", "go"}};
	 //first and second word of input commands
	 private String first = null;
     private String second = null;
	 
	 public void setUp() {
		 for(int i = 0; i < Commands.length; i++) {
	    		for(int j = 0; j < Commands[i].length; j++) {
	    			Comm.put(Commands[i][j], i);
	    		}
		 }
		 
		
	
	 }
	
	 
    /**
     * For user input from the keyboard.
     */
    private Scanner keyboard;

    /**
     * Plain constructor
     */
    public Parser() {
        keyboard = new Scanner(System.in);
    }

    /**
     * Let the user make one "turn" at this game.
     * Give the user a description of the room, prompt for
     * a command, and interpret the command.
     * @param game A reference to the object representing the game.
     */
    public void executeTurn(Game game) {
    
	 first = null;
	 second = null;
        // The room that the user is in.
        Room room = game.getCurrentRoom();
        System.out.println("You are in " + room.getDescription());
        System.out.print("Enter command--> ");
        String command = keyboard.nextLine().toLowerCase();  // user's command
        command.trim();
       if (command.contains(" ")) {
    	   int temp = command.indexOf(" ");
    	   String first = command.substring(0, temp-1);
    	   String second = command.substring(temp + 1);
       } else { first = command;}
       
      
        
      if(Comm.containsKey(first)) {
    	   int call = Comm.get(first);
    	   
        	
        } else {
        	 System.out.println("I do not know how to " + command + ".\n");
        	for(int i = 0; i < Commands.length; i++) {
        		for(int j = 0; j < Commands[i].length; j++) {
        	System.out.println( Commands[i][j] + "\n");
        		}
        	}
        	

        } 
      if (command.equals("north") || command.equals("south")       || command.equals("west") || command.equals("east")) {
            Room nextRoom;   // the room we're moving to
            if (command.equals("north"))
                nextRoom = room.getNorth();
            else if (command.equals("south"))
                nextRoom = room.getSouth();
            else if (command.equals("west"))
                nextRoom = room.getWest();
            else
                nextRoom = room.getEast();
            if (nextRoom == null) 
                System.out.println("There is no door in that direction.");
            else
                game.setCurrentRoom(nextRoom);
        }
           

    }
    public void section (int i) {
    	
    }
    public void move(String command) {
    	
    }
    public void item (String command) {
    	
    }
public void other (String command) {
    	
    }


}
