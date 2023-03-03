package game;

public class AttackC implements Command{

	public AttackC () {
		
	}


	public void call(String first, String second, Player player) {
		player.attack();
	}
	
}
