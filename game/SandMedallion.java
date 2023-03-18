package game;



/**
 * medallion obtained in the beach castle. When combined with the ice medallion
 * it creates the final key
 */
public class SandMedallion extends Item {

	
	protected SandMedallion() {
		super("sandmedallion");
	}

	protected String ability(Room room) {
		return "A treasure given to you by the dog of the great sandcastle";
	}

}
