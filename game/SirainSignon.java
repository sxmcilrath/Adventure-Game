/**
 * SirainSignon
 * 
 * Sirain teaches the player all about free will (within heavy limits, of course)
 * 
 * @author Camden Flannagan
 */

package game;

public class SirainSignon extends NPC {

	/**
	 * the number of times Sirain has been talked to
	 */
	private int numTalked = 0;
	
	/**
	 * all the things that Sirain can say
	 */
	private String[] says = {"What are you lookin' at me for? Pick a direction and go! How am I supposed to know "
			+ "where you should go? \nI've been in this spot my whole life! What, just 'cause you have "
			+ "three options for which way to go, you're freakin' out? \nListen, if you're really "
			+ "so bothered by not knowin' where to go, just head north and talk to Simon.", 
			"My name is Sirain, by the way.", "Sineus is the guy at the front of the forest. He's nice.",
			"Look, Simon is wiser than I am. I can't really help you that much. \nFor goodness sake, my "
			+ "only real function in the game is to tell you to go north!", "Alright buddy, move along. "
					+ "This is my last original line of dialogue anyway. \nI'll just repeat things "
					+ "from now on."};
	private String postTree = "So you went to the tree did ya? Good for you. Now go east to start your journey.\n"
			+ "Be sure to pet the dog outside the cabin!";
	
	/**
	 * Method for Sirain to talk to the player
	 * @return Sirain's words of wisdom
	 */
	public String talk() {
		return cycleTalk(numTalked++, says);
	}

}
