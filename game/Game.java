package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


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

    private HashSet<String> directNames = new HashSet<String>();	//Array list to store names of directions. This array will be sent over to parser class 
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
    
    public HashSet<String> getDirectNames(){
    	return directNames;
    }
    
    /**
     * Constructor to set up the game.
     */
    public Game() {
    	//initializes rooms
    	
    	//Ye Olde Tutorial Rooms
        Room entrance = new Room("You are standing at the edge of a beautiful forest. A sign is just in front of you; I wonder what it says...");
        entrance.addProperty("pretty");
        Room swordRoom = new Room("You see a rather wimpy-looking sword on the ground. It doesn't seem very high quality,but you should still take it. Unless, of course, you feel you can manage without it.");
        swordRoom.addProperty("sword");
        Room swordTutorial = new Room("There is a sign here. It seems eager to meet you... or hurt you. I can't tell.");
        Room freeWillTutorial = new Room("Oh, another sign. Hopefully this one is a bit less violent than the last one.");
        Room questMadeClear = new Room("A wise looking sign stands majestically before you. Even in his old age, he has an air of vibrance and royalty. I wonder what he has to say.");
        Room viewingTree = new Room("placeholder text");
        Room nonEucTutorial = new Room("Another sign is here. He looks to be the 'needs-to-get-out-more' kind of type");
        
        //Overworld Rooms
        Room outsideShelter = new Room("x");
        Room shelter = new Room("x");
        Room icyPath = new Room("x");
        Room beachWalk = new Room("x");
        
        //Map Hub Rooms
        
        //Creating map of game by linking rooms 
        
        //Linking Ye Olde Tutorial Forest
        linkRooms(entrance, swordRoom, "Sword Room", "Entrance");
        linkRooms(swordRoom, swordTutorial, "Sword Tutorial Room", "Sword Room");
        linkRooms(swordTutorial, freeWillTutorial, "Free Will Tutorial", "Sword Tutorial");
        linkRooms(freeWillTutorial, questMadeClear, "Your Quest Made Clear", "Free Will Tutorial");
        linkRooms(freeWillTutorial, nonEucTutorial, "Non Euclidian Tutorial");
        linkRooms(questMadeClear, viewingTree , "Viewing Tree", "Your Quest Made Clear");
        linkRooms(nonEucTutorial, entrance, "South");

        //Linking Overworld
        linkRooms(outsideShelter, shelter,"Shelter", "Outside");
        linkRooms(shelter, icyPath, "Icy Path", "Shelter");
        linkRooms(shelter, beachWalk, "Beach Walk", "Shelter");
        
        over = false;
        
        this.addItemToBackpack("hand", new Hand(this));
        
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
    	if (backpack.containsKey(item)) {
    		return backpack.get(item).ability(room);
    	}
    	return "Huh?";
    }
    
    /**
     * puts an item into the backpack so that the player can use it
     * @param itemName The name of the item that you are adding
     * @param item The item that you are adding
     * @return A string used to say that the item was picked up
     */
    public String addItemToBackpack(String itemName, Item item) {
    	backpack.put(itemName, item);
    	return "The " + itemName + " was added to your backpack!";
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
    	//Checks if directon is a key in the directions hashmap
		if(CR.checkDirection(first)) {	
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
    	directNames.add(direct1);
    	directNames.add(direct2);

    	
    }
    
    /**
     * Overloading linkRooms method to make a case where a room leads to 
     * another but you can't go back
     * @override
     * @param r1	current room
     * @param r2	destination room
     * @param direct	direction name to get from r1 to r2
     */
    public void linkRooms(Room r1, Room r2, String direct) {
    	r1.addDirection(direct, r2);
    	directNames.add(direct);
    }
    
    
    
    public void finishGame() { over = true; }
    
    

    public void print(String output) {
    	System.out.println(output);
    	}

	public void pet() {
		
	}

	public void attack() {
		// TODO Auto-generated method stub
		
	}

	public void take() {
		useItem("hand", getCurrentRoom());
		
	}

	public void talk() {
		// TODO Auto-generated method stub
		
	}

	public void use() {
		// TODO Auto-generated method stub
		
	}


}

   