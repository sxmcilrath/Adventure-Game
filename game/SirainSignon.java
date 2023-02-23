/**
 * SirainSignon
 * 
 * Sirain teaches the player all about free will (within heavy limits, of course)
 * He only has one line
 */

package game;

public class SirainSignon implements NPC {

	/**
	 * Sirain's words of wisdom to the player
	 */
	private String wordsOfWisdom;
	
	/**
	 * constructor for Sirain
	 */
	public SirainSignon() {
		wordsOfWisdom = "What are you lookin' at me for? Pick a direction and go! How am I supposed to know "
				+ "where you should go? I've been in this spot my whole life!";
	}
	
	/**
	 * Method for Sirain to talk to the player
	 * @param progression How far the player is into the game
	 * @return Sirain's words of wisdom
	 */
	public String talk() {
		return wordsOfWisdom;
	}

}
