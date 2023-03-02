package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Room.java
 * 
 * Class to model a room in the game.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class Room  {
	
	/**
	 * the name of the room
	 */
	private String name;

	private HashSet<String> properties;	//A set containing the room's properties, such as dark, onFire, etc.
    private HashMap <String, Room> directions = new HashMap<String, Room>();	//map to contain directions to accessible rooms
    private String description;	//A description of this room
    private NPC roomNPC; //npc for the room if there is one
    
    /**
     * constructor for if the room only needs a description
     * @param description
     */
    public Room(String description) {
    	this.description = description;
    	this.properties = new HashSet<String>();
    }
    
    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String name, String description) {
    	this.name = name;
    	this.description = description;
    	this.properties = new HashSet<String>();
    }
    
    /**
     * cosntructor for if the room only needs a description and an npc
     * @param description
     * @param roomNPC
     */
    public Room(String description, NPC roomNPC) {
    	this.description = description;
    	this.roomNPC = roomNPC;
    	this.properties = new HashSet<String>();
    }
    
    /**
     * Overloading the constructor to make room for if the room 
     * has an NPC and a name
     * @param description	String describes room 	
     * @param roomNPC		NPC in room
     */
    public Room(String name, String description, NPC roomNPC) {
    	this.name = name;
    	this.description = description;
    	this.roomNPC = roomNPC;
    	this.properties = new HashSet<String>();
    }
    
    //method to add directions and connections to a room
    public void addDirection(String directName, Room destination) {
    	this.directions.put(directName, destination);
    }
    
    //checks HashMap for desired direction
    public boolean checkDirection(String directName) {
    	return this.directions.containsKey(directName);
    }
    
    //getters
    
    public Room getRoom(String directName) {
    	return this.directions.get(directName);
    }
    public Map options() {
    	return this.directions;
    }
    
    public NPC getNPC() {
    	return roomNPC;
    }
    
    
        

	
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
    
    /**
     * get the name of the room
     * @return
     */
    public String getName() {
    	return name;
    }
    
    /**
     * A getter method for the set of the room's properties
     * @return properties
     */
    public HashSet<String> getProperties() {
    	return properties;
    }
    
    public void removeProperty(String property) {
    	if(properties.contains(property)) {
    		properties.remove(property);
    	}
    	
    }
    
    /**
     * method to add a property to a room
     * @param property The property to add to the room
     */
    public void addProperty(String property) {
    	properties.add(property);
    }

	
}
