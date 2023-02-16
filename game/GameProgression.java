/**
 * GameProgression
 * 
 * Used to keep track of how far the player is into the game,
 * using metrics such as backpack contents...
 */

package game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GameProgression {

	/**
	 * The player's backpack, so that the environment knows what
	 * the player has
	 */
	private HashMap<String, Item> backpack;
	
	/**
	 * A hashset to record which game checkpoints have been crossed
	 */
	private HashSet<String> checkpoints;
	
	/**
	 * constructor for game progression
	 * @param backpack
	 */
	public GameProgression(HashMap<String, Item> backpack) {
		this.backpack = backpack;
		checkpoints = new HashSet<String>();
	}
	
	/**
	 * returns the set of checkpoints crossed
	 * @return checkpoints set
	 */
	public Set<String> getCheckpoints() {
		return checkpoints;
	}
	
	/**
	 * stores which checkpoints have been crossed by the player
	 * @param checkpoint The ckeckpoint that has been crossed
	 */
	public void checkpointCrossed(String checkpoint) {
		checkpoints.add(checkpoint);
	}

	/**
	 * getter for the contents of the backpack
	 * @return the keyset of the backback
	 */
	public Set<String> getBackpack() {
		return backpack.keySet();
	}
}
