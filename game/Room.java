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
	


	private String name;	//name id for room
	private HashMap<String, Item> properties;	//A set containing the room's properties, such as dark, onFire, etc.
    private HashMap <String, Door> directions = new HashMap<String, Door>();	//map to contain directions to accessible rooms
    private String description;	//A description of this room
    private NPC roomNPC;		//npc for the room if there is one
    
    private Lever lever;	//lever for lever puzzle
    
    /**
     * constructor for if the room only needs a description
     * @param description
     */
    
    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String name, String description) {
    	this.name = name;
    	this.description = description;
    	this.properties = new HashMap<String,Item>();
    }
    
    /**
     * cosntructor for if the room only needs a description and an npc
     * @param description
     * @param roomNPC
     */
    
    public void addNPC(NPC npc) {
    	this.roomNPC = npc;
    }
    
    /**
     * Overloading the constructor to make room for if the room 
     * has an NPC and a name
     * @param description	String describes room 	
     * @param roomNPC		NPC in room
     */
    
    //method to add directions and connections to a room
    public void addDoor(String directName, Door door) {
    	this.directions.put(directName, door);
    }
    
    //checks HashMap for desired direction
    public boolean checkDirection(String directName) {
    	return this.directions.containsKey(directName);
    }
    
    //getters
  
    public Door getDoor(String directName) {
    	return this.directions.get(directName);
    }
    public Map<String,Door> options() {
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
    public HashMap<String,Item> getProperties() {
    	return properties;
    }
    
    public void removeProperty(String property) {
    	if(properties.containsKey(property)) {
    		properties.remove(property);
    	}
    	
    }
    
    public void addLever(Lever lever) {
    	this.lever = lever;
    }
    
    public Lever getLever() {
    	return lever;
    }
    
    /**
     * method to add a property to a room
     * @param property The property to add to the room
     */
    public void addProperty(String name, Item property) {
    	
    	properties.put(name, property);
    }

	
}
