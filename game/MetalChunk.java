package game;

import java.util.HashSet;
import java.util.Set;

public class MetalChunk implements Item {

	private HashSet<String> Craftable = new HashSet<String>();
	private HashSet<String> CraftedBy = new HashSet<String>();
	
	public MetalChunk () {
		Craftable.add("bucket");
		Craftable.add("sword");
		Craftable.add("shovel");
	}
	@Override
	public String ability(Room room) {
		// restore hunger
		return "";
	}
	
	
	public Set<String> craftable() {
		// TODO Auto-generated method stub
		return this.Craftable;
	}
	@Override
	public Set<String> craftedBy() {
		// TODO Auto-generated method stub
		return this.CraftedBy;
	}

}
