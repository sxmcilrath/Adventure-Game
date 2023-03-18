package game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Crafter {
	
    private Map<Item[], Item> Craftable;
	private Map<String,Item[]> accessor;
	private HashMap<String,Item> backpack;
	private HashMap<Set<Item[]>, Item> methods = new HashMap<Set<Item[]>,Item>();

	
	public Crafter(HashMap<String,Item> backpack) {
		this.backpack = backpack;
		
		Item[][] bucket = {{new Candle(), new MetalChunk()}};
		methods.put(intialHelper(bucket), new Bucket());
		Item[][] metalchunk = {{new Sword()}, {new Bucket()}, {new Shovel()}};
		methods.put(intialHelper(metalchunk), new MetalChunk());		
		Item[][] shovel = {{new MetalChunk(), new Candle()}};
		methods.put(intialHelper(shovel), new Shovel());
		Item[][] sword = {{new MetalChunk(), new Candle()}};
		methods.put( intialHelper(sword), new Sword());
		Item[][] bws = {{new Bucket(), new Shovel()}};
		methods.put(intialHelper(bws), new BucketWithSand());
		Item[][] tocastle = {{new SandMedallion(), new IceMedallion()}};
		methods.put(intialHelper(tocastle), new Key("tocastle"));
		
	}
	
	public  Set<Item[]> intialHelper( Item[][] i) {
		HashSet<Item[]> temp = new HashSet<Item[]>();
		for(Item[] ia : i) {
		temp.add(ia);
		}
		return temp;
	}
	

	public Set<String> canCraft() {
		//System.out.println(backpack.keySet().toString());
		Craftable = new HashMap<Item[], Item>();
		accessor = new HashMap<String,Item[]>();
		Iterator<Set<Item[]>> iterator = methods.keySet().iterator();  //Iterates each craftable object
		while(iterator.hasNext()) {
			Set<Item[]> toAdd = iterator.next(); 
			Iterator<Item[]> temp = toAdd.iterator();  //iterates each method for each craftable object
			while(temp.hasNext()) {
				Item[] i = temp.next();
				int options = 0;
				boolean containsAll = true; 
				for(Item j: i) {
					if (!(backpack.containsKey(j.getName()))){
						containsAll = false;
					}
				}
				if(containsAll) { //if the backpack has each item of the method
						Craftable.put(i, methods.get(toAdd));
						if(accessor.containsKey(methods.get(toAdd).getName()) || backpack.containsKey(methods.get(toAdd).getName())) {	
							options++;
						this.accessor.put(methods.get(toAdd).getName() + options, i);
					} 
					this.accessor.put(methods.get(toAdd).getName(), i);
				}
			}
		}
		Set<String> toReturn = accessor.keySet();
		return toReturn;
	}
	

	public String crafted(String toCraft) {
		Set<String> cancraft = canCraft();
		if(cancraft.contains(toCraft)) {
			Item toBackpack = Craftable.get(accessor.get(toCraft));
			backpack.put(toCraft, toBackpack);
			for(Item i : accessor.get(toCraft)) {
					if(backpack.keySet().contains(i.getName())) {
						backpack.remove(i.getName());
					}
				}
			//Craftable = null;
			return toCraft + " crafted";
			} else {
				//Craftable = null;
				return "you need more materials";
			}
	
		}
		/*if the user attempts to craft a nonexistent item
		String[] randomReturn = {"Harry Potter?", "A Simulation?", "The Hunger Games?", "America's Got Talent?", "CSCI245?"
				, "Bob the Builder?", "A Survival Game?"};
		
		return "What do you think this is, " + randomReturn[(int) (Math.random() * 7)]; 
		
	//}

	private void remove(String toCraft, Item item, Item[] i) {
		backpack.put(toCraft, item);
		for(Item remove : i) {
			if(!(AllItems.get(remove.getName()).catalystOf().contains(item))) {
				backpack.remove(remove.getName());
			}
		}
	} */
	
}
