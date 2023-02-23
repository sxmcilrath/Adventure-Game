package game;

public class TalkC implements Command{

	public TalkC () {
		
	}


	public void call(String first, String second, int words, Game game) {
		//add code here
		game.talk();
		Room room = game.getCurrentRoom();
		NPC npc = room.getNPC();
		String wordsSaid = npc.talk();
		System.out.println(wordsSaid);
	}
	
}
