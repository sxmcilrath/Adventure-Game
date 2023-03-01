package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


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
	
    /**
     * The current room the user is in. This serves to
     * purposes-- it is our only permanent connection to
     * the rooms in this game (the other rooms are reachable
     * by traversing this room's "doors"-- and it maintains
     * the state by representing the user's current location.
     */
    private Room currentRoom;

    private HashSet<String> directNames = new HashSet<String>();	//Array list to store names of directions. This array will be sent over to parser class 
    private HashMap<String, Item> backpack = new HashMap<String, Item>();
    private HashSet<String> PetMedallion = new HashSet<String>;


    private HashSet<String> checkpoints = new HashSet<String>();

    private Hand hand;
    private boolean icePuzzleCheck = true;
    
    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over;
    
    /**
     * instance of game progression to keep track of your progression in the game
     */
    private GameProgression progression;
    
    /**
     * Return the room in which the user is currently.
     */
    public Room getCurrentRoom() { return currentRoom; }
    
    public HashSet<String> getDirectNames(){
    	return directNames;
    }
    
    /**
     * Constructor to set up the game.
     */
    public Game() {
    	//initializes rooms
    	
    	//Ye Olde Tutorial Rooms
        Room entrance = new Room("You are standing at the edge of a beautiful forest. A sign is just in front of you; I wonder what it says...",
        		new SineusSignon());
        entrance.addProperty("pretty");
        
        this.currentRoom = entrance;
        Room swordRoom = new Room("You see a rather wimpy-looking sword on the ground. It doesn't seem very high quality,but you should still take it. Unless, of course, you feel you can manage without it.");
        swordRoom.addProperty("sword");
        
        Room swordTutorial = new Room("There is a sign here. It seems eager to meet you... or hurt you. I can't tell.",
        		new SimeusSignon(this));
        
        Room freeWillTutorial = new Room("Oh, another sign. Hopefully this one is a bit less violent than the last one.",
        		new SirainSignon());
        
        Room questMadeClear = new Room("A wise looking sign stands majestically before you. Even in his old age, he has an air of vibrance and royalty. I wonder what he has to say.",
        		new SimonSignon(this));
        
        Room viewingTree = new Room("placeholder text");
        
        Room nonEucTutorial = new Room("Another sign is here. He looks to be the 'needs-to-get-out-more' kind of type");
        
        //Overworld Rooms
        Room outsideShelter = new Room("x");
        Room shelter = new Room("x");
        Room icyPath = new Room("x", new SilasSignon());
        Room beach = new Room("x");
        
        //IcyPathPuzzles
        Room correctLeft = new Room("x");
        Room correctRight = new Room("x");
        Room correctMiddle = new Room("x");
        Room iceCastle = new Room("x");
        
        //Beach puzzle rooms
        Room sandCastle = new Room("x");        
        //Map Hub Rooms
        
        //Creating map of game by linking rooms 
        
        //Linking Ye Olde Tutorial Forest
        linkRooms(entrance, swordRoom, "swordroom", "entrance");

        linkRooms(swordRoom, swordTutorial, "swordtutorialroom", "swordroom");
        linkRooms(swordTutorial, freeWillTutorial, "freewilltutorial", "swordtutorial");
        linkRooms(freeWillTutorial, questMadeClear, "yourquestmadeclear", "freewilltutorial");
        linkRooms(freeWillTutorial, nonEucTutorial, "noneuclidiantutorial");
        linkRooms(questMadeClear, viewingTree , "viewingtree", "yourquestmadeclear");
        linkRooms(nonEucTutorial, entrance, "south");


        //Linking Overworld
        linkRooms(outsideShelter, shelter,"shelter", "outside");
        linkRooms(shelter, icyPath, "icypath", "shelter");
        linkRooms(shelter, beach, "beach", "shelter");
        
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
        //need to figure out how to get back
        
        //beach puzzle
        beach.addProperty("shovel");
        beach.addProperty("bucket");
        
        over = false;
        
        hand = new Hand(this);
        addItemToBackpack("hand", hand);

        
        progression = new GameProgression(backpack);
    }
    
    /**
     * This method takes an item name, a room, and tries to use the
     * item, and will fail to do so if the item is not in the backpack.
     * @param item The item you are trying to use
     * @param room The room you are trying to use the item in
     * @return a string containing a descri this.Calls.get(temp).call(this.first, this.second, this.words);ption of what happened
     */
    public String useItem(String item, Room room) {
    	   
    	if (backpack.containsKey(item)) {
    		return backpack.get(item).ability(room);
    	}
    	return "Huh?";
    }
    
    /**
     * check if the backpack contains a specific item
     * @param item The name of the item you're checking for
     * @return a boolean telling if the item is in the backpack
     */
    public boolean hasItem(String item) {
    	return backpack.containsKey(item);
    }
    
    /**
     * puts an item into the backpack so that the player can use it
     * @param itemName The name of the item that you are adding
     * @param item The item that you are adding
     * @return A string used to say that the item was picked up
     */
    public String addItemToBackpack(String itemName, Item item) {
    	backpack.put(itemName, item);
    	return "The " + itemName + " was added to your backpack!";
    }
    
    /**
     * returns a string showing the contents of the backpack
     * @return the string representing the contents of the backpack
     */
    public Strin	g checkBackpack() {
    	String contents = "";
    	for (String item : backpack.keySet()) {
    		contents += item + " ";
    	}
    	return contents;
    }
    
    /**
     * add a checkpoint to the crossed checkpoints
     * @param check The checkpoint to cross
     */
    public void crossCheckpoint(String check) {
    	checkpoints.add(check);
    }
    
    /**
     * checks whether or not a check has been crossed
     * @param check The check to check for
     * @return whether or not the check check checks out
     */
    public boolean wasCheckCrossed(String check) {
    	return checkpoints.contains(check);
    }
    
    /**
     * Is this game over or not?
     */
    public boolean isOver() { return over; }

    /**
     * Move into a different current room.
     */
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    //swtiches rooms
    public void switchRoom(String first) {
    	
    	Room CR = getCurrentRoom();
    	//Checks if directon is a key in the directions hashmap
		if(CR.checkDirection(first)) {	
			setCurrentRoom(CR.getRoom(first));
		 	CR = getCurrentRoom();
		 	print(CR.getDescription());
		}else {
			print("There is nothing in that direction");
		}		
    }
   
   
    

	/**
     * Indicate that the game is now over.
     */
    
    /**
     * mutually add two rooms to be accessed by the other
     * @param r1	first room
     * @param r2	second room
     * @param direct1	direction name to get to r2 from r1
     * @param direct2	direction name to get to r1 from r2
     */
    public void linkRooms(Room r1, Room r2, String direct1, String direct2) {
    	r1.addDirection(direct1, r2);
    	r2.addDirection(direct2, r1);
    	directNames.add(direct1);
    	directNames.add(direct2);

    	
    }
    
    /**
     * Overloading linkRooms method to make a case where a room leads to 
     * another but you can't go back
     * @override
     * @param r1	current room
     * @param r2	destination room
     * @param direct	direction name to get from r1 to r2
     */
    public void linkRooms(Room r1, Room r2, String direct) {
    	r1.addDirection(direct, r2);
    	directNames.add(direct);
    }
    
    
    
    public void finishGame() { over = true; }
    
    

    public void print(String output) {
    	System.out.println(output);
    }

	public void pet() {
		
	}

	public void attack() {
		Room room = getCurrentRoom();
		NPC npc = room.getNPC();
		if(npc != null){
		print(npc.attacked());
		} else { print("you strike the air"); };
		
	}

	public void take(String property) {
		hand.ability(getCurrentRoom(), property);
		
	}

	public void talk() {
		Room room = getCurrentRoom();
		NPC npc = room.getNPC();
		if(npc != null){
		print(npc.talk());
		} else { print("you strike the air"); };	
	}

	public void use(String second) {
		// TODO Auto-generated method stub
		
	}


}

   