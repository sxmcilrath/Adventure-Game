package game;

public class TakeC implements Command{

	public TakeC () {
		
	}



	public void call(String first, String second, Game game) {
		game.take(second);
		System.out.println(game.checkBackpack());
	}
	
}
