package battleship;

public class EmptySea extends Ship {
	public EmptySea() {
		super();
		boolean[] hitBox = new boolean[1];
		hitBox[0] = false;
		this.setHit(hitBox);
	}
	
	/**
	 * This method just returns the string ”empty”
	 */
	@Override
	public String getShipType() {
		return "empty";
	}
	
	/**
	 * This method overrides shootAt(int row, int column) that is inherited from Ship, 
	 * and always returns false to indicate that nothing was hit.
	 */
	@Override
	public boolean shootAt(int row, int column) {
		this.hit = new boolean[] {true};
		return false;
	}
	
	/**
	 * This method overrides isSunk() that is inherited from Ship, 
	 * and always returns false to indicate that you didn’t sink anything.
	 */
	@Override
	public boolean isSunk() {
		//nothing to sink, return false
		return false;
	}
	
	/**
	 * displays '.' to signify unoccupied space
	 */
	@Override
	public String toString() {
		
		final String ANSI_RED = "\u001B[41m";
		//if user has fired at location, return - to signify miss
		if(this.getHit()[0] == true) return ANSI_RED + "- ";

		//return . for unoccupied space
		return ". ";
	}
	
}
