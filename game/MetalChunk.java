package game;

import java.util.HashSet;
import java.util.Set;

public class MetalChunk extends Item {

	private static HashSet<Item> Craftable = new HashSet<Item>();
	private static HashSet<Item[]> CraftedBy = new HashSet<Item[]>();
	
	public MetalChunk () {
		super(Craftable, CraftedBy, "metalchunk");
		Craftable.add(new Bucket());
		Craftable.add(new Sword());
		Craftable.add(new Shovel());
		Item[] a = {new Bucket()};
		CraftedBy.add(a);
		Item[] b = {new Sword()};
		CraftedBy.add(b);
		Item[] c = {new Shovel()};
		CraftedBy.add(c);

	}
	@Override
	public String ability(Room room) {
		// restore hunger
		return "";
	}
	
	

}
