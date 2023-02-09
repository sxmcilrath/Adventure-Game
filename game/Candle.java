package game;

public class Candle implements Item {

	@Override
	public void ability(Room room) {
		//light up the room if it is dark
		if (room.getProperties().contains("dark")) {
			room.getProperties().remove("dark");
		} else {
			// tell player that was useless
		}
		
	}

}
