package game;

import java.util.HashSet;
import java.util.Set;

public class Bucket extends Item {

	private static HashSet<Item> Craftable = new HashSet<Item>();
	private static HashSet<Item[]> CraftedBy = new HashSet<Item[]>();
	private MetalChunk MC = new MetalChunk();
	private Candle C = new Candle();
	
	public Bucket() {
		super(Craftable, CraftedBy, "bucket");
		Craftable.add(MC);
		Item[] a = {MC, C};
		CraftedBy.add(a);
		
		
	
		
	}
	@Override
	public String ability(Room room) {
		// TODO Auto-generated method stub
		if(room.getName().equals("beach")) {
			return "Huh, nothing's inside. Cool bucket though!";
		}
		return "You can't use that here!";
	}

	
	

}
