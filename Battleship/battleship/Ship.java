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
	
	private boolean diagonalSafe(int row, int column, boolean isHorizontal, Ocean ocean) {
		int length = this.getLength();
		if(!horizontal) {
			if(row == 0) {
				if(column==0) {
					//only check right side of boat for diagonal
					if(ocean.isOccupied(row+length, column+1)) return false;
				}
				else {
					if(ocean.isOccupied(row+length, column+1) | ocean.isOccupied(row+length, column-1)) return false;
				}
			}
			else {
				if(column==0) {
					//only check right side of boat for diagonal
					if(ocean.isOccupied(row+length, column+1)) return false;
					if(ocean.isOccupied(row-1, column+1)) return false;
				}
				else {
					if(ocean.isOccupied(row+length, column+1)) return false;
					if(ocean.isOccupied(row-1, column+1)) return false;
					if(ocean.isOccupied(row+length, column+1)) return false;
					if(ocean.isOccupied(row-1, column+1)) return false;
				}
			}
		}
		else {
//			if(column == 0)
//			TODO fill out horizontal part
		}
		return true;
	}
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
		int length = this.getLength();
		if(!diagonalSafe(row,column,horizontal,ocean))return false;
		if(!horizontal) {
			if(row+length-1 > 19) return false;
			for(int i = 0; i<length; i++) {
				if(ocean.isOccupied(row+i, column)) return false;
			}
		}
		else {
			if(column+length-1 > 19) return false;
			for(int i = 0; i<length; i++) {
				if(ocean.isOccupied(row, column+i)) return false;
			}
		}
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
		Ship[][] ships = ocean.getShipArray();
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		//place ship vertically
		if(!horizontal) {
			for(int i = 0; i<length; i++) {
				ships[row+i][column] = this;
			}
		}
		//place ship horizontally
		else {
			for(int i = 0; i<length; i++) {
				ships[row][column+i] = this;
			}
		}
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
		System.out.println("inside shootAt");
		if(this.isHorizontal()) {
			if((column==column) & (row >= this.getBowRow()) & (row < this.getBowRow()+this.getLength())) {
				int box = row-this.getBowRow();
				boolean[] hitboxes = this.getHit();
				hitboxes[box] = true;
				this.setHit(hitboxes);
				System.out.println("hit, row=" + row + " column=" + column + " box=" + box);
				return true;
			}
			if((row==row) & (column >= this.getBowColumn()) & (column < this.getBowColumn()+this.getLength())) {
				int box = row-this.getBowRow();
				boolean[] hitboxes = this.getHit();
				hitboxes[box] = true;
				this.setHit(hitboxes);
				System.out.println("hit");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Return true if every part of the ship has been hit, false otherwise
	 * @return
	 */
	public boolean isSunk() {
		boolean[] hitboxes = this.getHit();
		for(boolean bool : hitboxes) {
			if(bool == false) return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		
		if(this.isSunk()) return "x ";
		else return "S ";
	}
}
