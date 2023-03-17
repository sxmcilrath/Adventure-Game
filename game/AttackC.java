/**
 * AttackC
 * 
 * Command for npc's to be attacked by the player
 * 
 * @author Lincoln Going
 */

package game;

public class AttackC implements Command{

	/**
	 * have the player call its attack method
	 */
	public void call(String first, String second, Player player) {
		player.attack();
	}
	
}
