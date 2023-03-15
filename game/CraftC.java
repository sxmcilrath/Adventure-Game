package game;

public class CraftC implements Command {

	@Override
	public void call(String first, String second, Player player) {
		if(second == "") {
			
		}
		player.craft(second);
	}

}
