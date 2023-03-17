package game;

import java.util.HashSet;
import java.util.Set;

public class Bucket extends Item {

	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	
	
	public Bucket() {
		super(Craftable, CraftedBy, "bucket");
		Craftable.add("metalchunk");
		Craftable.add("bucketwithsand");
		String[] a = {"metalchunk", "candle"};
		CraftedBy.add(a);
		
		
	
		
	}
	@Override
	public String ability(Room room) {
		// TODO Auto-generated method stub
		if(room.getName().equals("beach")) {
			return "Huh, nothing's inside. Cool bucket though!";
		}
		return "You can't use that here!";
	}

	
	

}
