package game;

public class Sword implements Item {

	/**
	 * the game that the sword is affecting
	 */
	private Game game;
	
	/**
	 * constructor for the Sword
	 * @param game
	 */
	public Sword(Game game) {
		this.game = game;
	}
	
	public String ability(Room room) {
		if (room.getProperties().contains("enemy")) {
			return "You killed the enemy";
		} else {
			return "Stop flailing your sword about! There is nothing to fight in here!";
		}
	}

}
