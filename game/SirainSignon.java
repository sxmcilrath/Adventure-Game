/**
 * SirainSignon
 * 
 * Sirain teaches the player all about free will (within heavy limits, of course)
 * 
 * @author Camden Flannagan
 */

package game;

public class SirainSignon extends NPC {

	/**
	 * allows Sirain to interact with the checkpoint system
	 */
	private Player player;
	
	/**
	 * the number of times Sirain has been talked to before talking to Simon
	 */
	private int preSimonCounter = 0;
	
	/**
	 * all the things that Sirain can say before you talk to Simon
	 */
	private String[] preSimon = {"What are you lookin' at me for? Pick a direction and go! How am I supposed to know "
			+ "where you should go? \nI've been in this spot my whole life! What, just 'cause you have "
			+ "three options for which way to go, you're freakin' out? \nListen, if you're really "
			+ "so bothered by not knowin' where to go, just head north and talk to Simon.", 
			"My name is Sirain, by the way.", "Sineus is the guy at the front of the forest. He's nice.",
			"Look, Simon is wiser than I am. I can't really help you that much. \nFor goodness sake, my "
			+ "only real function in the game is to tell you to go north!", "Alright buddy, move along. "
					+ "This is my last original line of dialogue anyway. \nI'll just repeat things "
					+ "from now on."};
	
	/**
	 * the number of times Sirain has been talked to after talking with Simon and before leaving the forest
	 */
	private int postSimonCounter = 0;
	
	/**
	 * All the things Sirain can say after talking to Simon
	 */
	private String[] postSimon = {"Oh, good, you talked to Simon. What a great guy.\n"
			+ "He's a strong leader of the Signon family. We all love him.",
			"Silvester is just east of here. He's not really a black sheep per-say,\n"
			+ "but he definitely doesn't associate with the rest of the family very much.",
			"You should go east and talk to Silvester. He gets out more than the rest of us,\n"
			+ "Wait! I have another function in the game! I get to tell you to go east!\n"
			+ "Oh yeah! That feels good."
	};
	
	/**
	 * how many times Sirain has been talked to after you see Silvester
	 */
	private int postSilvesterCounter = 0;
	
	/**
	 * what Sirain can say after you see Sirain and come back
	 */
	private String[] postSilvester = {
			"How was Silvester? Oh, I'm glad to hear he is doing well.",
			"Did he mention having any plans of visiting us?"};
			
	/**
	 * how many times you've talked to Sirain after breaking Silvester's favorite thing
	 */
	private int postBrokenThingCounter = 0;
			
	/**
	 * all the things Silvester can say after you break Silvester's favorite thing
	 */
	private String[] postBrokenThing = {
			"You broke Silvester's favorite thing! You idiot!"
	};
	
	/**
	 * constructor for Sirain
	 * @param player Allows Sirain to interact with the checkpoint system
	 */
	public SirainSignon(Player player) {
		this.player = player;
	}
	
	/**
	 * Method for Sirain to talk to the player
	 * @return Sirain's words of wisdom
	 */
	public String talk() {
		if (player.wasCheckCrossed("shelter")) {
			if (player.wasCheckCrossed("brokenThingPreIce")||player.wasCheckCrossed("brokenThingPreSand")) {
				return cycleTalk(postBrokenThingCounter++, postBrokenThing);
			}
			return cycleTalkWithGreeting(postSilvesterCounter++, postSilvester);
		}
		if (player.wasCheckCrossed("quest")) {
			return cycleTalkWithGreeting(postSimonCounter++, postSimon);
		}
		return cycleTalk(preSimonCounter++, preSimon);
	}

}
