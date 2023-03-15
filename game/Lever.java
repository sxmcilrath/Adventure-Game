package game;

import java.util.HashSet;

public class Lever {
	
	private boolean red = false;
	private boolean green = false;
	private boolean blue = false;
	private Game game;
	
	public Lever(Game game) {
		this.game = game;
	}
	
	public void reset() {
		red = false;
		green = false;
		blue = false;
	}
	public String ability(Room room) {
		String name = room.getName();
		if(name.equals("white")) {
			System.out.println(red);
			
			//check if levers have been pressed in the correct order
			if(red && green && blue) {
				game.linkThroneRoom();
				return "To your amazemement, the room starts to shake. The wall to your left slowly falls away, "
						+ "revealing a grand entrance to what seems to be the throne room. Sibyl looks at you in shock,"
						+ "realizing that her job may now be in jeopardy";
			}
			reset();
			return "You pull the lever and hope for the best";
		}
		if(name.equals("red")) {
			
			if(green && blue && !red) {
				red = true;
			}
			else {
				reset();
				return "You pull the lever and hope for the best";
			}
			
		}
		
		if(name.equals("green")) {
			if (!red && !green && !blue) {
				green = true;
			}
			else {
				reset();
				return "You pull the lever and hope for the best";
			}
			
		}
		if(name.equals("blue")) {
			if(!red && !blue && green) {
				blue = true;
				
			}
			else {
				reset();
				return "You pull the lever and hope for the best";
			}
		}
		return "Huh?";
	}

}
