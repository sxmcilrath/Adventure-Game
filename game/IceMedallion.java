package game;

import java.util.HashMap;

/**
 * 
 * medallion that is obtained in the ice castle. It can be combined with the
 * sand medallion to create the final key
 *
 */
public class IceMedallion extends Item {


	
	public IceMedallion() {
		super("icemedallion");		
	}
	
	@Override
	protected String ability(Room room, HashMap<String, Item> backpack) {
		return "It's cold to the touch";
	}

}
