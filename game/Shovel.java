package game;

public class Shovel implements Item {

	private Game game;
	
	public Shovel(Game game){this.game = game; }
	
	@Override
	public String ability(Room room) {
		//need to first add a check to make sure they are in the beach room
		if(game.hasItem("bucket")) {
			return "You shovel the sand into your bucket"; 
		}
		return "you can't use that here!";
	}

}
