package game;

import java.util.HashSet;
import java.util.Set;

public class BucketWithSand implements Item {

	private Player player;
	private HashSet<String> Craftable = new HashSet<String>();
	private HashSet<String> CraftedBy = new HashSet<String>();
	
	public BucketWithSand(Player player) {
		this.player = player;
		Craftable.add("bucket");
		CraftedBy.add("bucket");
		CraftedBy.add("sand");
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
