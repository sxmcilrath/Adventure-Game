package game;

import java.util.HashSet;
import java.util.Set;

public class BucketWithSand extends Key {

	private Player player;
	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	private LockedDoor door;
	private static Bucket B = new Bucket();
	private static Shovel SH = new Shovel();
	
	
	public BucketWithSand() {
		super(Craftable, CraftedBy, "bucketwithsand");
		//Craftable.add(B);
		Item[] a = {B, SH};
		//CraftedBy.add(a);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String ability(Room room) {
			return "You place the bucket-shaped sand and get to building your architetual masterpiece.\n"
					+ "Time goes by and before you realize it you've crafted a magnificent castle, but something seems off... \n"
					+ "Is the castle growing? You stand in awe as your humble craft transforms into a towering building.\n"
					+ "Detailed with moats, drawbridge, spiraling staircases and so much more. In the distance you hear a bark, you remember your purpose.\n"
					+ "The Sand Castle lays before you with no way to go but through it. ";
		
		//return "You can't use that here!";
	}
	
	
}
