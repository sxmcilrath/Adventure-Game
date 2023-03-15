package game;

import java.util.HashSet;

public class Lever extends Item {

	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	
	public Lever() {
		super(Craftable, CraftedBy);
	}
	@Override
	protected String ability(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

}
