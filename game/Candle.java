package game;

public class Candle implements Item {

	@Override
	public String ability(Room room) {
		//light up the room if it is dark
		if (room.getProperties().contains("dark")) {
			room.getProperties().remove("dark");
			return "The dark room has been lit up";
		} else {
			return "Why are you using a candle in a bright room?";
		}
		
	}

}
