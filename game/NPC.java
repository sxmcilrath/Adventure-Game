/**
 * An interface for the NPC's
 */

package game;

public abstract class NPC {
	
	/**
	 * A method for the signfolk to talk based on the current state
	 * of the game's progression
	 * @param progression How far the player is into the game
	 * @return the string for the signfolk to say
	 */
	public abstract String talk();
	
	/**
	 * Method for returning a string from an array of strings on a cycle
	 * @param counter How many times the NPC has been talked to so far in the current circumstance
	 * @param says All the dialogue for the NPC to cycle through 
	 * @return the thing for the NPC to say
	 */
	protected String cycleTalk(int counter, String[] says) {
		int temp = counter;
		counter++;
		return says[temp%says.length];
	}
	
	/**
	 * Method so that an npc can say something once and then cycle through
	 * other dialogue without repeating the greetings
	 * @param counter How many times the NPC has been talked to in the current circumstance
	 * @param says The repeating pieces of dialogue to cycle through
	 * @param greeting The greeting from the NPC that should not be repeated
	 * @return the thing for the NPC to say
	 */
	protected String cycleTalkWithGreeting(int counter, String[] says, String greeting) {
		if (counter == 0) {
			counter++;
			return greeting;
		}
		int temp = counter;
		counter++;
		return says[(temp-1)%says.length];
	}
	
	public String attacked() {
		return "The SignFolk moves out of your reach";
	}
	
}
