package battleship;
import java.util.*;

public class Ocean {
	Ship[][] ships;
	int shotsFired;
	int hitCount;
	int shipsSunk;
	
	public Ocean() {
		ships = new Ship[20][20];
		
		for(int i=0; i<ships.length; i++) {
			for(int j=0; j<ships[i].length; j++) {
				EmptySea newShip = new EmptySea();
				ships[i][j] = newShip;
			}
		}
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
	}
	
	/**
	 * Place all randomly on the (initially empty) ocean. 
	 * Place larger ships before smaller ones, 
	 * or you may end up with no legal place to put a large ship
	 */
	public void placeAllShipsRandomly() {
		BattleShip ship1 = new BattleShip();
		if(ship1.okToPlaceShipAt(1, 1, true, this)) {
			ship1.placeShipAt(1, 1, true, this);
			System.out.println("battleship placed at 1,1");
		}
	}
	
	public boolean isOccupied(int row, int column) {
		if(ships[row][column].getShipType().equals("empty")) return false;
		else return true;
	}
	
	public boolean shootAt(int row, int column) {
		
		//always increment shotsFired
		shotsFired++;
		if(ships[row][column].isSunk()) {
			hitCount++;
			return false;
		}
		else if(ships[row][column].getShipType().equals("empty")) {
			//shootAt to update hit array inside emptySea
			ships[row][column].shootAt(row, column);
			return false;
		}
		//if not empty and not sunk, ship must be hit
		else {
			ships[row][column].shootAt(row, column);
			hitCount++;
			//if this shot sunk a ship, increase count
			if(ships[row][column].isSunk()) {
				shipsSunk++;
			}
			return true;
		}
	}
	
	public int getShotsFired() {
		return shotsFired;
	}
	
	public int getHitCount() {
		return hitCount;
	}
	
	public int getShipsSunk() {
		return shipsSunk;
	}
	
	public boolean isGameOver() {
		if(shipsSunk == 13) return true;
		else return false;
	}
	
	public Ship[][] getShipArray(){
		return ships;
	}
	
	public void print() {
		final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
		final String ANSI_RESET = "\u001B[0m";
		for(int i=0;i<20; i++) {
			System.out.print(ANSI_RESET);
//			System.out.print(ANSI_BLACK_BACKGROUND);
			//print column heading (00 -> 19)
			if(i==0) {
				System.out.print("    ");
				for(int j=0; j<20; j++) {
					String formattedVal = String.format("%02d", j);
					System.out.print(formattedVal + " ");
				}
				//newline
				System.out.println("");
			}
			
			String formattedRow = String.format("%02d", i);
			System.out.print(formattedRow + ": ");
			for(int j=0; j<20; j++) {
				System.out.print(ships[i][j] + ANSI_RESET + " ");
			}
			System.out.println("");
		}
	}
	
}
