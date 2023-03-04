package game;


import java.util.HashSet;
import java.util.Set;

public abstract class Item {
	
	
	protected HashSet<String> Craftable = new HashSet<String>();
	protected HashSet<String> CraftedBy = new HashSet<String>();
	protected String myName;
	
	protected Item(HashSet<String> Craftable, HashSet<String> craftedBy) {
		this.Craftable = Craftable;
		this.CraftedBy = CraftedBy;
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
	protected Set<String> craftedBy() {
		// TODO Auto-generated method stub
		return this.CraftedBy;
	}
	
	protected String getName() {
		return this.myName;
	}
	
}
