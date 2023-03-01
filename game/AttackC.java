package game;

public class AttackC implements Command{

	public AttackC () {
		
	}


	public void call(String first, String second, Game game) {
		game.attack();
	}
	
}
