package game;

import java.util.HashSet;
import java.util.Set;

public class Bucket implements Item {

	private HashSet<String> Craftable = new HashSet<String>();
	private HashSet<String> CraftedBy = new HashSet<String>();
	
	public Bucket() {
		Craftable.add("metalChunk");
		CraftedBy.add("metalchunk");
		CraftedBy.add("candle");
		
	}
	@Override
	public String ability(Room room) {
		// TODO Auto-generated method stub
		if(room.getName().equals("beach")) {
			return "Huh, nothing's inside. Cool bucket though!";
		}
		return "You can't use that here!";
	}

	
	@Override
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
