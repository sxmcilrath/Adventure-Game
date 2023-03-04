package game;

public class Door {
	
	private Room fromRoom;
	private Room toRoom;
	private Key key;

	public Door(Room fromRom, Room ToRoom) {
		this.fromRoom = fromRoom;
		this.toRoom = toRoom;
		this.key = key;
	}
	
	
	public Room correctKey(Key key) {
		if(this.key == key) {
			System.out.println("You used the key.");
			return toRoom;
			}
		System.out.println("Not the correct Key");
		return fromRoom;
		}
		
	

}
