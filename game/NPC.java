/**
 * An interface for the NPC
 */

package game;

public interface NPC {
	
	/**
	 * A method for the signfolk to talk based on the current state
	 * of the game's progression
	 * @param progression How far the player is into the game
	 * @return the string for the signfolk to say
	 */
	public String talk(GameProgression progression);
	
}
