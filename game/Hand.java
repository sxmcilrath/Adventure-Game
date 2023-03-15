package game;

import java.util.HashSet;
import java.util.Set;

public class Hand  {
	
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
		//SAM here: I did change this from a Hashset of strings to Item in order for it to 
		//not throw an error. Change it back later if that's not in the design
		HashSet<Item> properties = room.getProperties();
		
		//checks if the property if is the room
		if (properties.contains(property)) {
			player.addItemToBackpack("sword", new Sword());
				properties.remove("sword");
				return "You picked up the " + property;
			}
		return "Nothing happened.";
		
	}


	public String ability(Room room) {
		if(room.getProperties().contains("sword")) {
			player.addItemToBackpack("sword", new Sword());
			room.getProperties().remove("sword");
		}
		
		return null;
	}

	

	public Set<String> craftable() {
		// TODO Auto-generated method stub
		return this.Craftable;
	}

	
	public Set<String> craftedBy() {
		// TODO Auto-generated method stub
		return this.CraftedBy;
	}

}
