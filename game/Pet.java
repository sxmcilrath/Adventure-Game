package game;

public class Pet extends NPC{
	private boolean petted;
	
	public Pet() {
		this.petted = false;
	}
	
	public String talk() {
		this.petted = true;
		return "The dog licks you";
	}
	public String attacked() {
		return "Bark! Bark!";
	}
}
