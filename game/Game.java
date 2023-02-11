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
    
    /**
     * This is the collection of all the items our user is
     * currently holding. The user's starts out with only
     * the Hand item available.
     */
    private HashMap<String, Item> Backpack = new HashMap<String, Item>();

    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over;
    
    /**
     * Return the room in which the user is currently.
     */
    public Room getCurrentRoom() { return currentRoom; }
    
    /**
     * Constructor to set up the game.
     */
    public Game() {
        Room[] rooms = new Room[4];
        for (int i = 0; i < rooms.length; i++)
            rooms[i] = new Room("a room");
        rooms[0].setNorth(rooms[1]);
        rooms[1].setSouth(rooms[0]);
        rooms[1].setEast(rooms[2]);
        rooms[2].setWest(rooms[1]);
        rooms[2].setSouth(rooms[3]);
        rooms[3].setNorth(rooms[2]);
        rooms[3].setWest(rooms[0]);
        rooms[0].setEast(rooms[3]);
        over = false;
        currentRoom = rooms[0];
        
        /**
         * Give the user the privilege
         * of having a hand
         */
        Backpack.put("Hand", new Hand());
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

    /**
     * Indicate that the game is now over.
     */
    public void finishGame() { over = true; }
    
}
