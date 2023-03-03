package game;

import java.util.HashSet;
import java.util.Set;

public class Candle implements Item {

	private HashSet<String> Craftable = new HashSet<String>();
	private HashSet<String> CraftedBy = new HashSet<String>();

	/**
	 * constructor for Candle
	 */
	public Candle() {
		Craftable.add("bucket");
		Craftable.add("sword");
		Craftable.add("shovel");
		CraftedBy.add("");
	}
	
	@Override
	public String ability(Room room) {
		//light up the room if it is dark
		if (room.getProperties().contains("dark")) {
			room.getProperties().remove("dark");
			return "The dark room has been lit up";
		} else {
			return "Why are you using a candle in a bright room?";
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
