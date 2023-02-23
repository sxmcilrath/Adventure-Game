/**
 * SineusSignon
 * 
 * Sineus Signon, the first NPC you have the opportunity to meet.
 * He introduces the forest and his people
 */

package game;

public class SineusSignon implements NPC {

	/**
	 * what the Sineus has to say to the player
	 */
	private String wordsOfWisdom;
	
	/**
	 * constructor for Sineus
	 */
	public SineusSignon() {
		wordsOfWisdom = "Welcome to Ye Olde Tutorial Forest! We Signfolk are the inhabitants of this wonderful land.";
	}
	
	/**
	 * Sineus introduces the world to the player
	 */
	public String talk() {
		return wordsOfWisdom;
	}

}
