package game;

import java.util.HashSet;
import java.util.Set;

public class BucketWithSand extends Key {

	private Player player;
	private static HashSet<Item> Craftable = new HashSet<Item>();
	private static HashSet<Item[]> CraftedBy = new HashSet<Item[]>();
	private TwoWayDoor door;
	private static Bucket B = new Bucket();
	private static Shovel SH = new Shovel();
	
	
	public BucketWithSand(TwoWayDoor door) {
		super(Craftable, CraftedBy,  door, "bucketwithsand");
		this.door = door;
		Craftable.add(B);
		Item[] a = {B, SH};
		CraftedBy.add(a);
		// TODO Auto-generated constructor stub
	}
	public BucketWithSand() {
		super(Craftable, CraftedBy, "bucketwithsand");
		Craftable.add(B);
		Item[] a = {B, SH};
		CraftedBy.add(a);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String ability(Room room) {
			return "You place the bucket-shaped sand and get to building your architetual masterpiece. Time goes by and before you realize it you've crafted"
					+ " a magnificent castle, but something seems off... Is the castle growing? You stand in awe as your humble craft transforms into a towering building"
					+ " detailed with moats, drawbridge, spiraling staircases and so much more. In the distance you hear a bark, you remember your purpose. The Sand Castle "
					+ " lays before you with no way to go but through it. ";
		
		//return "You can't use that here!";
	}
	
	
}
