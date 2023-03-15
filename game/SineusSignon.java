/**
 * SineusSignon
 * 
 * Sineus Signon, the first NPC you have the opportunity to meet.
 * He introduces the forest and his people
 */

package game;

public class SineusSignon extends NPC {
	 private int numTalk = 0;
	 private String[] says = {"Welcome to Ye Olde Tutorial Forest! My name is Sineus We Signfolk are the inhabitants of this wonderful land.", 
			 "There's a sword room over the hill. You should go to the sword room", 
			 "what are you waiting for? The adventure awaits!"};
	/**
	 * what the Sineus has to say to the player
	 */
	private String wordsOfWisdom;
	
	/**
	 * constructor for Sineus
	 */
	public SineusSignon() {
		wordsOfWisdom = "Welcome to Ye Olde Tutorial Forest! We Signfolk are the inhabitants of"
				+ " this wonderful land.";
	}
	
	/**
	 * Sineus introduces the world to the player
	 */
	public String talk() {
		int temp = this.numTalk;
		if(this.numTalk < says.length - 1) {
		this.numTalk++;
		} else {this.numTalk = 0;}
		return says[temp];
	}

}
