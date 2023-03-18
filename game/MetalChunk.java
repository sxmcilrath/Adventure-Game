package game;

public class MetalChunk extends Item {

	public MetalChunk () {
		super("metalchunk");
	}
	
	@Override
	public String ability(Room room) {
		
		return "This looks craftable...";
	}
	
	

}
