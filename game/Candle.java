package game;


public class Candle extends Item {

	
	/**
	 * constructor for Candle
	 */
	public Candle() {
		super("candle");
	}
	
	@Override
	public String ability(Room room) {
		//light up the room if it is dark
		if (room.getProperties().containsKey("dark")) {
			room.getProperties().remove("dark");
			return "The dark room has been lit up";
		} else {
			return "Why are you using a candle in a bright room?";
		}
		
	}
	


}
