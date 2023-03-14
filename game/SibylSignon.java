package game;

public class SibylSignon extends NPC{
	
	private Player player;
	
	public SibylSignon(Player player) {
		this.player = player;
	}
	
	public String talk() {
		// TODO Auto-generated method stub
		if(player.wasCheckCrossed("red")) {
			return "You didn't really expect for it to be that easy did you?"
					+ " We have this whole castle and you think that you could just"
					+ " waltz right on through? Ya you're not getting through this door. "
					+ "I've got the secret code right here, it's even in riddle form! "
					+ "Go ahead and take it! It's so tricky you'll never be able to figure it out! ";
		}
		return "Here to pet the dog are you? Oh please by all means go right ahead!"
				+ "The dog is right through this door! Have fun!";
	}

}
