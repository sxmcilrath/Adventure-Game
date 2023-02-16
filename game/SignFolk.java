/**
 * An interface for the signfolk
 */

package game;

public interface SignFolk {
	
	/**
	 * A method for the signfolk to talk based on the current state
	 * of the game's progression
	 * @param progression How far the player is into the game
	 * @return the string for the signfolk to say
	 */
	public String talk(GameProgression progression);
	
}
