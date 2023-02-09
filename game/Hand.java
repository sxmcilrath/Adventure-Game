package game;

import java.util.HashSet;

public class Hand implements Item {

	@Override
	public String ability(Room room) {
		HashSet<String> properties = room.getProperties();
		if (properties.contains("dog")) {
			return "You pet the dog. He is a good boy.";
		} else if (properties.contains("candle")) {
			properties.remove("candle");
			return "You picked up the candle!";
		}
		return "Nothing happened.";
	}

}
