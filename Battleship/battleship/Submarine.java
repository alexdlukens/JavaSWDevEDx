package battleship;

public class Submarine extends Ship {
	
	public Submarine() {
		super();
		boolean[] hitBox = new boolean[3];
		this.setHit(hitBox);
	}

	@Override
	public String getShipType() {
		return "submarine";
	}

}
