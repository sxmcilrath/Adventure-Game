package game;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Crafter {
	private Player player;
	private HashSet<String> Craftable;
	private HashMap<String,Item> AllItems = new HashMap<String,Item>();
	private HashSet<Item> toItem = new HashSet<Item>();
	private HashSet<String> hasKeys = new HashSet<String>();
	
	public Crafter() {
		AllItems.put("bucket", new Bucket());
		AllItems.put("bucketwithsand", new BucketWithSand());
		AllItems.put("candle", new Candle());
		AllItems.put("metalchunk", new MetalChunk());
		AllItems.put("shovel", new Shovel());
		AllItems.put("steak", new Steak());
		AllItems.put("Sword", new Sword());
	}
	
	@SuppressWarnings("unchecked")
	public Set canCraft(HashMap<String, Item> backpack) {
		Craftable = new HashSet<String>();
		//copy contains every Item the user has
		Collection<Item> copy = backpack.values();
		for(Item i: copy) {
			//Craftable adds string of all items that Backpack(copy) items are materials in
			this.Craftable.addAll(i.craftable());		
		}
		this.toItem = new HashSet<Item>();
		for(String j : Craftable) {
			toItem.add(AllItems.get(j));
		}
		this.hasKeys = (HashSet<String>) backpack.keySet();
		for(Item k : toItem) {
			if(!(hasKeys.containsAll(k.craftedBy()))) {
				Craftable.remove(k);
			}
		}
		
		return Craftable;
	}
	
	
	
}
