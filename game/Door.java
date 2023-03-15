package game;

public interface Door {

	public Room nextRoom(Room CR);	//moves through door to next attatched room
	
	public Key getKey();	//grabs key if there is one
}
