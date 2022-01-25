package battleship;

public class BattleCruiser extends Ship{
	
	public BattleCruiser() {
		super();
		boolean[] hitBox = new boolean[7];
		this.setHit(hitBox);
	}
	
	@Override
	public String getShipType() {
		return "battlecruiser";
	}
	
	
	
}
