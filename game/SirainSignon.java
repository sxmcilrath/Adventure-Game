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
	 * the number of times Sirain has been talked to before talking to Simon
	 */
	private int preSimonCounter = 0;
	
	/**
	 * all the things that Sirain can say before you talk to Simon
	 */
	private String[] preSimon = {"What are you lookin' at me for? Pick a direction and go! How am I supposed to know "
			+ "where you should go? \nI've been in this spot my whole life! What, just 'cause you have "
			+ "three options for which way to go, you're freakin' out? \nListen, if you're really "
			+ "so bothered by not knowin' where to go, just head north and talk to Simon.", 
			"My name is Sirain, by the way.", "Sineus is the guy at the front of the forest. He's nice.",
			"Look, Simon is wiser than I am. I can't really help you that much. \nFor goodness sake, my "
			+ "only real function in the game is to tell you to go north!", "Alright buddy, move along. "
					+ "This is my last original line of dialogue anyway. \nI'll just repeat things "
					+ "from now on."};
	
	/**
	 * the number of times Sirain has been talked to after talking with Simon and before leaving the forest
	 */
	private int postSimonCounter;
	
	/**
	 * All the things Sirain can say after talking to Simon
	 */
	private String[] postSimon = {
		
	};
	
	/**
	 * Method for Sirain to talk to the player
	 * @return Sirain's words of wisdom
	 */
	public String talk() {
		return cycleTalk(preSimonCounter++, preSimon);
	}

}
