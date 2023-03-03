package game;

import java.util.HashSet;
import java.util.Set;

public class BucketWithSand extends Item {

	private Player player;
	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String> CraftedBy = new HashSet<String>();
	
	public BucketWithSand(Player player) {
		super(Craftable, CraftedBy);
		this.player = player;
		Craftable.add("bucket");
		CraftedBy.add("bucket");
		CraftedBy.add("sand");
	}
	
	public BucketWithSand() {
		super(Craftable, CraftedBy);
		Craftable.add("bucket");
		CraftedBy.add("bucket");
		CraftedBy.add("sand");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String ability(Room room) {
		if(room.getName().equals("beach")){
			
			player.removeItemFromBackapack("bucketwithsand");
			player.crossCheckpoint("beachPuzzle");
			//this should just become using a key. 
			//player.linkSandRooms();
			return "You place the bucket-shaped sand and get to building your architetual masterpiece. Time goes by and before you realize it you've crafted"
					+ " a magnificent castle, but something seems off... Is the castle growing? You stand in awe as your humble craft transforms into a towering building"
					+ " detailed with moats, drawbridge, spiraling staircases and so much more. In the distance you hear a bark, you remember your purpose. The Sand Castle "
					+ " lays before you with no way to go but through it. ";
		}
		return "You can't use that here!";
	}
	
	
}
