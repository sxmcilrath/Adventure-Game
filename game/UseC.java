package game;

public class UseC implements Command{

	public UseC () {
		
	}


	public void call(String first, String second, int words, Game game) {
		//add code here
		game.use();
	}
	
}
