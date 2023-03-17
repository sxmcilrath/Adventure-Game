package game;

import java.util.HashSet;
import java.util.Set;

public class Steak extends Item {

	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	
	public Steak() {
		super(Craftable, CraftedBy, "steak");
	}
	@Override
	public String ability(Room room) {
		// restore hunger
		return "";
	}
	

	

}
