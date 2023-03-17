package game;

import java.util.HashSet;
/**
 * 
 * medallion that is obtained in the ice castle. It can be combined with the
 * sand medallion to create the final key
 *
 */
public class IceMedallion extends Item {

	private static HashSet<String> Craftable = new HashSet<String>();
	private static HashSet<String[]> CraftedBy = new HashSet<String[]>();
	private static Key K = new Key("tocastle");
	
	public IceMedallion() {
		super(Craftable, CraftedBy, "icemedallion");
		//Craftable.add(K);
		
	}
	@Override
	protected String ability(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

}
