/**
 * Item
 * 
 * Abstract class providing a blueprint for items, things that the player can pick up in the world
 * 
 * @author Camden Flannagan and Lincoln Going
 */

package game;

import java.util.HashMap;

public abstract class Item {
	
	
	/**
	 * the name of the item
	 */
	protected String myName;
	
	/**
	 * constructor for item
	 * @param craftable2
	 * @param craftedBy2
	 * @param myName
	 */
	protected Item(String myName) {
		this.myName = myName;
	}

	/**
	 * This method will call upon a rooms properties to dictate what
	 * should happen when the item is used. Each item will look for
	 * different room properties and effect them differently
	 * @param room The room that the item interacts with
	 * @return a string that will tell the player what happened
	 */
	protected abstract String ability(Room room, HashMap<String, Item> backpack);
	
	/**
	 * getter method for the name of the item
	 * @return the name of the item
	 */
	protected String getName() {
		return this.myName;
	}
	
}
