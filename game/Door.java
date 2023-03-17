package game;

public class Door {
	private Room r1;
	private Room r2;
	
	public Door(Room r1, Room r2) {
		this.r1 = r1;
		this.r2 = r2;
		
	}

	public Room nextRoom(Room CR) {
		if(CR == r1) {
			return r2;
		} else {
			return r1;
		}
		//moves through door to next attatched room
	}
	
	
	
	
	
	
	
}
