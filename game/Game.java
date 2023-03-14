package game;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Game.java
 * 
 * Class to model the game as a collection of rooms. The
 * rooms are organized as a graph, and the Room objects
 * are nodes in the graph.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class Game {
	
	private  Player player;
	private  Crafter crafter;
    /**
     * The current room the user is in. This serves to
     * purposes-- it is our only permanent connection to
     * the rooms in this game (the other rooms are reachable
     * by traversing this room's "doors"-- and it maintains
     * the state by representing the user's current location.
     */
    //specific rooms that need to be accessed by methods
	
    private Room beach;	
    private Room sandCastle;
    
    //private Hand hand;
    private boolean icePuzzleCheck = true;
    
   
    
    
    
    /**
     * Constructor to set up the game.
     */
    public Game() {
    	
    	//initilizes the player
    	this.player = new Player();
    	//initializes rooms
    	//Ye Olde Tutorial Rooms
    	Room entrance = new Room("entrance","You are standing at the edge of a beautiful forest."
        		+ " A sign is just in front of you; I wonder what it says...",
        		new SineusSignon());
        entrance.addProperty("pretty");
        
        Room swordRoom = new Room("swordRoom","You see a rather wimpy-looking sword on the ground."
        		+ " It doesn't seem very high quality,but you should still take it. \nUnless, of"
        		+ " course, you feel you can manage without it. On the other side of the hill, is another sign guy.");
        swordRoom.addProperty("sword");
        
        Room swordTutorial = new Room("swordTutorial","There is a sign here. It seems eager to meet you..."
        		+ " or hurt you. I can't tell. Either way, we shouldn't linger long.",
        		new SimeusSignon(this.player));
        
        Room freeWillTutorial = new Room("freewill","Oh, another sign. Hopefully this"
        		+ " one is a bit less violent than the last one.",
        		new SirainSignon());
        
        Room questMadeClear = new Room("quest","A wise looking sign stands majestically"
        		+ " before you. Even in his old age, he has an air of vibrance and royalty."
        		+ " I wonder what he has to say.",
        		new SimonSignon(player));
        

        Room viewingTree = new Room("viewingTree","What's that in the distance?");
        viewingTree.addProperty("checkpoint");
        
        Room nonEucTutorial = new Room("nonEuc","Another sign is here."
        		+ " He looks to be the 'needs-to-get-out-more' kind of type");
        
        //Overworld Rooms

        Room outsideShelter = new Room("outsideShelter","You stand at the edge of the forest. "
        		+ "Not far ahead is a small, homey cabin... homey...homey. How is homey spelled? "
        		+ "It doesn't matter (well, it might matter), lets go in.");
        Room shelter = new Room("shelter","Oh, it's Silvester! He and I go way back. Sometime I'll have to "
        		+ "tell about the zany adventures we had as children.", 
        		new SilvesterSignon(player));
        Room icyPath = new Room("icyPath","You depart from the shelter and step foot into the icy woods. This is much different from the forest in which you started. \n"
        		+ "Icicles hang from the tree branches and a fog quickly envelops your surroundings. \n"
        		+ "\nIn the midst of creepiness, you hear a rather silly song being sung: "
        		+ "\"Icy path, oh Icy path, this path is oh so Icy! Pathy Icy "
        		+ "saucy sauce, move ahead and don't get lost!\" It's... REALLY annoying.", 
        		new SilasSignon());
        Room beach = new Room("beach","Look at all this sand. If only a very wise, very pleasant "
        		+ "person could lead you in the right direction. Oh wait, I'm right here! There is a "
        		+ "puzzle just ahead. What? You think it's unprofessional for me to break the "
        		+ "fourth wall like this? Well maybe when you become a narrator you can do things "
        		+ "your way, but as of now, I can do whatever I like. In fact, just to bother you, "
        		+ "I won't ever change what I say in this room. I'll just repeat the same thing "
        		+ "over and over again and you'll have to deal with it.");
       
        //final castle rooms(still need throne room)
        Room outsideFinalCastle = new Room("castle", "You gaze up at the towering castle, in awe of its size. You slowly walk across the drawbridge and after"
        		+ " reaching the other side, it lifts behind you. There is no where to go but forward." );
        Room outsideFinalPuzzle = new Room("finalpuzzle", "As you enter, you are greeted with the sound of gates slamming shut behind you. You continue walking "
        		+ " forward and come upon a grand oak door. It seems to be an entrance to a throne room.");
        
        Room finalWhite = new Room("white", "Walking into the room, you take in the surroundings. A signfolk with royal garbs stands adjacent to a glowing door."
        		+ " On the other side of the door is a white lever. ",
        		new SibylSignon(player));
        Room finalRed = new Room("red", "Walking into the room, you take in the surroundings. The room is empty except for a glowing door and on the wall next to it is a red lever."
        		+ " Looking back you realize the door in which you entered has disappeared.");
        Room finalGreen = new Room("green", "Walking into the room, you take in the surroundings. The room is empty except for a glowing door and on the wall next to it is a green lever."
        		+ " Looking back you realize the door in which you entered has disappeared.");
        Room finalBlue = new Room("blue", "Walking into the room, you take in the surroundings. The room is empty except for a glowing door and on the wall next to it is a blue lever."
        		+ " Looking back you realize the door in which you entered has disappeared.");


        
        //IcyPathPuzzles
        Room correctLeft = new Room("correctLeft","x");
        Room correctRight = new Room("correctRight","x");
        Room correctMiddle = new Room("correctMiddle","x");

        Room iceCastle = new Room("iceCastle","x", new Pet(1));
        iceCastle.addProperty("checkpoint");

        
        //Beach puzzle rooms

        Room sandCastle = new Room("sandCastle","x", new Pet(2));        

        //Map Hub Rooms
        
        //Creating map of game by linking rooms 
        
        //Linking Ye Olde Tutorial Forest
   	 String[] Ent = {"entrace", "forest", "tutorial"}; 
   	 String[] Sr = {"sr", "swordroom", "hill"};
   	 linkRooms(entrance, swordRoom, Ent,Sr);
   	 String[] St = {"swordtutorialroom", "thefight", "str"};      	
   	 linkRooms(swordRoom, swordTutorial, Sr,St);
   	 String[] Fw = {"freewilltutorial", "fwt"};      
   	 linkRooms(swordTutorial, freeWillTutorial, St,Fw);
   	 String[] Qmc = {"yourquestmadeclear", "yqmc", "questmadeclear", "qmc"};      
   	 linkRooms(freeWillTutorial, questMadeClear, Fw, Qmc);
   	 String[] Net = {"noneuclidiantutorial", "net"};
   	 linkRooms(freeWillTutorial, nonEucTutorial, Net);
   	String[] Vt = {"viewingtree", "vt", "tree", "t"};
   	 linkRooms(questMadeClear, viewingTree , Qmc, Vt);   
   	 String[] south = {"south"};
   	 linkRooms(nonEucTutorial, entrance, south);
   	String[] Os = {"onward", "outsideshelter", "os", "outside"};
   	 linkRooms(freeWillTutorial, outsideShelter, Fw, Os);


        //Linking Overworld
   	String[] Sh = {"shelter","sh", "s"};
        linkRooms(outsideShelter, shelter,Os, Sh);
        String[] Ip = {"icypath", "ip"};
        linkRooms(shelter, icyPath, Sh, Ip);
        String[] Be = {"beach", "b"};
        linkRooms(shelter, beach, Sh, Be);
        
        //linking icy path puzzle
        
        linkRooms(icyPath, correctLeft, "left", "back");
        linkRooms(correctLeft, icyPath, "left");
        linkRooms(correctLeft, icyPath, "middle");
        linkRooms(correctLeft, correctRight, "right", "back");
        linkRooms(correctRight, icyPath, "left");
        linkRooms(correctRight, icyPath, "right");
        linkRooms(correctRight, correctMiddle, "middle", "back");
        linkRooms(correctMiddle, icyPath, "left");
        linkRooms(correctMiddle, icyPath, "right");
        linkRooms(correctMiddle, icyPath, "middle");
        linkRooms(correctMiddle, iceCastle, "back");
        
        
        //linking final castle 
        //NEED TO SET UP A CHECK TO MAKE SURE YOU HAVE PET THE TWO OTHER DOGS
        linkRooms(shelter, outsideFinalCastle, "bridge");
        linkRooms(entrance, outsideFinalCastle, "cut");	//shortcut to end
        linkRooms(outsideFinalCastle, outsideFinalPuzzle, "forward");
        linkRooms(outsideFinalPuzzle, finalWhite, "oakdoor");
        ArrayList<Room> finalPuzz = new ArrayList<>(Arrays.asList(finalWhite, finalRed, finalGreen, finalBlue));
        linkRooms(finalPuzz, "glowingdoor");
        
        
        //need to figure out how to get b public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }
        
        /**
         * initialize the player, player's location, and initial game output
         */
        
        player.setCurrentRoom(entrance);
        player.look(null);
       
        
        
        //beach puzzle
        beach.addProperty("shovel");
        beach.addProperty("bucket");
        
        
        //Not sure if we need hand so I commented this out for now
       // hand = new Hand(player);
        //player.addItemToBackpack("hand", hand);

    }
    
    public void linkRooms(Room r1, Room r2, String direct1, String direct2) {    	
		linkRooms(r1, r2, direct2);	    	
		linkRooms(r2, r1, direct1);

}
    public void linkRooms(Room r1, Room r2, String direct) {
    	Door door = new TwoWayDoor(r1,r2);
			r1.addDoor(door, direct);
				
    	}

/**
 * mutually add two rooms to be accessed by the other
 * @param r1	first room
 * @param r2	second room
 * @param direct1	direction name to get to r2 from r1
 * @param direct2	direction name to get to r1 from r2
 */
	public void linkRooms(Room r1, Room r2, String[] direct1, String[] direct2) {    	
	    		linkRooms(r1, r2, direct2);	    	
	    		linkRooms(r2, r1, direct1);
	   
	}
	
	public void linkSandRooms() {
		linkRooms(beach, sandCastle, "sandcastle", "beach");
	}
	
	/**
	 * Overloading linkRooms method to make a case where a room leads to 
	 * another but you can't go back
	 * @override
	 * @param r1	current room
	 * @param r2	destination room
	 * @param direct	direction name to get from r1 to r2
	 */
	public void linkRooms(Room r1, Room r2, String direct[]) {
		Door door = new TwoWayDoor(r1, r2);
		for(int i = 0; i < direct.length; i++) {
			r1.addDoor(door, direct[i]);
    	}
		
	}
	
	public void linkRooms(ArrayList<Room> rooms, String direct) {
		Door door = new RotatingDoor(rooms);	//create rotating door
		
		//add door for each room in the arraylist
		for(int i = 0; i < rooms.size(); i++) {
			rooms.get(i).addDoor(door, direct);
		}
		
	}
	
	/**
	 * returns the player of the game for the parser
	 */
	public Player getPlayer() {return this.player;}
}

   