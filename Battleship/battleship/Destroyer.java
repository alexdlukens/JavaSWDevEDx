package battleship;

public class Destroyer extends Ship {
	public Destroyer() {
		super();
		boolean[] hitBox = new boolean[4];
		this.setHit(hitBox);
		this.setLength(4);
	}
	@Override
	public String getShipType() {
		return "destroyer";
	}

}
