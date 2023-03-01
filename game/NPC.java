/**
 * An interface for the NPC's
 */

package game;

public abstract class NPC {
	
	/**
	 * A method for the signfolk to talk based on the current state
	 * of the game's progression
	 * @param progression How far the player is into the game
	 * @return the string for the signfolk to say
	 */
	public abstract String talk();
	
	public String attacked() {
		return "The SignFolk moves out of your reach";
	}
	
}
