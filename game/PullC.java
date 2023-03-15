package game;

public class PullC implements Command{	
		
		public void call(String first, String second, Player player) {
		 player.pull(second);
		}
	


}
