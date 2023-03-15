package game;

public class DropC implements Command {
			
			public void call(String first, String second, Player player) {
			 player.drop(second);
			}
		

}
