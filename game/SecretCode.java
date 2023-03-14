package game;

public class SecretCode extends Item {

	@Override
	
	protected String ability(Room room) {
		// TODO Auto-generated method stub
		return "Grass is green \n"
				+ "The sky is blue \n"
				+ "My favorite color is orange, but I guess red will do";
	}

}
