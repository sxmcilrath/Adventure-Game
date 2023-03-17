package game;

import java.util.ArrayList;
/**
 *The rotating door has an array list of doors that it goes through. These doors create a one way circle 
 *between all the doors. If the current door is at the end of the list then the door at the 
 *beginning of the list is then accessed
 */
public class RotatingDoor {
/**
	private ArrayList<Room> rooms;	//array list of rooms 
	private Key key;	//only one key to access the rotating doors
	
	/**
	 * constructor takes in a list of doors 
	 * @param rooms		list of rooms that the rotating door rotates through	
	 *
	public RotatingDoor(ArrayList<Room> rooms) {
		this.rooms = rooms;
		key = null;
	}
	
	@Override
	/**
	 * goes to next room in the array list. If the player is at the end of the 
	 * list then the room is set back to the first
	 *
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
	*/
}
