/**
 * Pet
 * 
 * A special NPC representing a dog
 */

package game;

public class Pet extends NPC{
	

	
	/**
	 * the number assigned to the dog
	 */
	private int number;
	
	/**
	 * constructor for pet
	 * @param number The number assigned to the dog
	 */
	public Pet(int number) {
		this.number = number;
	}
	
	/**
	 * sets petted to true and informs the player that the dog licks you
	 */
	public String talk() {
		return "The dog licks you";
	}
	
	/**
	 * getter for the dog's number
	 * @return the dog's number
	 */
	public int getNum() {
		return this.number;
	}
	
	/**
	 * the dog barks at you when you attack it
	 */
	public String attacked() {
		return "Bark! Bark!";
	}
}
