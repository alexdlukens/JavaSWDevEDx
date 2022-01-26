package battleship;

public class Submarine extends Ship {
	
	public Submarine() {
		super();
		boolean[] hitBox = new boolean[3];
		this.setHit(hitBox);
		this.setLength(3);
	}

	@Override
	public String getShipType() {
		return "submarine";
	}

}
