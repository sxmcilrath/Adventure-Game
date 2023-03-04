package game;

import java.util.HashSet;
import java.util.Set;

public class Sword extends Item {

	
	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	/**
	 * constructor for the Sword
	 * @param game
	 */
	public Sword() {
		super(Craftable, CraftedBy);
		String[] a = {"metalchunk", "candle"};
		CraftedBy.add(a);
		Craftable.add("metalchunk");
	}
	
	public String ability(Room room) {
		if (room.getProperties().contains("enemy")) {
			return "You killed the enemy";
		} else {
			return "Stop flailing your sword about! There is nothing to fight in here!";
		}
	}

	
}
