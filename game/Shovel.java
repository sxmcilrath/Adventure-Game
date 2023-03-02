package game;

public class Shovel implements Item {

	private Game game;
	
	public Shovel(Game game){this.game = game; }
	
	@Override
	public String ability(Room room) {
		//need to first add a check to make sure they are in the beach room
		if(room.getName().equals("beach")){
			
			if(game.hasItem("bucket")) {
				game.removeItemFromBackapack("bucket");
				game.addItemToBackpack("bucketwithsand", new BucketWithSand(game));
				return "You shovel the sand into your bucket"; 
			}
			
			return "You push sand around for a couple minutes. This seems pointless. If only there was something to shape the sand...";
		}
		
		return "You can't use that here!";
	}

}
