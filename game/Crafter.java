package game;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Crafter {
	private Player player;
	private Set<String> Craftable;
	private Map<String,Item> AllItems = new HashMap<String,Item>();
	private HashMap<String,Item> backpack;
	private Set<Item> toItem = new HashSet<Item>();
	private Set<String> hasKeys = new HashSet<String>();
	
	public Crafter(HashMap<String,Item> backpack) {
		this.backpack = backpack;
		AllItems.put("bucket", new Bucket());
		AllItems.put("bucketwithsand", new BucketWithSand());
		AllItems.put("candle", new Candle());
		AllItems.put("metalchunk", new MetalChunk());
		AllItems.put("shovel", new Shovel());
		AllItems.put("steak", new Steak());
		AllItems.put("Sword", new Sword());
	}
	
	public Set canCraft() {
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
		this.hasKeys = (Set<String>) backpack.keySet();
		for(Item k : toItem) {
			if(!(hasKeys.containsAll(k.craftedBy()))) {
				Craftable.remove(k);
			}
		}
		
		return Craftable;
	}
	
	public String crafted(String toCraft) {
		Craftable = canCraft();
		if(Craftable.contains(toCraft)) {
			Item temp = AllItems.get(toCraft);
			backpack.put(toCraft, temp);
			//for (String i : temp.CraftedBy) {
			backpack.remove("sword");
			return toCraft + " crafted";
		}
		
		if(AllItems.containsKey(toCraft)) {
		return "you dont have all the materials";
		}
		String[] randomReturn = {"Harry Potter?", "A Simulation?", "The Hunger Games?", "America's Got Talent?", "CSCI245?"
				, "Bob the Builder?", "A Survival Game?"};
		
		return "What do you think this is " + randomReturn[(int) (Math.random() * 7)];
		
	}
	
	
	
}
