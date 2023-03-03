package game;


import java.util.Set;

public interface Item {
	/**
	 * This method will call upon a rooms properties to dictate what
	 * should happen when the item is used. Each item will look for
	 * different room properties and effect them differently
	 * @param room The room that the item interacts with
	 * @return a string that will tell the player what happened
	 */
	public String ability(Room room);
	public Set<String> craftable();
	public Set<String> craftedBy();
	
}
