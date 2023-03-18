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
 * @author Thomas VanDrunen, Camden Flannagan, Lincoln Going, and Sam McIlrath
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
		//allItems.put("sandmedallion", new SandMedallion());
		//allItems.put("icemedallion", new IceMedallion());
    	
    	//initializes the player
    	this.player = new Player(allItems);
    	//initializes rooms
    	//Ye Olde Tutorial Rooms
    	Room entrance = new Room("entrance",
    			"You are standing at the edge of a beautiful forest. \n"
        		+ " A sign is just in front of you; I wonder what it says...");
        		entrance.addNPC(new SineusSignon());
        
        Room swordRoom = new Room("swordroom","You see a rather wimpy-looking sword on the ground.\n"
        		+ " It doesn't seem very high quality,but you should still take it. \nUnless, of"
        		+ " course, you feel you can manage without it. Down the hill, is another sign guy.");
        swordRoom.addProperty("sword", new Sword());
        swordRoom.addProperty("metalchunk", new MetalChunk());

        
        Room swordTutorial = new Room("swordtutorial","There is a sign here. It seems eager to meet you..."
        		+ " or hurt you. I can't tell.\n"
        		+ "Either way, we shouldn't linger long. Past the sign is a clearing.");
        		swordTutorial.addNPC(new SimeusSignon(this.player));
        
        Room freeWillTutorial = new Room("freewill","You step into the clearing and, oh! another sign.\n"
        		+ "Hopefully this one is a bit less violent than the last one.\nMaybe he knows where you "
        		+ "should go next.");
        		freeWillTutorial.addNPC(new SirainSignon());
        
        Room questMadeClear = new Room("quest","A wise looking sign stands majestically"
        		+ "before you.\nEven in his old age, he has an air of vibrance and royalty."
        		+ " I wonder what he has to say.");
        questMadeClear.addNPC(new SimonSignon(player));
       

        Room viewingTree = new Room("viewingtree","In the distance you see where the forest ends and opens up into a sprawling meadow.\n"
        		+ "You see a dog resting in the sunlight at the edge of the forest. In the middle of the meadow lies a cabin.\n"
        		+ "You realize you could probably get there from the room Sirain was in.");
     
        
        Room nonEucTutorial = new Room("noneuc","Another sign is here."
        		+ " He looks to be the 'needs-to-get-out-more' kind of type");
        
        //Overworld Rooms

        Room outsideShelter = new Room("outsideshelter","You stand at the edge of the forest, and--Oh a dog! I guess you should pet it. "
        		+ "Not far ahead is a small, homey cabin... homey...homey. How is homey spelled? "
        		+ "It doesn't matter (well, it might matter), lets go in.");
        outsideShelter.addNPC(new Pet(0));
        Room shelter = new Room("shelter"," You open the cabin door and inside you find a signfolk sitting in a rocking chair with the fire going.\n"
        		+ "The small cabin strangely has three doors, the third differing from the others.\n"
        		+ "It seems to be locked. Looking back to the sign... Oh, it's Silvester! He and I go way back. Sometime I'll have to "
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
        		+ "person could lead you in the right direction.\nOh wait, I'm right here! There is a "
        		+ "puzzle just ahead. \nWhat? You think it's unprofessional for me to break the "
        		+ "fourth wall like this? Well maybe when you become a narrator you can do things "
        		+ "your way, but as of now, I can do whatever I like. \nIn fact, just to bother you, "
        		+ "I won't ever change what I say in this room. I'll just repeat the same thing "
        		+ "over and over again and you'll have to deal with it.\nTry to to figure it out because"
        		+ "this conversation.");
            beach.addProperty("bucket", new Bucket());
            beach.addProperty("bucket", new Bucket());
            beach.addProperty("shovel", new Shovel());
            beach.addProperty("candle", new Candle());
        //final castle rooms(still need throne room)
        Room outsideFinalCastle = new Room("castle", "You gaze up at the towering castle, in awe of its size.\n"
        		+ "You slowly walk across the drawbridge and after"
        		+ " reaching the other side, it lifts behind you.\nThere is no where to go but forward." );
        Room outsideFinalPuzzle = new Room("finalpuzzle", "As you enter, you are greeted with the sound of"
        		+ " gates slamming shut behind you.\nYou continue walking "
        		+ " forward and come upon a grand oak door. It seems to be an entrance to a throne room.");
        

        finalWhite = new Room("white", "Walking into the room, you take in the surroundings. \nA signfolk with royal garbs stands adjacent to a glowing door.\n"
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
        Room correctLeft = new Room("correctLeft","You decide to take the left path.\n"
        		+ "The fog surrounds you, but you keep pushing forward along the trail.\n"
        		+ "Before long the fog begins to lift and you realize you have arrived at an intersection similar to the first.\n"
        		+ "The path splits to the left, right, and forward.");
        Room correctRight = new Room("correctRight","After choosing to go right, you enter the fog once again, arriving at yet another intersection.\n"
        		+ "Your options remain the same: left, right, and forward.");
        Room correctMiddle = new Room("correctMiddle","Fed up with going left and right, you decide to forge on ahead.\n"
        		+ "To your surprise you made the right choice after arriving to a new intersection. The path splits once again.\n"
        		+ "You can feel it. You're close.");

        Room iceCastle = new Room("icecastle","At the end of your rope, you decide to go back from where you came.\n"
        		+ "But instead of the sign's song to greet you, a towering castle of ice lays before you. Overjoyed at this new realization, you rush through the gates.\n"
        		+ "Huskies of all shapes and sizes run around your feet, they're leading you somewhere. They soon bring you into the center of the castle.\n"
        		+ "You walk into a massive room made of ice and in the middle of the room is....");
        iceCastle.addNPC(new Pet(1));
        iceCastle.addProperty("icemedallion", new IceMedallion());


        
        //Beach puzzle room
        Room sandCastle = new Room("sandcastle","x");      
        sandCastle.addNPC(new Pet(2));
        sandCastle.addProperty("sandmedallion", new SandMedallion());
        
        
        Door temp = new LockedDoor(beach, sandCastle, new Key("tosandcastle"));
        linkRooms(temp, beach, sandCastle, "back", "sandcastle");
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
   	 	temp = new Door(entrance, swordRoom);
   	 	linkRooms(temp, entrance, swordRoom, Ent,Sr);
   	 
   	 	String[] Sr2 = {"sr", "swordroom", "hill", "back"};
   	 	String[] St = {"swordtutorialroom", "thefight", "str", "forward", "down"};  
   	 	temp = new Door(swordRoom,swordTutorial);
   	 	linkRooms(temp, swordRoom, swordTutorial, Sr2,St);
   	 
   	 	temp = new Door(swordTutorial, freeWillTutorial);
   	 	String[] St2 = {"swordtutorialroom", "thefight", "str", "back"};    
   	 	String[] Fw = {"freewilltutorial", "fwt","clearing", "forward"};      
   	 	linkRooms(temp, swordTutorial, freeWillTutorial, St2,Fw);
   	 
   	 	temp = new Door(freeWillTutorial, questMadeClear);
   	 	String[] Fw2 = {"freewilltutorial", "fwt", "back", "south"};
   	 	String[] Qmc = {"yourquestmadeclear", "yqmc", "questmadeclear", "qmc", "north", "simon"};      
   	 	linkRooms(temp, freeWillTutorial, questMadeClear, Fw2, Qmc);
   	 
   	 	temp = new Door(freeWillTutorial, nonEucTutorial);
   	 	String[] Qmc2 = {"yourquestmadeclear", "yqmc", "questmadeclear", "qmc", "down"}; 
   	 	String[] Net = {"noneuclidiantutorial", "net", "forward"};
   	 	linkRooms(temp, freeWillTutorial, Net);
   	 
   	 	temp = new Door( questMadeClear, viewingTree);
   	 	String[] Vt = {"viewingtree", "vt", "tree", "t", "forward", "up"};
   	 	linkRooms(temp, questMadeClear, viewingTree , Qmc2, Vt);
   	 
   	 	temp = new Door(nonEucTutorial, entrance);
   	 	String[] south = {"south"};
   	 	linkRooms(temp, nonEucTutorial, south);
   	 
   	 	temp = new Door(freeWillTutorial, outsideShelter);
   	 	String[] Os = {"onward", "outsideshelter", "os", "outside", "forward", "east"};
   	 	linkRooms(temp, freeWillTutorial, outsideShelter, Fw2, Os);
   	 	String[] Os2 = {"onward", "outsideshelter", "os", "outside", "back"};

   	 	//Linking Overworld
   	 	temp = new Door(outsideShelter, shelter);
   	 	String[] Sh = {"shelter","sh", "s", "forward", "cabin"};
   	 	String[] Sh2 = {"shelter","sh", "s", "back", "cabin"};
   	 	linkRooms(temp, outsideShelter, shelter,Os2, Sh);
     
   	 	temp = new Door(shelter, icyPath);
   	 	String[] Ip = {"icypath", "ip", "ice", "path"};
   	 	linkRooms(temp, shelter, icyPath, Sh2, Ip);
     
   	 	temp = new Door(shelter, beach);
   	 	String[] Be = {"beach", "b", "desert"};
   	 	linkRooms(temp, shelter, beach, Sh2, Be);
        
   	 	//linking icy path puzzle
   	 	temp = new Door(entrance, beach);
   	 	linkRooms(temp, entrance, "b");
     
   	 	temp = new Door(icyPath, correctLeft);
   	 	linkRooms(temp, icyPath, correctLeft, "back", "left");
     
   	 	temp = new Door(icyPath, icyPath);
   	 	String[] dir = {"middle", "right"};
   	 	linkRooms(temp, icyPath, dir);
        
   	 	String[] dir2 = {"left", "forward"};
   	 	temp = new Door(correctLeft, icyPath);
   	 	linkRooms(temp, correctLeft, dir2);
        
   	 	temp = new Door(correctLeft, correctRight);
   	 	linkRooms(temp, correctLeft, correctRight, "back", "right"); 

   	 	temp = new Door(correctRight, icyPath);
   	 	String[] dir3 = {"left", "right"};
   	 	linkRooms(temp, correctRight, dir3);
        
   	 	temp = new Door(correctRight, correctMiddle);
   	 	linkRooms(temp, correctRight, correctMiddle, "back", "forward");
        
   	 	temp = new Door(correctMiddle, icyPath);
   	 	String[] dir4 = {"left", "right", "forward"};
   	 	linkRooms(temp, correctMiddle, dir4);
     
   	 	temp = new Door(correctMiddle, iceCastle);
   	 	linkRooms(temp, correctMiddle, "back");
        
   	 	temp = new Door(iceCastle, shelter);
   	 	linkRooms(temp, iceCastle, "sleighride");
               
   	 	//linking final castle 
   	 	//NEED TO SET UP A CHECK TO MAKE SURE YOU HAVE PET THE TWO OTHER DOGS
   	 	temp = new LockedDoor(shelter, outsideFinalCastle, new Key("tocastle"));
   	 	linkRooms(temp, shelter, "bridge");
        
   	 	temp = new Door(outsideFinalCastle, outsideFinalPuzzle);
   	 	linkRooms(temp, outsideFinalCastle, "forward");
        
   	 	temp = new Door(outsideFinalPuzzle, finalWhite);
   	 	linkRooms(temp, outsideFinalPuzzle, "oakdoor");
              
   	 	temp = new Door(finalWhite, finalRed);
   	 	linkRooms(temp, finalWhite, "glowingdoor");
     
   	 	temp = new Door(finalRed, finalGreen);
   	 	linkRooms(temp, finalRed, "glowingdoor");
     
   	 	temp = new Door(finalGreen, finalBlue);
   	 	linkRooms(temp, finalGreen, "glowingdoor");
     
   	 	temp = new Door(finalBlue, finalWhite);
   	 	linkRooms(temp, finalBlue, "glowingdoor");
        
   	 	Key key = new Key("finalkey");
   	 	temp = new LockedDoor(finalWhite, throne, key);
   	 	linkRooms(temp, finalWhite, throne, "white", "throne");
        
   	 	//ArrayList<Room> finalPuzz = new ArrayList<>(Arrays.asList(finalWhite, finalRed, finalGreen, finalBlue));
   	 	//linkRooms(finalPuzz, "glowingdoor");
     
        
   	 	//need to figure out how to get b public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }
        
   	 	/**
   	 	 * initialize the player, player's location, and initial game output
   	 	 */
   	 	player.setCurrentRoom(entrance);
   	 	player.look();
     
    }
    
    /**
     * recursively calling link room functions
     * @param door The door connecting the two rooms
     * @param r1 The first room to link
     * @param r2 The second room to link
     * @param direct1 The directions the user can type to get to r1 from r2
     * @param direct2 The directions the user can type to get to r2 from r1
     */
    public void linkRooms(Door door, Room r1, Room r2, String[] direct1, String[] direct2) {    	
		linkRooms(door, r1, direct2);	    	
		linkRooms(door, r2, direct1);
    }
    
    /**
     * link rooms with strings rather than string arrays
     * @param door The door connecting the two rooms
     * @param r1 The first room to link
     * @param r2 The second room to link
     * @param direct1 The direction the user can type to get to r1 from r2
     * @param direct2 The direction the user can type to get to r2 from r1
     */
    public void linkRooms(Door door, Room r1, Room r2, String direct1, String direct2) {    	
		linkRooms(door, r1, direct2);	    	
		linkRooms(door, r2, direct1);
    }
    
    /**
     * link a room with a door
     * @param door The door to which the room shall be linked
     * @param r The room to connect with a door
     * @param direct The directions the user can type to go through the door
     */
    public void linkRooms(Door door, Room r, String direct[]) {
		for(int i = 0; i < direct.length; i++) {
			linkRooms(door, r, direct[i]);
    	}
    }
	
    /**
     * link a room with a door using strings rather than arrays of strings
     * @param door The door to which the room shall be linked
     * @param r The room to connect with a door
     * @param direct The directions the user can type to go through the door
     */
    public void linkRooms(Door door, Room r, String direct) {
    	r.addDoor(direct, door);
    }

    /**
     * mutually add two rooms to be accessed by the other
     * @param r1	first room
     * @param r2	second room
     * @param direct1	direction name to get to r2 from r1
     * @param direct2	direction name to get to r1 from r2
     */
	
	
    /**
	 *links the beach to the sandcastle when the puzzle has been solved 
	 */
	/**
	 * links the puzzle room to the final throne room when solved
	 */

	
	/**
	 * Overloading linkRooms method to make a case where a room leads to 
	 * another bu)t you can't go back
	 * @override
	 * @param r1	current room
	 * @param r2	destination room
	 * @param direct	direction name to get from r1 to r2
	 */
	
		
	
	
	/**
	 * link rooms for rotating door
	 * @param rooms		rooms that will be rotated through
	 * @param direct	direction name for the rooms
	 */
	/*
	 * public void linkRooms(ArrayList<Room> rooms, String direct) {
		Door door = new RotatingDoor(rooms);	//create rotating door
		
		//add door for each room in the arraylist
		for(int i = 0; i < rooms.size(); i++) {
			rooms.get(i).addDoor(direct, door);
		}
		
	} */
	
	/**
	 * returns the player of the game for the parser
	 */
	public Player getPlayer() {return this.player;}
}

   