package game;

import java.util.HashSet;
import java.util.Set;

public class Sword extends Item {

	
	private static HashSet<Item> Craftable = new HashSet<Item>();
	private static HashSet<Item[]> CraftedBy = new HashSet<Item[]>();
	private static MetalChunk MC = new MetalChunk();
	private static Candle C = new Candle();
	/**
	 * constructor for the Sword
	 * @param game
	 */
	public Sword() {
		super(Craftable, CraftedBy, "sword");
		Item[] a = {MC, C};
		CraftedBy.add(a);
		Craftable.add(MC);
	}
	
	public String ability(Room room) {
		if (room.getProperties().containsKey("enemy")) {
			return "You killed the enemy";
		} else {
			return "Stop flailing your sword about! There is nothing to fight in here!";
		}
	}

	
}
