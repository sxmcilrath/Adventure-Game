package game;

public class TalkC implements Command{

	public TalkC () {
		
	}


	public void call(String first, String second, Player player) {
		//add code here
		player.talk();
	}
	
}
