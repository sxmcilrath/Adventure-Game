/**
 * PetC
 * 
 * Command for a dog to be pet
 * 
 * @author Lincoln Going
 */

package game;

public class PetC implements Command{

	/**
	 * tells the player to call its pet method
	 * @param the first word the user inputs
	 * @param the second word the user inputs
	 * @param the player that interacts with the world
	 */
	public void call(String first, String second, Player player) {
		player.pet();
	}
	
}
