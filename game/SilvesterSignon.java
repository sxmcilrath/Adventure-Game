/**
 * SilvesterSignon
 * 
 * Silvester lives in a cozy cabin not far from the edge of the forest.
 * He leads the player where he believes they should go. His dialogue is more
 * complex than any other character in the game
 * 
 * @author Camden Flannagan and Sam McIlreth
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
	 * the set of dialogue Silvester has when attacked before the ice castle
	 */
	private String[] attacked;
	
	/**
	 * how many times Silvester has been attacked before the ice castle
	 */
	private int attackedCounter;
	
	/**
	 * Silvester needs to know the current state of the game to interact with
	 * the player dynamically
	 * @param player
	 */
	public SilvesterSignon(Player player) {
		this.player = player;

		preIce = new String[] {"Hello there, its a beautiful door--I mean, day--today. How are you?\n"
				+ "What's that? A dog? Did Simon put you up to this? Well, nearby is a path "
				+ "towards the ice place (I can never remember what it's called).\n"
				+ "Also, how do you spell \"yoozh\", as in, \"I'll have the usual?\"\n"
				+ "I could never quite figure it out.",
				"Iceland? Is that what it's called? No, that's a country.\n"
				+ "Well, I suppose it doesn't matter, just head towards the huge mass of ice."};
		preIceCounter = 0;
		
		preSand = new String[] {"Oh, good! You're back in one piece! I did a bit of research, and I think"
				+ "it might be spelled \"ushe,\" but I also learned that some people "
				+ "spell it like \"usge.\" Anyway, I- wait, Narrator, is that you? "
				+ "It's been far too long my friend! What so you mean you were here earlier?"
				+ "Surely I would have noticed. Oh yes! The quest! Go to the desert, I believe"
				+ "it's called Doodle Desert. Silly name, very silly name.",
				"Interestingly, Doodle Desert is not a desert at all. It's a beach!\n"
				+ "Synucious, the discoverer of the beach, saw it from very far away.\n"
				+ "He mistook it for a desert, and not liking deserts very much, he never went there!\n"
				+ "For being a famous explorer, Synucious sure did a bad job at exploring."};
		preSandCounter = 0;
		
		preFinal = new String[] {"By Jove you've done it! The medallions! With those, you'll be able "
				+ "to reach the Final Castle! Nobody knows what wonderful things are in that castle."};
		preFinalCounter = 0;
		
		attacked = new String[] {"Please no! You'll break something! And if you break something, I'll... well, do nothing.\n"
				+ "But I'll be very upset!",
				"I'm serious, be careful! No, no! Not that, please no! Be careful with that!",
				"Oh greatly to be pitied am I! You've broken it, my favorite thing!",
				"*Silvester weeps*"};
		attackedCounter = 0;
	}
	
	/**
	 * The things Silvester says to the player. He guides the player through the main portion of the game
	 * @return his words of wisdom, depending on how far in the game you are
	 */
	public String talk() {

		// Pre Final Dialogue
		if (player.wasCheckCrossed("sandcastle")) {
			if (player.wasCheckCrossed("brokenThingPreSand")) {
				return "Well. Look who's back. Don't think I've forgotten what you've done.\n"
						+ "Maybe its immature, but I'm just not in a place to forgive you right now.\n"
						+ "You broke my favorite thing and hurt me very deeply. Just go to the Final Castle.\n"
						+ "You have all of the medallions you need. Please just leave.";
			}
			return cycleTalk(preFinalCounter++, preFinal);
		}
		
		// Pre Sand Dialogue
		if (player.wasCheckCrossed("icecastle")) {
			if (player.wasCheckCrossed("brokenThingPreIce")) {
				return "Well. Look who's back. Don't think I've forgotten what you've done.\n"
						+ "Maybe its immature, but I'm just not in a place to forgive you right now.\n"
						+ "You broke my favorite thing and hurt me very deeply. Just go to the beach.\n"
						+ "Please leave.";
			}
			if (player.wasCheckCrossed("brokenThingPreSand")) {
				return "Go away. I am very unhappy with you. You've broken my favorite thing.\n"
						+ "Oh, I don't know if I'll ever recover from this.\n"
						+ "*continues weeping*";
			}
			return cycleTalk(preSandCounter++, preSand);
		}
		
		// Pre Ice Dialogue
		if (player.wasCheckCrossed("brokenThingPreIce")) {
			return "Go away. I am very unhappy with you. You've broken my favorite thing.\n"
					+ "Oh, I don't know if I'll ever recover from this.\n"
					+ "*continues weeping*";
		}
		return cycleTalk(preIceCounter++, preIce);
	}

	/**
	 * What Silvester says when he is attacked
	 */
	public String attacked() {
		if (attackedCounter == 3) {
			if (player.wasCheckCrossed("icecastle")) {
				player.addCheckpoint("brokenThingPreSand");
			} else {
				player.addCheckpoint("brokenThingPreIce");
			}
		}
		if (attackedCounter >= 3) {
			return attacked[3];
		}
		return attacked[attackedCounter++];
	}
	
}
