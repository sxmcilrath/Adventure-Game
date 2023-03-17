/**
 * SineusSignon
 * 
 * Sineus Signon, the first NPC you have the opportunity to meet.
 * He introduces the forest and his people
 */

package game;

public class SineusSignon extends NPC {
	
	/**
	 * the number of times Sineus has been spoken to
	 */
	private int numTalk;
	
	/**
	 * all the dialogue that Sineus can say
	 */
	private String[] says;
	
	/**
	 * constructor for Sineus
	 */
	public SineusSignon() {
		numTalk = 0;
		says = new String[] {"Welcome to Ye Olde Tutorial Forest! \nMy name is Sineus and we Signfolk are the inhabitants of this wonderful land.", 
				 "There's a sword room over the hill. You should go get it", 
				 "what are you stalling for? The adventure awaits!"};
	}
	
	/**
	 * Sineus introduces the player to the world
	 */
	public String talk() {
		return cycleTalk(numTalk++, says);
	}

}
