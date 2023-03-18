package game;

import java.util.HashMap;

public class MetalChunk extends Item {

	public MetalChunk () {
		super("metalchunk");
	}
	
	@Override
	public String ability(Room room, HashMap<String, Item> backpack) {
		
		return "This looks craftable...";
	}
	
	

}
