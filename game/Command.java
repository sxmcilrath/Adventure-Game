/**
 * Command
 * 
 * Interface for commands, the things the user can do to interact with the world
 * 
 * @author Lincoln Going
 */

package game;

public interface Command {

	/**
	 * takes the user's input to determine what should happen in the game
	 * @param first The first word of the user's input
	 * @param second The second word of the user's input
	 * @param player The player object to call the method for
	 */
	public void call(String first, String second, Player player);
}
