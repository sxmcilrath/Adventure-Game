/**
 * Door
 * 
 * A connector between rooms that the player must pass through
 * 
 * @author Lincoln Going
 */

package game;

public class Door {
	
	/**
	 * the first room the door connects
	 */
	private Room r1;
	
	/**
	 * the second room the door connects
	 */
	private Room r2;
	
	/**
	 * Constructor for door
	 * @param r1 The first room to connect
	 * @param r2 The second room to connect
	 */
	public Door(Room r1, Room r2) {
		this.r1 = r1;
		this.r2 = r2;
		
	}

	/**
	 * moves the player from the current room to the room on the other "side" of the door
	 * @param CR The room the player is currently in
	 * @return The room for the player to move into
	 */
	public Room nextRoom(Room CR) {
		if(CR == r1) {
			return r2;
		} else {
			return r1;
		}
		//moves through door to next attatched room
	}
	
	
	
	
	
	
	
}
