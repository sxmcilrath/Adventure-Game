/**
 * SimonSignon
 * 
 * Simon is the elder of the signfolk. He introduces you to the purpose of your quest
 * 
 * @author Camden Flannagan
 */

package game;

public class SimonSignon extends NPC {
	
	private Player player;
	
	/**
	 * dialogue before going up the tree
	 */
	private String[] preTree = {"Hello there young fellow. The name's Simon.\n"
			+ "You must be brave to enter the treacherous "
			+ "'Ye Olde Tutorial' forest, very brave indeed. Before you stands a tall tree.\n"
			+ "Go up and observe well, when you are done, tell me what you see.",
			"What? You haven't gone up the tree yet? That's ok, I forgive you. Go on up.\n",
			"I suppose you don't have to go up the tree, but I think it would help you."};
	
	/**
	 * how many times he has been talked to before going up the tree
	 */
	private int preTreeCounter = 0;
	
	/**
	 * what simon says after going up the tree
	 */
	private String[] postTree = {"What did you see? A dog? Of course! It is all "
			+ "so clear now. You are destined to pet the four Great Dogs of this land.\n"
			+ "Go find those little puppers and give them a good pet. \n"
			+ "You will recieve a Pet Medallion, a glorious object that will allow you to move forward in your journey.\n"
			+ "You will visit two castles and a cabin to find other dogs, and once you have three of them, you will embark on the final stretch of your adventure.\n"
			+ "To make it to the final castle you must obtain the sand and ice medallions.\n"
			+ "Go back to where you met Sirain and go east. You should be able to see where to go from there.",
			"You've met Sirain, right? He is the one who told you to come to me, just south from here."};
	
	/**
	 * how many times Simon has been talked to after going up the tree
	 */
	private int postTreeCounter = 0;
	
	/**
	 * how many times he has been talked to after breaking Silvester's favorite thing
	 */
	private int postBrokenThingCounter = 0; 
	
	/**
	 * what simon says after you've broken the favorite thing of Silvester
	 */
	private String[] postBrokenThing = {
			"We helped you. We were your friends. We, the Signon family, treated you like a good friend.\n"
			+ "How did you respond to this. By breaking Silvester's favorite thing. He must be crushed.\n"
			+ "You are no longer a friend of the Signon family.",
			"Go away. Pet those dogs. I hope you do so knowing that you have betrayed those who loved you.\n"
			+ "You have wronged my son, and so have wronged me and my whole family. This is not forgivable."
	};
	
	/**
	 * Constructor for Simon
	 * @param player The player with which he interacts
	 */
	public SimonSignon(Player player) {
		this.player = player;
	}
	
	/**
	 * Method for Simon to talk to you. If you haven't gone up the tree,
	 * he'll tell you to do so and look around, if you do as he says,
	 * he'll encourage you and have you go on your way 
	 */
	public String talk() {
		if (player.wasCheckCrossed("brokenThingPreIce")||player.wasCheckCrossed("brokenThingPreSand")) {
			return cycleTalk(postBrokenThingCounter++, postBrokenThing);
		}
		boolean tree = player.wasCheckCrossed("viewingtree");
		if (tree) {
			return cycleTalk(postTreeCounter++, postTree);
		} else {
			return cycleTalkWithGreeting(preTreeCounter++, preTree);
		}
	}
	
	/**
	 * Stuff for Simon to say when you attack him
	 * @return his reponse, depending on whether or not you have a sword
	 */
	public String attacked() {
		if (player.wasCheckCrossed("brokenThingPreIce")||player.wasCheckCrossed("brokenThingPreSand")) {
			return "LEAVE! You try to hurt me? After all you've done to break my heart? Leave and never come back.\n"
					+ "I hope your happy knowing all the pain you've caused this family. That was Silvester's favorite thing.\n"
					+ "Now it's gone, and you are to blame. Go away.";
		}
		if (player.hasItem("sword")) {
			return "Ouch! I am old and frail; don't play with your sword so recklessly!";
		} else {
			return "Are you trying to hurt me? Why?";
		}
	}

}
