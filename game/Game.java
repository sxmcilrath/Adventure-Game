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
    private HashSet<String> PetMedallion = new HashSet<String>();

    //specific rooms that need to be accessed by methods
    private Room beach;	
    private Room sandCastle;
    

    public void wonGame() {
    	this.over = true;
    	print("PetMedals" + PetMedallion.size());
    	for(int i = 1; i < 7; i++) {
    		String pet = "pet" + i;
    		if(!(PetMedallion.contains(pet))){
    			this.over = false;
    		}
    	}
    	
    }


    private HashSet<String> checkpoints = new HashSet<String>();

    private Hand hand;
    private boolean icePuzzleCheck = true;
    
    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over;
    
    
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
        Room entrance = new Room("entrance","You are standing at the edge of a beautiful forest."
        		+ " A sign is just in front of you; I wonder what it says...",
        		new SineusSignon());
        entrance.addProperty("pretty");
        
        this.currentRoom = entrance;
        Room swordRoom = new Room("swordRoom","You see a rather wimpy-looking sword on the ground."
        		+ " It doesn't seem very high quality,but you should still take it. Unless, of"
        		+ " course, you feel you can manage without it. Up ahead is another sign guy.");
        swordRoom.addProperty("sword");
        
        Room swordTutorial = new Room("swordTutorial","There is a sign here. It seems eager to meet you..."
        		+ " or hurt you. I can't tell. Either way, we shouldn't linger long.",
        		new SimeusSignon(this));
        
        Room freeWillTutorial = new Room("freewill","Oh, another sign. Hopefully this"
        		+ " one is a bit less violent than the last one.",
        		new SirainSignon());
        
        Room questMadeClear = new Room("quest","A wise looking sign stands majestically"
        		+ " before you. Even in his old age, he has an air of vibrance and royalty."
        		+ " I wonder what he has to say.",
        		new SimonSignon(this));
        

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
        		new SilvesterSignon(this));
        Room icyPath = new Room("icyPath","x", 
        		new SilasSignon());
        Room beach = new Room("beach","x");


        
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
        linkRooms(entrance, swordRoom, "swordroom", "entrance");
        linkRooms(swordRoom, swordTutorial, "swordtutorialroom", "swordroom");
        linkRooms(swordTutorial, freeWillTutorial, "freewilltutorial", "swordtutorial");
        linkRooms(freeWillTutorial, questMadeClear, "yourquestmadeclear", "freewilltutorial");
        linkRooms(freeWillTutorial, nonEucTutorial, "noneuclidiantutorial");
        linkRooms(questMadeClear, viewingTree , "viewingtree", "yourquestmadeclear");
        linkRooms(nonEucTutorial, entrance, "south");

//hi world
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

    }
    
    /**
     * This method takes an item name, a room, and tries to use the
     * item, and will fail to do so if the item is not in the backpack.
     * @param item The item you are trying to use
     * @param room The room you are trying to use the item in
     * @return a string containing a descri this.Calls.get(temp).call(this.first, this.second, this.words);ption of what happened
     */// TODO Auto-generated method stub
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
    
    public void removeItemFromBackapack(String name) {
    	backpack.remove(name);
    }
    
    /**
     * returns a string showing the contents of the backpack
     * @return the string representing the contents of the backpack
     */
    public String checkBackpack() {
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
    	if(first != "") {
    	//Checks if directon is a key in the directions hashmap
		if(CR.checkDirection(first)) {	
			setCurrentRoom(CR.getRoom(first));
		 	CR = getCurrentRoom();
		 	if (CR.getProperties().contains("checkpoint")) {
		 		crossCheckpoint(CR.getName());
		 	}
		 	print(CR.getDescription());
		}else {
			print("There is nothing in that direction");
		}		
    	}else { print("Where would you like to go? \nOptions: " + CR.options().keySet().toString());}
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
    public void linkRooms(Room r1, Room r2, String direct) {
    	r1.addDirection(direct, r2);
    	directNames.add(direct);
    }
    
    

    public void finishGame() { over = true; }
    
    

    public void print(String output) {
    	System.out.println(output);
    }

	public void pet() {
		Room room = getCurrentRoom();
		NPC npc = room.getNPC();
		if(npc instanceof Pet) {
			print(npc.talk());
			String toAdd = "pet" + ((Pet) npc).getNum();
			PetMedallion.add(toAdd);
			wonGame();
		}
	}

	public void attack() {
		Room room = getCurrentRoom();
		NPC npc = room.getNPC();
		if(npc != null){
		print(npc.attacked());
		} else { print("you strike the air"); };
		
	}

	public void take(String property) {
		Room room = getCurrentRoom();
		HashSet<String> properties = room.getProperties();
		if (properties.contains(property)) {
				addItemToBackpack("sword", new Sword());
				properties.remove("sword");
				print("You picked up the " + property);
			} else {print("Nothing happened.");}
		}

	public void talk() {
		Room room = getCurrentRoom();
		NPC npc = room.getNPC();
		if(npc != null){
		print(npc.talk());
		} else { print("the air listens..."); }	
	}

	public void use(String second) {
		if(second.equals("")){
			print("What item would you like to use? \n Options: " + backpack.toString());
		}
		else if(backpack.containsKey(second)){
			backpack.get(second).ability(getCurrentRoom());
		} else {
			print("You don't have a " + second);
		}
		
	}

	public void look(String second) {
		Room room = getCurrentRoom();
		print(room.getDescription());
	}


}

   