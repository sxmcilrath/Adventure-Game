package game;

public class UseC implements Command{

	public UseC () {
		
	}


	public void call(String first, String second, Game game) {
		//add code here
		game.use(second);
	}
	
}
