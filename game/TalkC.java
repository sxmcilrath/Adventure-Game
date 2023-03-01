package game;

public class TalkC implements Command{

	public TalkC () {
		
	}


	public void call(String first, String second, Game game) {
		//add code here
		game.talk();
	}
	
}
