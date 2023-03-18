package game;

import java.util.HashMap;

public class Key extends Item{

	
	protected Key(String name) {
		super(name);
	}
	
	public String getName() {
		return this.myName;
	}
	
	
	public String ability(Room room, HashMap<String, Item> backpack) {
		
		return "It feels rusty, good thing you got your tetnis shot";
	}

	
}
