package game;

public class UseC implements Command{

	public UseC () {
		
	}


	public void call(String first, String second, Player player) {
		player.use(second);
	}
	
}
