package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    private Room finalWhite;
    private Room throne;
    
    //private Hand hand;
    private boolean icePuzzleCheck = true;
    private Map<String,Item> allItems = new HashMap<String,Item>();
   
    
    
    
    /**
     * Constructor to set up the game.
     */
    public Game() {
    	
    	allItems.put("bucket", new Bucket());
		//allItems.put("bucketwithsand", new BucketWithSand());
		allItems.put("candle", new Candle());
		allItems.put("metalchunk", new MetalChunk());
		allItems.put("shovel", new Shovel());
		allItems.put("steak", new Steak());
		allItems.put("sword", new Sword());
		allItems.put("secretcode", new SecretCode());
    	
    	//initializes the player
    	this.player = new Player(allItems);
    	//initializes rooms
    	//Ye Olde Tutorial Rooms
    	Room entrance = new Room("entrance","You are standing at the edge of a beautiful forest."
        		+ " A sign is just in front of you; I wonder what it says...");
        		entrance.addNPC(new SineusSignon());
        //entrance.addProperty("pretty");
        
        Room swordRoom = new Room("swordroom","You see a rather wimpy-looking sword on the ground."
        		+ " It doesn't seem very high quality,but you should still take it. \nUnless, of"
        		+ " course, you feel you can manage without it. On the other side of the hill, is another sign guy.");
        swordRoom.addProperty("sword", new Sword());

        
        Room swordTutorial = new Room("swordtutorial","There is a sign here. It seems eager to meet you..."
        		+ " or hurt you. I can't tell. Either way, we shouldn't linger long.");
        		swordTutorial.addNPC(new SimeusSignon(this.player));
        
        Room freeWillTutorial = new Room("freewill","You step into the clearing and, oh! another sign. "
        		+ "Hopefully this one is a bit less violent than the last one. Maybe he knows where you"
        		+ "should go next.");
        		freeWillTutorial.addNPC(new SirainSignon());
        
        Room questMadeClear = new Room("quest","A wise looking sign stands majestically"
        		+ " before you. Even in his old age, he has an air of vibrance and royalty."
        		+ " I wonder what he has to say.");
        questMadeClear.addNPC(new SimonSignon(player));
       

        Room viewingTree = new Room("viewingtree","What's that in the distance?");
     
        
        Room nonEucTutorial = new Room("noneuc","Another sign is here."
        		+ " He looks to be the 'needs-to-get-out-more' kind of type");
        
        //Overworld Rooms

        Room outsideShelter = new Room("outsideshelter","You stand at the edge of the forest. "
        		+ "Not far ahead is a small, homey cabin... homey...homey. How is homey spelled? "
        		+ "It doesn't matter (well, it might matter), lets go in.");
        outsideShelter.addNPC(new Pet(0));
        Room shelter = new Room("shelter","Oh, it's Silvester! He and I go way back. Sometime I'll have to "
        		+ "tell about the zany adventures we had as children.");
        	shelter.addNPC(new SilvesterSignon(this.player));
        	
        Room icyPath = new Room("icypath","You depart from the shelter and step foot into the icy woods. This is much different from the forest in which you started. \n"
        		+ "Icicles hang from the tree branches and a fog quickly envelops your surroundings.\n"
        		+ "In the midst of creepiness, you hear a rather silly song being sung:\n"
        		+ "\"Icy path, oh Icy path, this path is oh so Icy!Pathy Icy saucy sauce, move ahead and don't get lost!\"\n"
        		+ "It's... REALLY annoying.\n"
        		+ "You continue walking, getting closer and closer to the sound.\n"
        		+ "Finally you arive at an intersection, where the paths split off into left, right, and forward.\n"
        		+ "In the middle of the crossroads stands a sign, signing his song without a care in the world.");
        icyPath.addNPC(new SilasSignon());
        beach = new Room("beach","Look at all this sand. If only a very wise, very pleasant "
        		+ "person could lead you in the right direction. Oh wait, I'm right here! There is a "
        		+ "puzzle just ahead. What? You think it's unprofessional for me to break the "
        		+ "fourth wall like this? Well maybe when you become a narrator you can do things "
        		+ "your way, but as of now, I can do whatever I like. In fact, just to bother you, "
        		+ "I won't ever change what I say in this room. I'll just repeat the same thing "
        		+ "over and over again and you'll have to deal with it. Try to to figure it out because"
        		+ "this conversation.");
            swordRoom.addProperty("bucket", new Bucket());
            swordRoom.addProperty("shovel", new Shovel());
        //final castle rooms(still need throne room)
        Room outsideFinalCastle = new Room("castle", "You gaze up at the towering castle, in awe of its size.\n"
        		+ "You slowly walk across the drawbridge and after"
        		+ " reaching the other side, it lifts behind you.\nThere is no where to go but forward." );
        Room outsideFinalPuzzle = new Room("finalpuzzle", "As you enter, you are greeted with the sound of"
        		+ " gates slamming shut behind you.\nYou continue walking "
        		+ " forward and come upon a grand oak door. It seems to be an entrance to a throne room.");
        

        finalWhite = new Room("white", "Walking into the room, you take in the surroundings. A signfolk with royal garbs stands adjacent to a glowing door.\n"
        		+ "On the other side of the door is a white lever. ");
        	       finalWhite.addNPC(new SibylSignon(player));
        	       finalWhite.addProperty("secretcode", new SecretCode());     
        Room finalRed = new Room("red", "You walk into the room to find a room almost identical to where you came.\n"
        		+ "Howver this time the room is empty except for a red lever and a glowing door.\n"
        		+ "Looking back, you see the door behind you has disappeared.");
        Room finalGreen = new Room("green", "Okay something is definitely going on.\n"
        		+ "You walk into another identical room to find a green lever and a glowing door."
        		+ "\nThe door behind you has once again disappeared.");
        Room finalBlue = new Room("blue", "Surprise surprise! You walk into the room to find a blue lever and a glowing door. "
        		+ "The door behind you has disappeared. Will this nightmare end?");

        //need to add a dog here and an actual description
        throne = new Room("throne", "filler");

        throne.addNPC(new Pet(3));


       
        //IcyPathPuzzles
        Room correctLeft = new Room("correctLeft","x");
        Room correctRight = new Room("correctRight","x");
        Room correctMiddle = new Room("correctMiddle","x");

        Room iceCastle = new Room("icecastle","x");
        iceCastle.addNPC(new Pet(1));
        //iceCastle.addProperty("checkpoint");

        
        //Beach puzzle room
        Room sandCastle = new Room("sandcastle","x");      
        sandCastle.addNPC(new Pet(2));
        
        //Lever puzzle
        Lever lever = new Lever(this);
        finalWhite.addLever(lever);
        finalRed.addLever(lever);
        finalGreen.addLever(lever);
        finalBlue.addLever(lever);
        //Map Hub Rooms
        
        //Creating map of game by linking rooms 
        
        //Linking Ye Olde Tutorial Forest
   	 String[] Ent = {"entrace", "forest", "tutorial", "back"}; 
   	 String[] Sr = {"sr", "swordroom", "hill", "forward"};
   	 linkRooms(entrance, swordRoom, Ent,Sr);
   	String[] Sr2 = {"sr", "swordroom", "hill", "back"};
   	 String[] St = {"swordtutorialroom", "thefight", "str", "forward"};      	
   	 linkRooms(swordRoom, swordTutorial, Sr2,St);
	 String[] St2 = {"swordtutorialroom", "thefight", "str", "back"};    
   	 String[] Fw = {"freewilltutorial", "fwt", "forward"};      
   	 linkRooms(swordTutorial, freeWillTutorial, St2,Fw);
   	 String[] Fw2 = {"freewilltutorial", "fwt", "back"};
   	 String[] Qmc = {"yourquestmadeclear", "yqmc", "questmadeclear", "qmc", "forward"};      
   	 linkRooms(freeWillTutorial, questMadeClear, Fw2, Qmc);
   	 String[] Qmc2 = {"yourquestmadeclear", "yqmc", "questmadeclear", "qmc", "back"}; 
   	 String[] Net = {"noneuclidiantutorial", "net", "forward"};
   	 linkRooms(freeWillTutorial, nonEucTutorial, Net);
   	 String[] Net2 = {"noneuclidiantutorial", "net", "back"};
   	 String[] Vt = {"viewingtree", "vt", "tree", "t", "forward"};
   	 linkRooms(questMadeClear, viewingTree , Qmc2, Vt);   
     String[] Vt2 = {"viewingtree", "vt", "tree", "t", "back"};
   	 String[] south = {"south"};
   	 linkRooms(nonEucTutorial, entrance, south);
   	 String[] Os = {"onward", "outsideshelter", "os", "outside", "forward"};
   	 linkRooms(freeWillTutorial, outsideShelter, Fw2, Os);
     String[] Os2 = {"onward", "outsideshelter", "os", "outside", "back"};


     //Linking Overworld
     String[] Sh = {"shelter","sh", "s", "forward"};
     String[] Sh2 = {"shelter","sh", "s", "back"};
     linkRooms(outsideShelter, shelter,Os2, Sh);
     String[] Ip = {"icypath", "ip"};
     linkRooms(shelter, icyPath, Sh2, Ip);
     String[] Be = {"beach", "b"};
     linkRooms(shelter, beach, Sh2, Be);
        
        //linking icy path puzzle
        linkRooms(entrance,icyPath,"icecut");
        linkRooms(entrance, beach,"beachcut");
        linkRooms(icyPath, correctLeft, "back", "left");
        linkRooms(correctLeft, icyPath, "left");
        linkRooms(correctLeft, icyPath, "middle");
        linkRooms(correctLeft, correctRight, "back", "right");
        linkRooms(correctRight, icyPath, "left");
        linkRooms(correctRight, icyPath, "right");
        linkRooms(correctRight, correctMiddle, "back", "middle");
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
        
        //COMMENTING OUT 
        //beach.addProperty("shovel");
        //beach.addProperty("bucket");
        
        
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
			r1.addDoor(direct, door);
				
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
	
	public void linkThroneRoom() {
		linkRooms(finalWhite, throne, "throne", "white");
	}
	
	
	/**
	 * Overloading linkRooms method to make a case where a room leads to 
	 * another bu)t you can't go back
	 * @override
	 * @param r1	current room
	 * @param r2	destination room
	 * @param direct	direction name to get from r1 to r2
	 */
	public void linkRooms(Room r1, Room r2, String direct[]) {
		Door door = new TwoWayDoor(r1, r2);
		for(int i = 0; i < direct.length; i++) {
			r1.addDoor( direct[i], door);
    	}
		
	}
	//test
	public void linkRooms(ArrayList<Room> rooms, String direct) {
		Door door = new RotatingDoor(rooms);	//create rotating door
		
		//add door for each room in the arraylist
		for(int i = 0; i < rooms.size(); i++) {
			rooms.get(i).addDoor(direct, door);
		}
		
	}
	
	/**
	 * returns the player of the game for the parser
	 */
	public Player getPlayer() {return this.player;}
}

   