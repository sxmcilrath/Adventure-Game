package game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Player {
    private Room CR;
    private Room PR;
    private Crafter crafter;

    
    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over = false;
	
    private HashMap<String, Item> backpack = new HashMap<String, Item>();
    private HashSet<String> PetMedallion = new HashSet<String>();
    private HashSet<String> checkpoints = new HashSet<String>();
    private Map<String,Item> allItems = new HashMap<String,Item>();
	    
	    public Player(Map<String,Item> allItems) {
	    	this.allItems = allItems;

	    	
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
	    
	    
	    public void pull(String second) {
	    	if(second.equals(second)) {
	    		CR.getLever().ability(CR);
	    	}
	    }

		public void attack() {
			NPC npc = CR.getNPC();
			if(npc != null){
				print(npc.attacked());
			} else { print("you strike the air"); };
			
		}

		public void take(String property) {
			Item i = allItems.get(property);
			
			HashSet<Item> properties = CR.getProperties();
			if (properties.contains(i)) {
					addItemToBackpack(property, new Sword());
					properties.remove(property);
					print("You picked up the " + property);
					
				} else {print("Nothing happened.");}
			}

		public void talk() {
			NPC npc = CR.getNPC();
			if(npc != null){
				print(npc.talk());
			} else {print("the air listens..."); }	
		}

		public void use(String second) {
			if(second.equals("")){
				print("What item would you like to use? \n Options: " + backpack.keySet().toString());
			}
			else if(backpack.containsKey(second)){
				print(backpack.get(second).ability(CR));
			} else {
				print("You don't have a " + second);
			}
			
		}
		
		public void craft(String second) {
			if(second.equals("")) {
				Set<String> toPrint = this.crafter.canCraft();
				print(toPrint.toString());
			} else {
				print(crafter.crafted(second));
			}
		}

		public void look(String second) {
			print(CR.getDescription());
		}
		
		public Crafter getCrafter() {
			return this.crafter;
		}

	    
		
		   public Room getCurrentRoom() { return CR; }
		    
		    public void setCurrentRoom(Room CR) { this.CR = CR; }

		    //swtiches rooms
		    public void switchRoom(String first) {
		    	//checks to see if user wants to go anywhere
		    	if(first != "") {
		    		//Checks if directon is a key in the directions hashmap
		    		if(CR.checkDirection(first)) {	
		    			Door door = CR.getDoor(first);
		    			Key key = door.getKey();
		    			if(key == null) {
		    				PR = CR;
		    				CR = door.nextRoom(CR);
		    			} else if(this.backpack.containsValue(key)){
		    				PR = CR;
		    				CR = door.nextRoom(CR);
		    				print("you used a " + key.getName());
		    			} else {
		    				print("You need a " + key.getName());
		    			}
		    			look("");
		    				crossCheckpoint(CR.getName());
		    				
					} else {
						print("There is nothing in that direction");
					} 
		    	}else {
		    		Iterator<String> it = CR.options().keySet().iterator();
		    		if(it.hasNext()) {
		    			print("Where would you like to go? \nOptions: " + it.next() + "");
		    		}
		    	}
		    }
		    
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
		    
		    
		    public void wonGame() {
		    	this.over = true;
		    	print("PetMedals" + PetMedallion.size());
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
		     * @return a string containing a descri this.Calls.get(temp).call(this.first, this.second, this.words);ption of what happened **/
		    
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
   	for(int i = 0; i < 
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

		    public void print(String output) {
		    	System.out.println(output);
		    }





		
}
