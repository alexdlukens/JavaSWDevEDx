package battleship;

public class Destroyer extends Ship {
	public Destroyer() {
		super();
		boolean[] hitBox = new boolean[4];
		this.setHit(hitBox);
	}
	@Override
	public String getShipType() {
		return "destroyer";
	}

}
