package game;



public class BucketWithSand extends Key {

	
	public BucketWithSand() {
		super("bucketwithsand");
	}
	
	@Override
	public String ability(Room room) {

		room.addProperty("tosandcastle", new Key("tosandcastle"));
			return "You place the bucket-shaped sand and get to building your architetual masterpiece.\n"
					+ "Time goes by and before you realize it you've crafted a magnificent castle, but something seems off...\n"
					+ "Is the castle growing? You stand in awe as your humble craft transforms into a towering building\n"
					+ "detailed with moats, drawbridge, spiraling staircases and so much more.\n"
					+ "In the distance you hear a bark, you remember your purpose.\n"
					+ "The Sand Castle lays before you with no way to go but through it. ";
		
		//return "You can't use that here!";
	}
	
	
}
