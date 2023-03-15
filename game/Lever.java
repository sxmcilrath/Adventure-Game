package game;

import java.util.HashSet;

public class Lever extends Item {

	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	
	private boolean red = false;
	private boolean green = false;
	private boolean blue = false;
	private Game game;
	
	public Lever(Game game) {
		super(Craftable, CraftedBy);
		this.game = game;
	}
	@Override
	public String ability(Room room) {
		if(room.getName().equals("white")) {
			if(red && green && blue) {
				
			}
		}
		return null;
	}

}
