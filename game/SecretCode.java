package game;

import java.util.HashSet;

public class SecretCode extends Item {

	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	
	public SecretCode() {
		super(Craftable, CraftedBy);
	}
	
	/**
	 * Reads out the riddle to figure out lever order
	 */
	public String ability(Room room) {
		return "You hold up the piece of paper. On it in an an ancient font it reads:\n"
				+ "Grass is green \n"
				+ "The sky is blue \n"
				+ "My favorite color is orange, but I guess red will do\n"
				+ "There's another line scribbled on after but the only word you can make out is white./n"
				+ "What could this mean?";
	}

}
