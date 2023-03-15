package game;

import java.util.HashSet;

public class SecretCode extends Item {

	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	
	public SecretCode() {
		super(Craftable, CraftedBy);
	}
	public String ability(Room room) {
		// TODO Auto-generated method stub
		return "You hold up the piece of paper. On it in an an ancient font it reads:\n "
				+ "Grass is green \n"
				+ "The sky is blue \n"
				+ "My favorite color is orange, but I guess red will do\n"
				+ "what could this mean";
	}

}
