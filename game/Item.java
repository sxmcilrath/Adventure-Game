/**
 * Item
 * 
 * Abstract class providing a blueprint for items, things that the player can pick up in the world
 * 
 * @author Camden Flannagan and Lincoln Going
 */

package game;


import java.util.HashSet;
import java.util.Set;

public abstract class Item {
	
	/**
	 * the set of names of items that are craftable? LINCOLN IS THIS RIGHT???
	 */
	protected HashSet<String> Craftable = new HashSet<String>();
	
	/**
	 * I'm sure its very important, because it's used everywhere.
	 */
	protected HashSet<String[]> CraftedBy = new HashSet<String[]>();
	
	/**
	 * Honestly, I've only got half a clue what this does
	 */
	protected HashSet<String> Catalyst = new HashSet<String>();
	
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
	protected Item(HashSet<String> craftable2, HashSet<String[]> craftedBy2, String myName) {
		this.Craftable = craftable2;
		this.CraftedBy = craftedBy2;
		this.myName = myName;
	}
	
	/**
	 * overloaded constructor for items that need catalysts
	 * @param Craftable
	 * @param CraftedBy
	 * @param myName
	 * @param Catalyst
	 */
	protected Item(HashSet<String> Craftable, HashSet<String[]> CraftedBy, String myName, HashSet<String> Catalyst) {
		this.Craftable = Craftable;
		this.CraftedBy = CraftedBy;
		this.Catalyst = Catalyst;
		this.myName = myName;
	}
	/**
	 * This method will call upon a rooms properties to dictate what
	 * should happen when the item is used. Each item will look for
	 * different room properties and effect them differently
	 * @param room The room that the item interacts with
	 * @return a string that will tell the player what happened
	 */
	protected abstract String ability(Room room);
	
	
	protected Set<String> craftable() {
		// TODO Auto-generated method stub
		return this.Craftable;
	}
	protected Set<String[]> craftedBy() {
		// TODO Auto-generated method stub
		return this.CraftedBy;
	}

	protected Set<String> catalystOf() {
		// TODO Auto-generated method stubprotected
		return this.Catalyst;
	}
	
	/**
	 * getter method for the name of the item
	 * @return the name of the item
	 */
	protected String getName() {
		return this.myName;
	}
	
}
