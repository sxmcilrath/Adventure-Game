package game;

public class Pet extends NPC{
	private boolean petted;
	private int number;
	public Pet(int number) {
		this.petted = false;
		this.number = number;
	}
	
	public String talk() {
		this.petted = true;
		return "The dog licks you";
	}
	
	public int getNum() {
		return this.number;
	}
	public String attacked() {
		return "Bark! Bark!";
	}
}
