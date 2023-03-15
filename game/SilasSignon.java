package game;

//NPC that gives you clue for icy path puzzle
public class SilasSignon extends NPC {

	@Override
	public String talk() {
		return "Hello traveler, I'm Silas! Wandered far from the path eh? Well I'll let you know you won't wander much farther on these frozen roads.\n"
				+ "But you do look like a good fellow. The type that pets dogs I'd reckon.\n"
				+ "Because of that I'll let you know of the famous tale told around these parts. Do with it what you will: \n\n"
				+ "Icy woods turn a forest to maze,\n"
				+ "Be sure to beware, for twists and turns will amaze.\n"
				+ "To reach your goal, you must follow my lead,\n"
				+ "Left, then right, and forward you proceed.\n"
				+ "But do not celebrate too soon,\n"
				+ "For the final step will make you swoon,\n"
				+ "Go back you must, against the tide,\n"
				+ "Only then will you reach the other side.\n\n"
				+ "Or it's something like that. Not that I memorize it or anything...\nGood luck!";
	}

}
