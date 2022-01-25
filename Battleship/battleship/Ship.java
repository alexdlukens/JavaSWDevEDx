package battleship;

public abstract class Ship {
	
	/**
	 * the row (0 to 19) which contains the bow (front) of the ship
	 */
	int bowRow;
	
	/**
	 * the column which contains the bow (front) of the ship
	 */
	int bowColumn;
	
	/**
	 * the number of squares occupied by the ship. 
	 * An ”empty sea” location has length 1
	 */
	int length;
	
	/**
	 * true if the ship occupies a single row, false otherwise. 
	 * Ships will either be placed vertically or horizontally in the ocean
	 */
	boolean horizontal;
	
	/**
	 * this is a boolean array of size 8 that record hits. 
	 * Only battleships use all the locations. The others will use fewer
	 */
	boolean[] hit;
	
	public int getBowRow() {
		return bowRow;
	}
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}
	public int getBowColumn() {
		return bowColumn;
	}
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public boolean[] getHit() {
		return hit;
	}
	public void setHit(boolean[] hit) {
		this.hit = hit;
	}
	
	public abstract String getShipType();
	
	/**
	 * Returns true if it is okay to put a ship of this length 
	 * with its bow in this location, with the given orientation, 
	 * and returns false otherwise. The ship must not overlap another ship, 
	 * or touch another ship (vertically, horizontally, or diagonally), 
	 * and it must not ”stick out” beyond the array. Do not actually change 
	 * either the ship or the Ocean, just says whether it is legal to do so
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		
		return true;
	}
	
	/**
	 * ”Puts” the ship in the ocean. This involves giving values to the bowRow, bowColumn, 
	 * and horizontal instance variables in the ship, 
	 * and it also involves putting a reference to the ship in each of 1 or more locations (up to 8) 
	 * in the ships array in the Ocean object. 
	 * (Note: This will be as many as eight identical references; 
	 * you can’t refer to a ”part” of a ship, only to the whole ship.)
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		
	}
	
	/**
	 * If a part of the ship occupies the given row and column, and the ship hasn’t been sunk, 
	 * mark that part of the ship as ”hit” (in the hit array, 0 indicates the bow) 
	 * and return true, otherwise return false
	 * @param row
	 * @param column
	 * @return
	 */
	boolean shootAt(int row, int column) {
		
		return false;
	}
	
	/**
	 * Return true if every part of the ship has been hit, false otherwise
	 * @return
	 */
	public boolean isSunk() {
		
		return false;
	}
	
	@Override
	public String toString() {
		
		if(this.isSunk()) return "x";
		else return "S";
	}
}
