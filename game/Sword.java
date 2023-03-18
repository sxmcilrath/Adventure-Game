package game;

import java.util.HashMap;

public class Sword extends Item {

	
	/**
	 * constructor for the Sword
	 * @param game
	 */
	public Sword() {
		super("sword");
	}
	
	public String ability(Room room, HashMap<String, Item> backpack) {
		if (room.getProperties().containsKey("enemy")) {
			return "You killed the enemy";
		} else {
			return "Stop flailing your sword about! There is nothing to fight in here!";
		}
	}

	
}
