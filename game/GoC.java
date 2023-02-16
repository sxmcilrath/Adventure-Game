package game;

public class GoC implements Command{

	public GoC () {
		
	}

	@Override
	public void call(String first, String second, int words, Game game) {
		game.switchRoom(second);
		
	}
	
}
