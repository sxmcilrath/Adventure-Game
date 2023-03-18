package game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private Room CR;
    private Crafter crafter;
//to do checkpoints, directions 

    
    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over = false;
	
    private HashMap<String, Item> backpack = new HashMap<String, Item>();
    private HashSet<String> PetMedallion = new HashSet<String>();
    private HashSet<String> checkpoints = new HashSet<String>();
	    
    public Player() {
    	

	    	
    	this.crafter = new Crafter(backpack);	
    }
	    
    public boolean isOver() { return over; }
	    
    public void pet() {
	    	
    	NPC npc = CR.getNPC();
    	if(npc instanceof Pet) {
    		print(npc.talk());
    		String toAdd = "pet" + ((Pet) npc).getNum();
    		PetMedallion.add(toAdd);
    		wonGame();
    	}
    }
	    
    /**
     * Checks if room has a lever, if it does it activates the lever ability
     * @param second second word doesn't really matter here. Levers 
     * are the only things to pull
     */
    public void pull(String second) {
    	if(CR.getLever() == null) {
    		System.out.println("There's nothing to pull!");
	    }
    	else {
    		System.out.println(CR.getLever().ability(CR));
    	}    	
    }

    /**
     * Prints response based on NPC. Not actual combat system, more
     * of a dialogue option
     */
    public void attack() {
    	NPC npc = CR.getNPC();
    	if(npc != null){
    		print(npc.attacked());
    	} else { print("you strike the air"); };	
    }
	
    /**
     * takes specified property if in room
     * @param property	requested property
     */
    public void take(String property) {
    	//if user just inputs take, it prints the current items available
    	//to take in the room
    	if(property.equals("")) {
    		print(CR.getProperties().keySet().toString());
		} else {
			HashMap<String,Item> properties = CR.getProperties();
			
			//checks backpack for the property and if it is in the room 
			//and not in the backpack it then adds it to the backpack and removes
			//it from the room
			if(!(backpack.containsKey(property))){
				if (properties.keySet().contains(property)) {
					addItemToBackpack(property, properties.get(property));
					properties.remove(property);
					print("You picked up the " + property);
					
				} else {print("Nothing happened.");}	
			} else { print("you can only carry one " + property);}
		}		
    }
		
    /**
     * grabs the NPC from the room if there is one and prints 
     * out the NPC's text response
     */
    public void talk() {
    	NPC npc = CR.getNPC();
    	if(npc != null){
    		print(npc.talk());
    	} else {print("the air listens..."); }	
    }
		
    /**
     * activates an item's ability if it's in the backpack
     * @param second	item the player wants to use
     */
    public void use(String second) {	
    	//if player doesn't request specific item it lists out possibilities
    	if(second.equals("")){
    		print("What item would you like to use? \n Options: " + backpack.keySet().toString());
    	}
    	//activates ability if viable
    	else if(backpack.containsKey(second)){
    		print(backpack.get(second).ability(CR));
    	} else {
    		//player does not have item
    		print("You don't have a " + second);
    	}		
    }
		
    /**
     * removes item from your backpack
     * @param second	target item
     */
    public void drop(String second) {
    	//if player does not specify item, it lists out all items in backpack
    	if(second.equals("")){
    		print("What item would you like to drop? \n Options: " + backpack.keySet().toString());
		}
			
    	//if viable item, it removes it from backpack and adds it to
    	//the room
    	else if(backpack.containsKey(second)){
    		CR.addProperty(second, backpack.get(second));
    		backpack.remove(second);
    		print("you dropped a " + second);
    	} else {
    		//if target item is not in backpack
    		print("You don't have a " + second);
    	}		
    }
		
    /**
     * creates new item based on current items 
     * @param second	item wanting to be crafted
     */
    public void craft(String second) {
    	//if no item is specified, lists out possible crafting options
    	if(second.equals("")) {
    		Set<String> toPrint = this.crafter.canCraft();
    		print(toPrint.toString());
    	} else {
    		//if item is not in backpack, it attempts to craft said item
    		if(!(backpack.containsKey(second))){
    			print(crafter.crafted(second));
			} else { print("you can only carry one " + second);}
    	}
    }

    /**
     * prints the description of the current room
     * @param second
     */
    public void look() {
    	print(CR.getDescription());
    }
		
    /**
     * @return returns crafter
     */
    public Crafter getCrafter() {
    	return this.crafter;
    }
  
    /**
     * getter for the current room
     * @return the room that the player is currently in
     */
    public Room getCurrentRoom() { return CR; }
		
    /**
     * setter for the current room
     * @param CR the room to which the current room will be set
     */
	public void setCurrentRoom(Room CR) { this.CR = CR; }

	/**
	 * switches the room the player is in
	 * @param first		name of direction
	 */
	public void switchRoom(String first) {
		//checks to see if user wants to go anywhere
		if(first != "") {  
			//Checks if direction is a key in the directions hashmap
			if(CR.checkDirection(first)) {	
				Door door = CR.getDoor(first);	
					
				//checks if the door is a LockedDoor, if it is, it grabs the 
				//name of the doors key
				if(door instanceof LockedDoor) {
					String keyName = ((LockedDoor) door).getKey().myName;
					
					//checks backpack for the key and lets player through
					//based on if player has it
					if(backpack.containsKey(keyName)) {
						CR = door.nextRoom(CR);
						print("you used a " + keyName);
					} else {
						print("You need a " + keyName);
					}
				}else {
					//door is not locked so advance to the next room
					CR = door.nextRoom(CR);
				}
					
				//print out the room description upon arrival
				look();					
			} else {
				//player requests non viable direction
				print("There is nothing in that direction");
			} 
		} else {	
			//player does not specify direction and all option ar printed
			print("Where would you like to go? \nOptions: " + CR.options().keySet().toString());
		}
		//when entering a room, it adds the room id to checkpoints
		this.checkpoints.add(CR.getName());
	}
		
	/**
	 * adds progress checkpoint to hashset
	 * @param check		specified checkpoint
	 */
	public void addCheckpoint(String check) {
		checkpoints.add(check);
	}
		    
	/**
	 * checks whether or not a check has been crossed
	 * @param check The check to check for
	 * @return whether or not the check check checks out
	 *
	 */
	//this means "has the checkpoint been crossed"
	public boolean wasCheckCrossed(String check) {
		return checkpoints.contains(check);
	}
		    
	/**
	 *checks to see if game has been won based on how many dogs have been pet
	 */
	public void wonGame() {
		this.over = true;
		print("PetMedals " + PetMedallion.size());
		for(int i = 1; i < 7; i++) {
			String pet = "pet" + i;
			if(!(PetMedallion.contains(pet))){
				this.over =false;
			}
		}	    	
	}
		    
		    
		    
		    
		    
		    
	/**
	 * This method takes an item name, a room, and tries to use the
	 * item, and will fail to do so if the item is not in the backpack.
	 * @param item The item you are trying to use
	 * @param room The room you are trying to use the item in
	 * @return a string containing a description of what happened **/
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
	 * removes target item from backpack
	 * @param name	name of target item
	 */
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
	 * prints out a string to the console. More efficient than System.out.println(string)
	 * @param output The string to print to the console
	 */
	public void print(String output) {
		System.out.println(output);
	}

}
