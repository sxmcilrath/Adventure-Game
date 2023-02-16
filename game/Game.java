package game;

import java.util.HashMap;


/**
 * Game.java
 * 
 * Class to model the game as a collection of rooms. The
 * rooms are organized as a graph, and the Room objects
 * are nodes in the graph.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class Game {
	
    /**
     * The current room the user is in. This serves to
     * purposes-- it is our only permanent connection to
     * the rooms in this game (the other rooms are reachable
     * by traversing this room's "doors"-- and it maintains
     * the state by representing the user's current location.
     */
    private Room currentRoom;
   

    private HashMap<String, Item> backpack = new HashMap<String, Item>();

    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over;
    
    /**
     * instance of game progression to keep track of your progression in the game
     */
    private GameProgression progression;
    
    /**
     * Return the room in which the user is currently.
     */
    public Room getCurrentRoom() { return currentRoom; }
    
    /**
     * Constructor to set up the game.
     */
   
    public Game() {
    	 //initializes rooms
        Room entrance = new Room("You are standing at the edge of a beautiful forest. A sign is just in front of you; I wonder what it says...");
        entrance.addProperty("pretty");
        Room swordRoom = new Room("You see a rather wimpy-looking sword on the ground. It doesn't seem very high quality,but you should still take it. Unless, of course, you feel you can manage without it.");
        swordRoom.addProperty("sword");
        Room swordTutorial = new Room("There is a sign here. It seems eager to meet you... or hurt you. I can't tell.");
        Room freeWillTutorial = new Room("Oh, another sign. Hopefully this one is a bit less violent than the last one.");
        Room questMadeClear = new Room("A wise looking sign stands majestically before you. Even in his old age, he has an air of vibrance and royalty. I wonder what he has to say.");
        Room viewingTree = new Room("placeholder text");
        Room nonEucTutorial = new Room("Another sign is here. He looks to be the 'needs-to-get-out-more' kind of type");
        
        //Creating map of game by linking rooms 
        
        //Linking Ye Olde Tutorial Forest
        this.linkRooms(entrance, swordRoom, "Sword Room", "Entrance");
        this.linkRooms(swordRoom, swordTutorial, "Sword Tutorial Room", "Sword Room");
        this.linkRooms(swordTutorial, freeWillTutorial, "Free Will Tutorial", "Sword Tutorial");
        this.linkRooms(freeWillTutorial, questMadeClear, "Your Quest Made Clear", "Free Will Tutorial");
        
        freeWillTutorial.addDirection("Non Euclidian Tutorial", nonEucTutorial);
        
        this.linkRooms(questMadeClear, viewingTree , "Viewing Tree", "Your Quest Made Clear");
        
        nonEucTutorial.addDirection("South", entrance);
        
        
        over = false;
        
        
        /**
         * Give the user the privilege
         * of having a hand
         */
        backpack.put("Hand", new Hand());
        
        progression = new GameProgression(backpack);
    }
    
    /**
     * This method takes an item name, a room, and tries to use the
     * item, and will fail to do so if the item is not in the backpack.
     * @param item The item you are trying to use
     * @param room The room you are trying to use the item in
     * @return a string containing a description of what happened
     */
    public String useItem(String item, Room room) {
    	if (Backpack.containsKey(item)) {
    		return Backpack.get(item).ability(room);
    	}
    	return "Huh?";
    }
    
    /**
     * Is this game over or not?
     */
    public boolean isOver() { return over; }

    /**
     * Move into a different current room.
     */
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    //swtiches rooms
    public void switchRoom(String first) {
    	Room CR = getCurrentRoom();
		boolean temp = CR.checkDirection(first);
		if(temp == true) {
		 setCurrentRoom(CR.getRoom(first));
		 CR = getCurrentRoom();
		 print(CR.getDescription());
		}else {
		print("There is nothing in that direction");
		}
		
    }
    /**
     * Indicate that the game is now over.
     */
    
    /**
     * mutually add two rooms to be accessed by the other
     * @param r1	first room
     * @param r2	second room
     * @param direct1	direction name to get to r2 from r1
     * @param direct2	direction name to get to r1 from r2
     */
    public void linkRooms(Room r1, Room r2, String direct1, String direct2) {
    	r1.addDirection(direct1, r2);
    	r2.addDirection(direct2, r1);
    }
    
    public void finishGame() { over = true; }
    
    

    public void print(String output) {
    	System.out.println(output);
    	}
}

   