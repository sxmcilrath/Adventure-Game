package game;

import java.util.HashMap;

public class Candle extends Item {

	
	/**
	 * constructor for Candle
	 */
	public Candle() {
		super("candle");
	}
	
	@Override
	public String ability(Room room, HashMap<String, Item> backpack) {
		//light up the room if it is dark
		backpack.remove(getName());
			return "Why are you using a candle in a bright room? \n The candle burns out...";
		}
		
	}
	
