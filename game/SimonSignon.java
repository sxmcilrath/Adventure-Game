/**
 * SimonSignon
 * 
 * Simon is the elder of the signfolk. He introduces you to the purpose of your quest
 */

package game;

import java.util.Set;

public class SimonSignon implements SignFolk {
	
	/**
	 * Simon's three phrases he can say based on your progress
	 */
	private String preTree;
	private String postTreeNoLook;
	private String postTreeGoodLook;
	
	public SimonSignon() {
		preTree = "Hello there young fellow. You must be brave to enter the treacherous "
				+ "'Ye Olde Tutorial' forest, very brave indeed. Before you stands a tall"
				+ "tree. Go up and observe well, when you are done, tell me what you see."
				+ "Or don't, if you don't feel like it.";
		postTreeNoLook = "What did you see? What!? You didn't even look around?"
				+ "Get back up there and let me properly tutorial you!";
		postTreeGoodLook = "What did you see? A dog? Of course! It is all"
				+ "so clear now. Go find that little pupper and give it a good pet. A belly rub is also"
				+ "recommended. Why? Believe me, it will all become clear to you in time.";
	}
	
	/**
	 * Method for Simon to talk to you. If you haven't gone up the tree,
	 * he'll tell you to do so and look around, if you've gone up but haven't
	 * looked around, he'll get mad and tell you to go back, if you do as he says,
	 * he'll encourage you and have you go on your way 
	 */
	public String talk(GameProgression progression) {
		Set<String> checkpoints = progression.getCheckpoints();
		boolean tree = checkpoints.contains("tree");
		boolean goodLook = checkpoints.contains("goodLook");
		if (tree) {
			if (goodLook) {
				return postTreeGoodLook;
			} else {
				return postTreeNoLook;
			}
		} else {
			return preTree;
		}
	}

}
