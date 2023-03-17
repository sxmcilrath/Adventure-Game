/**
 * LockedDoor
 * 
 * A door that needs a key to be walked through
 * 
 * @author Lincoln Going
 */

package game;

//standard door 
public class LockedDoor extends Door {
	
	/**
	 * the key that is needed to pass through the door
	 */
	private Key key;
	
	/**
	 * constructor for LockedDoor
	 * @param room1 The first room that the door connects
	 * @param room2 The second room that the door connects
	 * @param key The key that is needed to pass through the door
	 */
	public LockedDoor(Room room1, Room room2, Key key) {
		super(room1, room2);
		this.key = key;
		
	}
	
	/**
	 * getter method for the Key of this door
	 * @return the key of the door
	 */
	public Key getKey() {
		return this.key;
	}
	
	/**
	 * setter for the key of the door
	 * @param key The key that is being assigned to the door
	 */
	public void setKey(Key key) {
		this.key = key;
	}
	
	/**
	 * Puts the player in the room on the other side of the door if the player has the correct key
	 * @param CR The room that the player is currently in
	 * @param key The key that the player is using on the door
	 * @return the room appropriate for the player to be in after trying to open the door
	 */
	public Room nextRoom(Room CR, Key key) {
		if(this.key.getName().equals(key.getName())) {
			return super.nextRoom(CR);
		}
		return CR;
	}

}
