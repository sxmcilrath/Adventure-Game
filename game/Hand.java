package game;

import java.util.HashSet;

public class Hand implements Item {

	/**
	 * the game for the hand to interact with
	 */
	private Game game;
	
	/**
	 * constructor for Hand
	 */
	public Hand(Game game) {
		this.game = game;
	}
	
	public String ability(Room room) {
		HashSet<String> properties = room.getProperties();
		if (properties.contains("dog")) {
			return "You pet the dog. He is a good boy.";
		} else if (properties.contains("candle")) {
			properties.remove("candle");
			return "You picked up the candle!";
		} else if (properties.contains("sword")) {
			properties.remove("sword");
			game.addItemToBackpack("sword", new Sword(game));
			return "You picked up the sword!";
		}
		return "Nothing happened.";
	}

}
