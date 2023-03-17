package game;

import java.util.HashSet;

/**
 * medallion obtained in the beach castle. When combined with the ice medallion
 * it creates the final key
 */
public class SandMedallion extends Item {

	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
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
