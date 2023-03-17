package game;

import java.util.HashSet;
import java.util.Set;

public class Shovel extends Item {

	private Player player;
	private static HashSet<Item> Craftable = new HashSet<Item>();
	private static HashSet<Item[]> CraftedBy = new HashSet<Item[]>();
	private static HashSet<Item> Catalyst = new HashSet<Item>();
	private static MetalChunk MC = new MetalChunk();
	private static Candle C = new Candle();
	private static BucketWithSand BWS = new BucketWithSand();
	public Shovel() {
		super(Craftable, CraftedBy, "shovel", Catalyst);
		Item[] a = {MC, C};
		CraftedBy.add(a);
		//Craftable.add("stick");
		Craftable.add(MC);
		Craftable.add(BWS);
		Catalyst.add(BWS);
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
