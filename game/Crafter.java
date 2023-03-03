package game;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Crafter {
	private Player player;
	private HashSet<String> Craftable;
	
	public Crafter() {
	}
	
	@SuppressWarnings("unchecked")
	public Set canCraft(HashMap<String, Item> backpack) {
		Craftable = new HashSet<String>();
		Collection<Item> copy = backpack.values();
		for(Item i: copy) {
			this.Craftable.addAll(i.craftable());
			this.Craftable.containsAll(i.craftedBy())
		}
		for(Item i : this.Craftable) {
		//	if(i.)
		}
		
		return Craftable;
	}
	
	
	
}
