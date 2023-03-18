/**
 * SimeusSignon
 * 
 * Simeus introduces combat to the game. The more excitable brother of Sineus
 * 
 * @author Camden Flannagan
 */

package game;

public class SimeusSignon extends NPC {

	private Player player;
	
	private String sword;
	private String noSword;
	private String swordAttacked;
	private String noSwordAttacked;
	
	public SimeusSignon(Player player) {
		this.player = player;
		
		sword = "Ah, yes! You have a sword! Why don't you try attacking me?";
		noSword = "You really think you can take me down without a sword? I mean, you don't have to fight me to move on,\n"
				+ "but it seems unwise to go forward if you aren't even able to stand up to me.";
		swordAttacked = "Alright, alright, cut it out! You've had enough tutorial with that death stick.\n"
				+ "Get a move on.";
		noSwordAttacked = "Ha. You fool. Have it you way, face my power!\n\n"
				+ "*Simeus attacks you, but you dodge him easily. He is a sign, after all.*";
	}
	
	/**
	 * What does Simeus say when talked to?
	 * @param progression Do you or do you not have a sword
	 * @return what Simeus says
	 */
	public String talk() {
		if (player.wasCheckCrossed("brokenThingPreIce")||player.wasCheckCrossed("brokenThingPreSand")) {
			return "I should have taken care of you when you first came into the forest.\n"
					+ "Get out of here you jerk.";
		}
		if (this.player.hasItem("sword")) {
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
	public String attacked() {
		if (player.hasItem("sword")) {
			return swordAttacked;
		} else {
			return noSwordAttacked;
		}
	}

}
