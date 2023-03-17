package game;


/**
 * Class that represents the lever puzzle.
 * There are 4 levers in 4 rooms and they need to be pressed 
 * in a certain order in order to correctly open up the final room
 *
 *Correct order of levers is green, blue, red, white
 */

public class Lever {
	
	private boolean red = false;	//boolean for if red is pressed in the right order
	private boolean green = false;	//bool for if green is pressed in the right order
	private boolean blue = false;	//bool for if blue is pressed in the right order
	private Game game;				//game variable in order to edit rooms
	
	/**
	 * constructor to pass in game
	 * @param game	current game
	 */
	public Lever(Game game) {
		this.game = game;
	}
	
	/**
	 * resets all variables if lever is pulled in the wrong order
	 */
	public void reset() {
		red = false;
		green = false;
		blue = false;
	}
	
	/**
	 * Based on what room the player is in and in what order 
	 * a lever is pulled, corresponding booleans are set to true/false
	 * and a text response is displayed 
	 * 
	 * @param room	current room the player is in
	 * @return		returns appropriate text response
	 */
	public String ability(Room room) {
		String name = room.getName();	//name of room
		
		//outer if statements check which room player is in and then inside checks order of lever pulls
		if(name.equals("white")) {
			
			if(red && green && blue) {
				room.addProperty("finalkey", new Key("finalkey"));
				return "To your amazemement, the room starts to shake.\nThe wall to your left slowly falls away, "
						+ "revealing a grand entrance to what seems to be the throne room. \nSibyl looks at you in shock,"
						+ "realizing that her job may now be in jeopardy";
			}
			reset();
			return "You pull the lever but nothing happens. You feel embarrassed.";
		}
		if(name.equals("red")) {
			
			if(green && blue && !red) {
				red = true;
				return "When you pull the lever, you hear a much louder click. You're close. ";
			}
			else {
				reset();
				return "You pull the lever and hope for the best. Nothing happens. There must be something you're missing.";
			}
			
		}
		
		if(name.equals("green")) {
			if (!red && !green && !blue) {
				green = true;
				return "When you pull the lever, you think you hear a click. It was too quiet to be sure though. ";
			}
			else {
				reset();
				return "You pull the lever and hope for the best";
			}
			
		}
		if(name.equals("blue")) {
			if(!red && !blue && green) {
				blue = true;
				return "When you pull the lever, you hear a click. You're definitely not imagining it. ";
			}
			else {
				reset();
				return "You pull the lever and hope for the best";
			}
		}
		return "There's nothing to pull";
	}

}
