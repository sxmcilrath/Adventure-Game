package game;

import java.util.HashSet;
import java.util.Set;

public class Candle extends Item {

	private static HashSet<Item> Craftable = new HashSet<Item>();
	private static HashSet<Item[]> CraftedBy = new HashSet<Item[]>();

	/**
	 * constructor for Candle
	 */
	public Candle() {
		super(Craftable, CraftedBy, "candle");
		Craftable.add(new Sword());
		Craftable.add(new Shovel());
		Item[] a = {};
		CraftedBy.add(a);
		
	}
	
	@Override
	public String ability(Room room) {
		//light up the room if it is dark
		if (room.getProperties().containsKey("dark")) {
			room.getProperties().remove("dark");
			return "The dark room has been lit up";
		} else {
			return "Why are you using a candle in a bright room?";
		}
		
	}
	


}
