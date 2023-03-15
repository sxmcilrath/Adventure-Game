/**
 * SilvesterSignon
 * 
 * Silvester lives in a cozy cabin not far from the edge of the forest.
 * He leads the player where he believes they should go.
 */

package game;

public class SilvesterSignon extends NPC {

	/**
	 * The player with which Silvester interacts
	 */
	private Player player;
	
	/**
	 * the set of dialogue he has before the ice castle
	 */
	private String[] preIce;
	
	/**
	 * how many times he has been spoken with before the ice castle
	 */
	private int preIceCounter;
	
	/**
	 * the set of dialogue before visiting the sand castle
	 */
	private String[] preSand;
	
	/**
	 * how many times he has been spoken with before the sand castle
	 */
	private int preSandCounter;
	
	/**
	 * the set of dialogue before the final castle
	 */
	private String[] preFinal;
	
	/**
	 * how many times he has been spoken with before the final castle
	 */
	private int preFinalCounter;
	
	/**
	 * Silvester needs to know the current state of the game to interact with
	 * the player dynamically
	 * @param player
	 */
	public SilvesterSignon(Player player) {
		this.player = player;
		preSand = new String[] {"Hello there, its a beautiful door--I mean, day--today. How are you? "
				+ "What's that? A dog? Did Simon put you up to this? Well, nearby is a path "
				+ "towards the ice place (I can never remember what it's called). "
				+ "Also, how do you spell \"yoozh\", as in, \"I'll have the usual?\" I could "
				+ "never quite figure it out.",
				"Iceland? Is that what it's called? No, that's a country. Well, I suppose it doesn't "
				+ "matter, just head towards the huge mass of ice."};
		preIceCounter = 0;
		
		preSand = new String[] {"Oh, good! You're back in one piece! I did a bit of research, and I think"
				+ "it might be spelled \"ushe,\" but I also learned that some people "
				+ "spell it like \"usge.\" Anyway, I- wait, Narrator, is that you? "
				+ "It's been far too long my friend! What so you mean you were here earlier?"
				+ "Surely I would have noticed. Oh yes! The quest! Go to the desert, I believe"
				+ "it's called Doodle Desert. Silly name, very silly name."};
		preSandCounter = 0;
		
		preFinal = new String[] {"By Jove you've done it! The medallions! With those, you'll be able "
				+ "to reach the Final Castle! Nobody knows what wonderful things are in that castle."};
		preFinalCounter = 0;
	}
	
	public String talk() {

		if (player.wasCheckCrossed("sandCastle")) {
			return cycleTalk(preFinalCounter, preFinal);

		}
		if (player.wasCheckCrossed("iceCastle")) {
			return cycleTalk(preSandCounter, preSand);
		}
		return cycleTalk(preIceCounter, preIce);
	}

}
