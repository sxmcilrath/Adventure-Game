package game;

import java.util.HashSet;
import java.util.Set;

public class Shovel extends Item {

	private Player player;
	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	private static HashSet<String> Catalyst = new HashSet<String>();
	
	public Shovel() {
		super(Craftable, CraftedBy, Catalyst);
		String[] a = {"metalchunk", "candle"};
		CraftedBy.add(a);
		Craftable.add("stick");
		Craftable.add("metalchunk");
		Catalyst.add("bucketwithsand");
	}

	@Override
	public String ability(Room room) {
		//need to first add a check to make sure they are in the beach room
		if(room.getName().equals("beach")){
			
			if(player.hasItem("bucket")) {
				player.removeItemFromBackapack("bucket");
				//player.addItemToBackpack("bucketwithsand", new BucketWithSand(player));
				return "You shovel the sand into your bucket"; 
			}
			
			return "You push sand around for a couple minutes. This seems pointless. If only there was something to shape the sand...";
		}
		
		return "You can't use that here!";
	}
	
	

	
}
