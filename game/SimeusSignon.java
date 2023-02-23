/**
 * SimeusSignon
 * 
 * Simeus introduces combat to the game. The more excitable brother of Sineus
 */

package game;

public class SimeusSignon implements NPC {

	private String sword;
	private String noSword;
	private String swordAttacked;
	private String noSwordAttacked;
	
	public SimeusSignon() {
		sword = "Ah, yes! You have a sword! Why don't you give it go?";
		noSword = "You really think you can take me down without a sword? I mean, you don't "
				+ "have to fight me to move on, but it seems unwise to go forward if you aren't even "
				+ "able to stand up to me.";
		swordAttacked = "Alright, alright, cut it out! You've had enough tutorial with that death "
				+ "stick. Get a move on.";
		noSwordAttacked = "Ha. You fool. Have it you way, face my power";
	}
	
	@Override
	/**
	 * What does Simeus say when talked to?
	 * @param progression Do you or do you not have a sword
	 * @return what Simeus says
	 */
	public String talk(GameProgression progression) {
		if (progression.getBackpack().contains("sword")) {
			return sword;
		} else {
			return noSword;
		}
	}
	
	/**
	 * What should Simeus say when attacked?
	 * @param progression Do you or do you not have a sword
	 * @return his response
	 */
	public String attacked(GameProgression progression) {
		if (progression.getBackpack().contains("sword")) {
			return swordAttacked;
		} else {
			return noSwordAttacked;
		}
	}

}
