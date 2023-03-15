/**
 * SilvesterSignon
 * 
 * Silvester lives in a cozy cabin not far from the edge of the forest.
 * He leads the player where he believes they should go.
 */

package game;

public class SilvesterSignon extends NPC {

	/**
	 * The game with which Silvester interacts
	 */
	private Player player;
	
	/**
	 * Silvester needs to know the current state of the game to interact with
	 * the player dynamically
	 * @param player
	 */
	public SilvesterSignon(Player player) {
		this.player = player;
	}
	
	public String talk() {
		player.crossCheckpoint("fourthwallbreak");
		if (player.wasCheckCrossed("iceCastle")) {
			return "Oh, good! You're back in one piece! I did a bit of research, and I think"
					+ "it might be spelled \"ushe,\" but I also learned that some people "
					+ "spell it like \"usge.\" Anyway, I- wait, Narrator, is that you? "
					+ "It's been far too long my friend! What so you mean you were here earlier?"
					+ "Surely I would have noticed. Oh yes! The quest! Go to the desert, I believe"
					+ "it's called Doodle Desert. Silly name, very silly name. After all it's really just a beach.\n"
					+ "Alliteration really is a funny thing isn't it!";
		}
		return "Hello there, its a beautiful door--I mean, day--today. How are you? "
				+ "What's that? A dog? Did Simon put you up to this? Well, nearby is a path "
				+ "towards the ice place (I can never remember what it's called). "
				+ "Also, how do you spell \"yoozh\", as in, \"I'll have the usual?\" I could "
				+ "never quite figure it out.";
	}

}
