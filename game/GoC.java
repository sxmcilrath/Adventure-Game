/**
 * GoC
 * 
 * Command for the player to move from the current room to the next room
 * 
 * @author Lincoln Going
 */

package game;

public class GoC implements Command{
	
	@Override
	/**
	 * Calls switchRoom in player, using the second word to determine the direction
	 * @param first The first word of the user's input
	 * @param second The second word of the user's input, the direction for the character to go in
	 * @param player The player for the going to be done to
	 */
	public void call(String first, String second, Player player) {
		player.switchRoom(second);
	}
	
}
