package game;

import java.util.HashMap;

public class Steak extends Item {

	public Steak() {
		super("steak");
	}
	@Override
	public String ability(Room room, HashMap<String, Item> backpack) {
		backpack.remove(getName());
		return "You feel nourished.";
	}
	

	

}
