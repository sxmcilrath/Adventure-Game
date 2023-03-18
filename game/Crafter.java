package game;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Crafter {
	//Craftable stores the items craftable by backpack from recipes
    private Map<Item[], Item> Craftable;
    //String is to access craftable with a command room the user input
	private Map<String,Item[]> accessor;
	private HashMap<String,Item> backpack;
	//recipe contains all crafting mechanisms. This includes multiple ways to crat the same item, hence the hashset of item[];
	private HashMap<Set<Item[]>, Item> recipes = new HashMap<Set<Item[]>,Item>();

	
	public Crafter(HashMap<String,Item> backpack) {
		this.backpack = backpack;
		
		Item[][] bucket = {{new Candle(), new MetalChunk()}};
		recipes.put(intialHelper(bucket), new Bucket());
		Item[][] metalchunk = {{new Sword()}, {new Bucket()}, {new Shovel()}};
		recipes.put(intialHelper(metalchunk), new MetalChunk());		
		Item[][] shovel = {{new MetalChunk(), new Candle()}};
		recipes.put(intialHelper(shovel), new Shovel());
		Item[][] sword = {{new MetalChunk(), new Candle()}};
		recipes.put( intialHelper(sword), new Sword());
		Item[][] bws = {{new Bucket(), new Shovel()}};
		recipes.put(intialHelper(bws), new BucketWithSand());
		Item[][] tocastle = {{new SandMedallion(), new IceMedallion()}};
		recipes.put(intialHelper(tocastle), new Key("tocastle"));
		
	}
	
	//initial helper reduces code lines by adding items to the hashset
	public  Set<Item[]> intialHelper( Item[][] i) {
		HashSet<Item[]> temp = new HashSet<Item[]>();
		for(Item[] ia : i) {
		temp.add(ia);
		}
		return temp;
	}
	
    //returns all craftable items in a string name;
	public Set<String> canCraft() {
		//Resets crafter and accessor Maps
		Craftable = new HashMap<Item[], Item>();
		accessor = new HashMap<String,Item[]>();		
		Iterator<Set<Item[]>> iterator = recipes.keySet().iterator();  //Iterates each craftable object
		while(iterator.hasNext()) {
			Set<Item[]> toAdd = iterator.next(); 
			Iterator<Item[]> temp = toAdd.iterator();  //iterates each method for each craftable object
			while(temp.hasNext()) {
				Item[] i = temp.next();
				boolean containsAll = true; 
				for(Item j: i) {
					if (!(backpack.containsKey(j.getName()))){
						containsAll = false;
					}
				}
				if(containsAll) { //if the backpack has each item of the method
						Craftable.put(i, recipes.get(toAdd));
					    this.accessor.put(recipes.get(toAdd).getName(), i);
				}
			}
		}
		return accessor.keySet();
	}
	
	
//Crafts the items and deletes the consumed items
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
			
			return toCraft + " crafted";
			} else {
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
