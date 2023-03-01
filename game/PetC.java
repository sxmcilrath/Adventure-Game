package game;

public class PetC implements Command{

	public PetC () {
		
	}


	public void call(String first, String second, Game game) {
	game.pet();
		
	}
	
}
