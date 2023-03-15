package game;

import java.util.HashSet;

public class IceMedallion extends Item {

	private static HashSet<Item> Craftable = new HashSet<Item>();
	private static HashSet<Item[]> CraftedBy = new HashSet<Item[]>();
	
	public IceMedallion() {
		super(Craftable, CraftedBy, "icemedallion");
	}
	@Override
	protected String ability(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

}
