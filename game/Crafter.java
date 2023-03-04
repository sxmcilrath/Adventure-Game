package game;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Crafter {
	private Set<String> Craftable;
	private Map<String,Item> AllItems = new HashMap<String,Item>();
	private HashMap<String,Item> backpack;
	
	
	public Crafter(HashMap<String,Item> backpack) {
		this.backpack = backpack;
		AllItems.put("bucket", new Bucket());
		//AllItems.put("bucketwithsand", new BucketWithSand());
		AllItems.put("candle", new Candle());
		AllItems.put("metalchunk", new MetalChunk());
		AllItems.put("shovel", new Shovel());
		AllItems.put("steak", new Steak());
		AllItems.put("sword", new Sword());
	}
	
	@SuppressWarnings("rawtypes")
	public Set canCraft() {
		Craftable = new HashSet<String>();
		//copy contains every Item the user has
		Collection<Item> copy = backpack.values();
		for(Item i: copy) {
			//Craftable adds string of all items that Backpack(copy) items are materials in
			this.Craftable.addAll(i.craftable());		
		}		
		return Craftable;
	}
	
	@SuppressWarnings("unchecked")
	public String crafted(String toCraft) {
		Craftable = canCraft();
		if(Craftable.contains(toCraft)) {
			Item item = AllItems.get(toCraft);
			for(String[] i : item.CraftedBy) {
				boolean hasAll = true;
				for(String j : i) {	
					if(!(backpack.keySet().contains(j))) {
						hasAll = false;
					}
				}
				if(hasAll == true) {
					remove(toCraft, item, i);
					return toCraft + " crafted";
				}
			}
		 if(AllItems.containsKey(toCraft)) {
				return "you need more materials";
			}
		}
		String[] randomReturn = {"Harry Potter?", "A Simulation?", "The Hunger Games?", "America's Got Talent?", "CSCI245?"
				, "Bob the Builder?", "A Survival Game?"};
		
		return "What do you think this is, " + randomReturn[(int) (Math.random() * 7)];
		
	}

	private void remove(String toCraft, Item item, String[] i) {
		backpack.put(toCraft, item);
		for(String remove : i) {
			if(!(AllItems.get(remove).catalystOf().contains(toCraft))) {
				backpack.remove(remove);
			}
		}
	}
	
}
