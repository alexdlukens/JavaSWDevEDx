package squarelotron;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquarelotronTest {
	Squarelotron square8;
	Squarelotron square5;
	Squarelotron square4;
	Squarelotron square3;
	@BeforeEach
	void setUp() throws Exception {
		square8 = new Squarelotron(8);
		square5 = new Squarelotron(5);
		square4 = new Squarelotron(4);
		square3 = new Squarelotron(3);
	}
	
	@Test
    public void ConstructorVerification(){
        assertTrue(square5.squarelotron[0][0]==1, "first element != 1");
        assertTrue(square5.squarelotron[square5.size-1][square5.size-1]==(square5.size * square5.size), "last element != n squared");
    }
	
	@Test
	void testSquarelotronConstructor() {
		assertTrue(square8.size == 8);
		assertTrue(square5.size == 5);
		assertTrue(square4.size == 4);
	}
	
	@Test
	void testUpsideDownFlip() {
		Squarelotron output5 = square5.upsideDownFlip(1);
		assertTrue(output5.size == 5);
		assertTrue(output5.squarelotron[0][0]==21);
		assertTrue(output5.squarelotron[1][0]==16);
		
		System.out.println();
		output5 = square5.upsideDownFlip(2);
		assertTrue(output5.squarelotron[1][1]==17);
		assertTrue(output5.squarelotron[2][1]==12);
		assertTrue(output5.squarelotron[2][2]==13);
		System.out.println();
		
		output5 = square5.upsideDownFlip(3);
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				assertTrue(output5.squarelotron[i][j] == square5.squarelotron[i][j]);
			}
		}
		System.out.println();
		
		Squarelotron output4 = square4.upsideDownFlip(2);
		assertTrue(output4.squarelotron[1][1]==10);
		assertTrue(output4.squarelotron[1][2]==11);
//		Squarelotron output8 = square8.upsideDownFlip(1);
		System.out.println();


	}

	@Test
	void testMainDiagonalFlip() {
        int[] row2sq3 = {2, 5, 8};
        Squarelotron threeFlipRing1 = square3.mainDiagonalFlip(1);
        assertArrayEquals(threeFlipRing1.squarelotron[1], row2sq3);

        int[] square4ring1row2 = {2,6,7,14};
        int[] square4ring2row2 = {5,6,10,8};

        Squarelotron fourFlip = square4.mainDiagonalFlip(1);
        assertArrayEquals(fourFlip.squarelotron[1], square4ring1row2);
        System.out.println();
        fourFlip = square4.mainDiagonalFlip(2);
        assertArrayEquals(fourFlip.squarelotron[1], square4ring2row2);

//		fail("Not yet implemented");
	}

	@Test
	void testRotateRight() {
		Squarelotron sq = new Squarelotron(4);
		square4.rotateRight(4);
		assertArrayEquals(sq.squarelotron[3], square4.squarelotron[3]);
	}
	
	@Test
	void rotateSingleTime() {
		int[] row0 = {7,4,1};
		square3.rotateOnce();
		assertArrayEquals(square3.squarelotron[0], row0);
		square3.rotateRight(3);
		int[] row0_2 = {1,2,3};
		assertArrayEquals(square3.squarelotron[0], row0_2);
	}
	

}