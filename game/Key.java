package game;

import java.util.HashSet;

public class Key extends Item{
	private static HashSet<Item> Craftable = new HashSet<Item>();
	private static HashSet<Item[]> CraftedBy = new HashSet<Item[]>();
	
	protected Door door;

	
	protected Key(HashSet<Item> craftable, HashSet<Item[]> craftedBy, TwoWayDoor door, String name) {
		super(craftable, craftedBy, name);
		this.door = door;
		
	}
	protected Key(HashSet<Item> Craftable, HashSet<Item[]> craftedBy, String name) {
		super(Craftable, craftedBy, name);
		
	}

	public Door getDoor() {
		return this.door;
	}
	
	public String getName() {
		return this.myName;
	}
	
	
	public String ability(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
