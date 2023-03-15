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
		AllItems.put("candle", new Candle());
		AllItems.put("metalchunk", new MetalChunk());
		AllItems.put("shovel", new Shovel());
		AllItems.put("steak", new Steak());
		AllItems.put("sword", new Sword());
	}
	

	public Set<String> canCraft() {
		Craftable = new HashSet<String>();
		//copy contains every Item the user has
		Collection<Item> copy = backpack.values();
		for(Item i: copy) {
			//Craftable adds string of all items that Backpack(copy) items are materials in
			for (Item a : i.craftable()) {
			this.Craftable.add(a.getName());	
			}
		}		
		return Craftable;
	}
	

	public String crafted(String toCraft) {
		Craftable = canCraft();
		if(Craftable.contains(toCraft)) {
			
			Item item = AllItems.get(toCraft);
			for(Item[] i : item.CraftedBy) {
				boolean hasAll = true;
				for (Item x : i) {
					if(!(backpack.keySet().contains(x.getName()))) {
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
		//if the user attempts to craft a nonexistent item
		String[] randomReturn = {"Harry Potter?", "A Simulation?", "The Hunger Games?", "America's Got Talent?", "CSCI245?"
				, "Bob the Builder?", "A Survival Game?"};
		
		return "What do you think this is, " + randomReturn[(int) (Math.random() * 7)];
		
	}

	private void remove(String toCraft, Item item, Item[] i) {
		backpack.put(toCraft, item);
		for(Item remove : i) {
			if(!(AllItems.get(remove.getName()).catalystOf().contains(item))) {
				backpack.remove(remove.getName());
			}
		}
	}
	
}
