package battleship;

public class BattleShip extends Ship {
	
	public BattleShip() {
		super();
		boolean[] hitBox = new boolean[8];
		this.setHit(hitBox);
		this.setLength(8);
	}
	
	@Override
	public String getShipType() {
		return "battleship";
	}
}
