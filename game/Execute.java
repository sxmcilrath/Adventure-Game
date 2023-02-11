package game;
import java.util.Arrays;

public class Execute {
	private String[] Move = {"north","south","east","west"};
	private String[] Interact = {"drop", "take", "use", "throw"};
	private String[] Other = {"help", "leave", "go"};
	private String[] Senses = {"look", "listen"};
	private String first = "help";
	private Game game;
	private Room CR;
	private int words;
	
	public Execute (Game game, String first, int words) {
		this.game = game;
		this.first = first;
		this.words = words;
		Determine();
	}
	
    public void Determine () {
    	if (Arrays.binarySearch(Move, first) >= 0) {
    		DetermineMove();
    		
    	} else if (Arrays.binarySearch(Interact, first) >= 0) {
    		DetermineInteract();
    		
    	} else if (Arrays.binarySearch(Other, first) >= 0) {
    		DetermineOther();
    		
    	} else if (Arrays.binarySearch(Senses, first) >= 0) {
    		DetermineSenses();
    		
    	} else {
    		
    	}
    	
    	
    }
   
	private void DetermineOther() {
		
		
	}

	private void DetermineSenses() {
		// TODO Auto-generated method stub
		
	}

	private void DetermineInteract() {
		// TODO Auto-generated method stub
		
	}

	private void DetermineMove() {
		CR = game.getCurrentRoom();
		boolean temp = CR.checkDirection(this.first);
		if(temp == true) {
		 game.setCurrentRoom(CR.getRoom(this.first));
		 CR = game.getCurrentRoom();
		 game.print(CR.getDescription());
		}else
		game.print("There is nothing in that direction");
			
		};
		
	
    
}
