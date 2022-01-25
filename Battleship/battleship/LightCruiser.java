package battleship;

public class LightCruiser extends Ship {
	public LightCruiser() {
		super();
		boolean[] hitBox = new boolean[5];
		this.setHit(hitBox);
	}
	@Override
	public String getShipType() {
		return "light cruiser";
	}

}
