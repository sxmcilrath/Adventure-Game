package game;


import java.util.HashSet;
import java.util.Set;

public abstract class Item {
	
	
	protected HashSet<Item> Craftable = new HashSet<Item>();
	protected HashSet<Item[]> CraftedBy = new HashSet<Item[]>();
	protected HashSet<Item> Catalyst = new HashSet<Item>();
	protected String myName;
	
	protected Item(HashSet<Item> Craftable, HashSet<Item[]> CraftedBy, String myName) {
		this.Craftable = Craftable;
		this.CraftedBy = CraftedBy;
		this.myName = myName;
	}
	protected Item(HashSet<Item> Craftable, HashSet<Item[]> CraftedBy, String myName, HashSet<Item> Catalyst) {
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
	protected Set<Item> craftable() {
		// TODO Auto-generated method stub
		return this.Craftable;
	}
	protected Set<Item[]> craftedBy() {
		// TODO Auto-generated method stub
		return this.CraftedBy;
	}

	protected Set<Item> catalystOf() {
		// TODO Auto-generated method stubprotected
		return this.Catalyst;
	}
	
	protected String getName() {
		return this.myName;
	}
	
}
