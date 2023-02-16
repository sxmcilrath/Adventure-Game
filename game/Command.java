package game;

public interface Command {

	public void call(String first, String second, int words, Game game);
}
