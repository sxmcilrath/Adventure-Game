package game;

public class Direction {

	//Two accessors for how to go back and forth between rooms
	//ex:"downstream" , "upstream"
	private String accessOne;
	private String accessTwo;
	//Two descriptors that we can print when the direction is used
	private String descriptOne;
	private String descriptTwo;
	
	
	public Direction(String accessOne, String accessTwo, String descriptOne, String descriptTwo) {
		this.accessOne = accessOne;
		this.accessTwo = accessTwo;
		this.descriptOne = descriptOne;
		this.descriptTwo = descriptTwo;
		
	}
	
}
