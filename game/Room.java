package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

public class Room {

	/**
	 * A set containing the room's properties, such as dark,
	 * onFire, etc.
	 */
	private HashSet<String> properties;
	
    /**
     * Rooms adjacent to this one, to which there is a door.
     */
    private Room north, south, east, west;
    private HashMap <String, Room> directions = new HashMap<String, Room>();
    /**
     * A description of this room
     */
    private String description;
    
    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description) { this.description = description; }
    
    //method to add directions and connections to a room
    public void addDirection(String directName, Room destination) {
    	this.directions.put(directName, destination);
    }
    
    //checks HashMap for desired direction
    public boolean checkDirection(String directName) {
    	return this.directions.containsKey(directName);
    }
    public Room getRoom(String directName) {
    	return this.directions.get(directName);
    }
        
    /**
     * Methods for added "doors"-- direction connections to other rooms.
     */
    
   //to delete
   /* public void setNorth(Room north) { this.north = north; }
    public void setSouth(Room south) { this.south = south; }
    public void setEast(Room east) { this.east = east; }
    public void setWest(Room west) { this.west = west; } */
	
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
    
    /**
     * Methods to determine the rooms to which various
     * doors-- if they exist-- lead.
     */
    public Room getNorth() { return north; }
    public Room getSouth() { return south; }
    public Room getEast() { return east; }
    public Room getWest() { return west; }
    
    /**
     * A getter method for the set of the room's properties
     * @return properties
     */
    public HashSet<String> getProperties() {
    	return properties;
    }
    
    /**
     * method to add a property to a room
     * @param property The property to add to the room
     */
    public void addProperty(String property) {
    	properties.add(property);
    }

	
}
