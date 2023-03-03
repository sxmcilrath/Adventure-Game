package game;

public class TakeC implements Command{

	public TakeC () {
		
	}



	public void call(String first, String second, Player player) {
		player.take(second);
	}
	
}
