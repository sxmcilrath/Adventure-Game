package game;

import java.util.HashSet;

public class SandMedallion extends Item {

	private static HashSet<Item> Craftable = new HashSet<Item>();
	private static HashSet<Item[]> CraftedBy = new HashSet<Item[]>();
	private static Key K = new Key("tocastle");
	
	protected SandMedallion() {
		super(Craftable, CraftedBy, "sandmedallion");
		Craftable.add(K);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String ability(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

}
