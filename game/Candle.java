package game;

import java.util.HashSet;
import java.util.Set;

public class Candle extends Item {

	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();

	/**
	 * constructor for Candle
	 */
	public Candle() {
		super(Craftable, CraftedBy, "candle");
		Craftable.add("sword");
		Craftable.add("shovel");
		String[] a = {};
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
