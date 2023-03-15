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

	private HashSet<Item> properties;	//A set containing the room's properties, such as dark, onFire, etc.
    private HashMap <String, Door> directions = new HashMap<String, Door>();	//map to contain directions to accessible rooms
    private String description;	//A description of this room
    private NPC roomNPC; //npc for the room if there is one
    
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
    	this.properties = new HashSet<Item>();
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
    public void addDoor(Door door, String directName) {
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
    public HashSet<Item> getProperties() {
    	return properties;
    }
    
    public void removeProperty(Item property) {
    	if(properties.contains(property)) {
    		properties.remove(property);
    	}
    	
    }
    
    /**
     * method to add a property to a room
     * @param property The property to add to the room
     */
    public void addProperty(Item property) {
    	properties.add(property);
    }

	
}
