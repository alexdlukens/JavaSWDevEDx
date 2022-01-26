package battleship;

public class Cruiser extends Ship {
	
	public Cruiser() {
		super();
		boolean[] hitBox = new boolean[6];
		this.setHit(hitBox);
		this.setLength(6);
	}
	
	@Override
	public String getShipType() {
		return "cruiser";
	}

}
