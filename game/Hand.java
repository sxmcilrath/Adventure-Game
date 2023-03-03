package game;

import java.util.HashSet;
import java.util.Set;

public class Hand extends Item {
	
	private HashSet<String> Craftable = new HashSet<String>();
	private HashSet<String> CraftedBy = new HashSet<String>();
	
	/**
	 * the game for the hand to interact with
	 */
	private Player player;
	
	/**
	 * constructor for Hand
	 */
	public Hand(Player player) {
		this.player = player;
	}
	
	public String ability(Room room, String property) {
		HashSet<String> properties = room.getProperties();
		
		//checks if the property if is the room
		if (properties.contains(property)) {
			player.addItemToBackpack("sword", new Sword());
				properties.remove("sword");
				return "You picked up the " + property;
			}
		return "Nothing happened.";
		
	}

	@Override
	public String ability(Room room) {
		if(room.getProperties().contains("sword")) {
			player.addItemToBackpack("sword", new Sword());
			room.getProperties().remove("sword");
		}
		
		return null;
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
