package game;

import java.util.HashSet;
import java.util.Set;

public class MetalChunk extends Item {

	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	
	public MetalChunk () {
		super(Craftable, CraftedBy);
		Craftable.add("bucket");
		Craftable.add("sword");
		Craftable.add("shovel");
		String[] a = {"bucket"};
		CraftedBy.add(a);
		String[] b = {"sword"};
		CraftedBy.add(b);
		String[] c = {"shovel"};
		CraftedBy.add(c);

	}
	@Override
	public String ability(Room room) {
		// restore hunger
		return "";
	}
	
	

}
