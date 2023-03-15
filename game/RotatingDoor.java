package game;

import java.util.ArrayList;

public class RotatingDoor implements Door {

	private ArrayList<Room> rooms;	//array list of rooms 
	private Key key;	//only one key to access the rotating doors
	
	public RotatingDoor(ArrayList<Room> rooms) {
		this.rooms = rooms;
		key = null;
	}
	
	public RotatingDoor(ArrayList<Room> rooms, Key key) {
		this.rooms = rooms;
		this.key = key;
	}
	
	@Override
	public Room nextRoom(Room CR) {
		int size = rooms.size();	//grabs size of rooms
		int index = rooms.indexOf(CR);	//index of the current room
		
		//if room is the last in the list then it goes to first room
		//if not then it selects the next room in the list
		if(index == size - 1) {
			 return rooms.get(0);
		}
		else {
			 return rooms.get(index+1);
		}
	}

	public Key getKey() {
		return key;
	}
}
