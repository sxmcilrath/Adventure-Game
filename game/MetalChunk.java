package game;

import java.util.HashSet;
import java.util.Set;

public class MetalChunk extends Item {

	private static HashSet<Item> Craftable = new HashSet<Item>();
	private static HashSet<Item[]> CraftedBy = new HashSet<Item[]>();
	private static Bucket B = new Bucket();
	private static Sword S = new Sword();
	private static Shovel SH = new Shovel();
	
	public MetalChunk () {
		super(Craftable, CraftedBy, "metalchunk");
		Craftable.add(B);
		Craftable.add(S);
		Craftable.add(SH);
		Item[] a = {B};
		CraftedBy.add(a);
		Item[] b = {S};
		CraftedBy.add(b);
		Item[] c = {SH};
		CraftedBy.add(c);

	}
	@Override
	public String ability(Room room) {
		// restore hunger
		return "";
	}
	
	

}
