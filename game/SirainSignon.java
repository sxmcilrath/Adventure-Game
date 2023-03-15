/**
 * SirainSignon
 * 
 * Sirain teaches the player all about free will (within heavy limits, of course)
 * He only has one line
 */

package game;

public class SirainSignon extends NPC {

	
	private int numTalked = 0;
	private String[] says = {"What are you lookin' at me for? Pick a direction and go! How am I supposed to know "
			+ "where you should go? I've been in this spot my whole life! What, just 'cause you have "
			+ "three options for which way to go, you're freakin' out? Listen, if you're really "
			+ "so bothered by not knowin' where to go, just head north and talk to Simon.", 
			"My name is Sirain, by the way.", "Sineus is the guy at the front of the forest. He's nice.",
			"Look, Simon is wiser than I am. I can't really help you that much. For goodness sake, my "
			+ "only real function in the game is to tell you to go north!", "Alright buddy, move along. "
					+ "This is my last original line of dialogue anyway. I'll just repeat things "
					+ "from now on."};
	
	/**
	 * constructor for Sirain
	 */
	public SirainSignon() {

	}
	
	/**
	 * Method for Sirain to talk to the player
	 * @param progression How far the player is into the game
	 * @return Sirain's words of wisdom
	 */
	public String talk() {
		int temp = numTalked;
		numTalked++;
		return says[temp%says.length];
	}

}
