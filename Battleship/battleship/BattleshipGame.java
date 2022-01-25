package battleship;

public class BattleshipGame {
	
	
	public static void main(String[] args) {
		Ocean board = new Ocean();
		board.print();
		
		board.shootAt(1, 1);
		board.print();
	}
}
