package game;

import java.util.HashSet;
import java.util.Set;

public class Sword implements Item {

	
	private HashSet<String> Craftable = new HashSet<String>();
	private HashSet<String> CraftedBy = new HashSet<String>();
	/**
	 * constructor for the Sword
	 * @param game
	 */
	public Sword() {
		CraftedBy.add("metalchunk");
		CraftedBy.add("candle");
		Craftable.add("metalchunk");
	}
	
	public String ability(Room room) {
		if (room.getProperties().contains("enemy")) {
			return "You killed the enemy";
		} else {
			return "Stop flailing your sword about! There is nothing to fight in here!";
		}
	}

	
	@Override
	public Set<String> craftable() {
		// TODO Auto-generated method stub
		return this.Craftable;
	}

	@Override
	public Set<String> craftedBy() {
		// TODO Auto-generated method stub
		return this.CraftedBy;
	}
}
