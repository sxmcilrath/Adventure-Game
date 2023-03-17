package game;

//standard door 
public class LockedDoor extends Door {
	
	private Key key;
	public LockedDoor(Room room1, Room room2, Key key) {
		super(room1, room2);
		this.key = key;
		
	}
	
	public Key getKey() {
		return this.key;
	}
	
	public void setKey(Key key) {
		this.key = key;
	}
	

	
	public Room nextRoom(Room CR, Key key) {
		if(this.key.getName().equals(key.getName())) {
			return super.nextRoom(CR);
		}
		return CR;
	}
	
	
		
	

}
