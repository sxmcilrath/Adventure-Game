package game;

import java.util.HashSet;
import java.util.Set;

public class Steak extends Item {

	private static HashSet<Item> Craftable = new HashSet<Item>();
	private static HashSet<Item[]> CraftedBy = new HashSet<Item[]>();
	
	public Steak() {
		super(Craftable, CraftedBy, "steak");
	}
	@Override
	public String ability(Room room) {
		// restore hunger
		return "";
	}
	

	

}
