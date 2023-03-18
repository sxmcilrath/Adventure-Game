/**
 * AddC
 * 
 * Command to add things to 
 * 
 * @author Lincoln Going
 */

package game;

import java.util.HashSet;
import java.util.Set;

public class Shovel extends Item {

	private Player player;
	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	private static HashSet<String> Catalyst = new HashSet<String>();
	private static MetalChunk MC = new MetalChunk();
	private static Candle C = new Candle();
	private static BucketWithSand BWS = new BucketWithSand();
	public Shovel() {
		super(Craftable, CraftedBy, "shovel", Catalyst);
		Item[] a = {MC, C};
		//CraftedBy.add(a);
		//Craftable.add("stick");
		//Craftable.add(MC);
		//Craftable.add(BWS);
		//Catalyst.add(BWS);
	}

	@Override
	public String ability(Room room) {
		//need to first add a check to make sure they are in the beach room
		if(room.getName().equals("beach")){
			
			return "You push sand around for a couple minutes. This seems pointless. If only there was something to shape the sand...";
		}
		
		return "You can't use that here!";
	}
	
	

	
}
