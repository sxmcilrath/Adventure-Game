package game;

import java.util.HashSet;

public class Key extends Item{
	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	private static SandMedallion SM = new SandMedallion();
	private static IceMedallion IM = new IceMedallion();
	
	
	protected Key(String name) {
		super(Craftable, CraftedBy, name);
		Item[] medal = {SM, IM};
		//CraftedBy.add(medal);
	}
	protected Key(HashSet<String> Craftable, HashSet<String[]> craftedBy, String name) {
		super(Craftable, craftedBy, name);
		Item[] medal = {SM, IM};
		//CraftedBy.add(medal);
		
	}

	
	public String getName() {
		return this.myName;
	}
	
	
	public String ability(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
