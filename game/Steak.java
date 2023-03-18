package game;




public class Steak extends Item {

	public Steak() {
		super("steak");
	}
	@Override
	public String ability(Room room) {
		
		return "You feel nourished.";
	}
	

	

}
