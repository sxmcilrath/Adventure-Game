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
		return says[counter%says.length];
	}
	
	/**
	 * Method so that an npc can say something once and then cycle through
	 * other dialogue without repeating the greetings
	 * @param counter How many times the NPC has been talked to in the current circumstance
	 * @param says The repeating pieces of dialogue to cycle through, but the first element
	 * will only be said once
	 * @return the thing for the NPC to say
	 */
	protected String cycleTalkWithGreeting(int counter, String[] says) {
		if (counter == 0) {
			counter++;
			return says[0];
		}
		int temp = counter;
		counter++;
		return says[((temp-1)%(says.length-1))+1]; // cycle through only the elements after the first element
	}
	
	public String attacked() {
		return "The SignFolk moves out of your reach";
	}
	
}
