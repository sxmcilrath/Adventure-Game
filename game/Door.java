package game;

public class Door {
	
	private Room room1;
	private Room room2;
	private Key key = null;

	public Door(Room room1, Room room2) {
		this.room1 = room1;
		this.room2 = room2;
		
	}
	public Door(Room room1, Room room2, Key key) {
		this.room1 = room1;
		this.room2 = room2;
		this.key = key;
	}
	
	
	
	
	public Key getKey() {
		return this.key;
	}
	
	public Room nextRoom(Room CR) {
		if(CR == room1) {
			return room2;
		}
		return room1;
	}
		
	

}
