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
	
	public String ability(Room room, String property) {
		HashSet<String> properties = room.getProperties();
		
		//checks if the property if is the room
		if (properties.contains(property)) {
				game.addItemToBackpack("sword", new Sword());
				properties.remove("sword");
				return "You picked up the " + property;
			}
		return "Nothing happened.";
		
	}

	@Override
	public String ability(Room room) {
		if(room.getProperties().contains("sword")) {
			game.addItemToBackpack("sword", new Sword());
			room.getProperties().remove("sword");
		}
		
		return null;
	}



}
