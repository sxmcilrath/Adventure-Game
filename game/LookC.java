package game;

public class LookC implements Command{

	public LookC() {
		
	}

	@Override
	public void call(String first, String second, Game game) {
		game.look(second);
		
	}
	
}
