package game;

//standard door 
public class TwoWayDoor implements Door {
	
	private Room room1;
	private Room room2;
	private Key key = null;

	public TwoWayDoor(Room room1, Room room2) {
		this.room1 = room1;
		this.room2 = room2;
		
	}
	public TwoWayDoor(Room room1, Room room2, Key key) {
		this.room1 = room1;
		this.room2 = room2;
		this.key = key;
	}
	
	
	public Key getKey() {
		return this.key;
	}
	
	public void setKey(Key key) {
		this.key = key;
	}
	

	
	public Room nextRoom(Room CR) {
		if(CR == room1) {
			return room2;
		}
		return room1;
	}
	
	
		
	

}
