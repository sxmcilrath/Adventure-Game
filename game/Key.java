package game;

import java.util.HashSet;

public class Key extends Item{
	private static HashSet<Item> Craftable = new HashSet<Item>();
	private static HashSet<Item[]> CraftedBy = new HashSet<Item[]>();
	private static SandMedallion SM = new SandMedallion();
	private static IceMedallion IM = new IceMedallion();
	
	
	protected Key(String name) {
		super(Craftable, CraftedBy, name);
		Item[] medal = {SM, IM};
		CraftedBy.add(medal);
	}
	protected Key(HashSet<Item> Craftable, HashSet<Item[]> craftedBy, String name) {
		super(Craftable, craftedBy, name);
		Item[] medal = {SM, IM};
		CraftedBy.add(medal);
		
	}

	
	public String getName() {
		return this.myName;
	}
	
	
	public String ability(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
