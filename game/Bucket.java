package game;


public class Bucket extends Item {

	
	public Bucket() {
		super("bucket");
			
	}
	
	
	public String ability(Room room) {
		// TODO Auto-generated method stub
		if(room.getName().equals("beach")) {
			return "Huh, nothing's inside. Cool bucket though!";
		}
		return "You can't use that here!";
	}

	
	

}
