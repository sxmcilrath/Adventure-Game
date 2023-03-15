/**
 * SimonSignon
 * 
 * Simon is the elder of the signfolk. He introduces you to the purpose of your quest
 */

package game;

import java.util.Set;

public class SimonSignon extends NPC {
	
	private Player player;
	
	/**
	 * Simon's three phrases he can say based on your progress
	 */
	private String[] preTree;
	private int preTreeCounter;
	
	private String[] postTree;
	private int postTreeCounter;
	
	public SimonSignon(Player player) {
		this.player = player;
		
		preTree = new String[] {"Hello there young fellow. You must be brave to enter the treacherous "
				+ "'Ye Olde Tutorial' forest, very brave indeed. Before you stands a tall "
				+ "tree. Go up and observe well, when you are done, tell me what you see.",
				"What? You haven't gone up the tree yet? That's ok, I forgive you. Go on up.",
				"I suppose you don't have to go up the tree, but I think it would help you."};

		postTree = new String[] {"What did you see? A dog? Of course! It is all "
				+ "so clear now. Go find that little pupper and give it a good pet. A belly rub is also "
				+ "recommended. Why? Believe me, it will all become clear to you in time. Go back to where "
				+ "you met Sirain and go east. You should be able to see where to go from there.",
				"You've met Sirain, right? He is the one who told you to come to me, just south from here."};
	}
	
	/**
	 * Method for Simon to talk to you. If you haven't gone up the tree,
	 * he'll tell you to do so and look around, if you've gone up but haven't
	 * looked around, he'll get mad and tell you to go back, if you do as he says,
	 * he'll encourage you and have you go on your way 
	 */
	public String talk() {
		boolean tree = player.wasCheckCrossed("viewingtree");
		if (tree) {
			int temp = postTreeCounter;
			postTreeCounter++;
			return postTree[temp%postTree.length];
		} else {
			int temp = preTreeCounter;
			preTreeCounter++;
			return preTree[temp%preTree.length];
		}
	}

}
