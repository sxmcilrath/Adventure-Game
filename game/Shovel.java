/**
 * AddC
 * 
 * Command to add things to 
 * 
 * @author Lincoln Going
 */

package game;


public class Shovel extends Item {

	public Shovel() {
		super("shovel");
	}


	public String ability(Room room) {
		//need to first add a check to make sure they are in the beach room
		if(room.getName().equals("beach")){
			
			return "You push sand around for a couple minutes. This seems pointless. If only there was something to shape the sand...";
		}
		
		return "You can't use that here!";
	}
	
	

	
}
