package game;

import java.util.HashSet;

public class Key extends Item{
	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String> CraftedBy = new HashSet<String>();
	
	protected Door door;
	protected String name;
	
	protected Key(HashSet<String> Craftable, HashSet<String> craftedBy, Door door, String name) {
		super(Craftable, craftedBy);
		this.door = door;
		this.name = name;
		
	}
	public Key(Door door, String name) {
		super(Craftable, CraftedBy);
		this.door = door;
		this.name = name;
		
		
	}
	public Door getDoor() {
		return this.door;
	}
	
	
	public String ability(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
