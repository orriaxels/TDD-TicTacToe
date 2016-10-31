package ttt;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class BoardTest
{
    Board board = new Board();

    @Test //0.0
	public void testColumn() {
		assertEquals(2, board.getCol(2));
	}

    @Test //0.1
    public void testRow() {
        assertEquals(3, board.getRow(9));
    }

    @Test //1
    public void testInitialization() {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++)
                assertEquals('*', board.cells[row][col]);
        }
    }

    @Test //2
    public void testIsEmpty() {
        assertEquals(true, board.isEmpty(6));
    }

    @Test //2
    public void testStringify() {
        assertEquals("*********", board.stingifyBoard());
    }
}
