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

    @Test //3
    public void testStringify() {
        assertEquals("*********", board.stingifyBoard());
    }

    @Test //4.0
    public void testUpdateCell() {
        board.updateCell(0, '0');
        board.updateCell(1, '1');
        board.updateCell(2, '2');
        board.updateCell(3, '3');
        board.updateCell(4, '4');
        board.updateCell(5, '5');
        board.updateCell(6, '6');
        board.updateCell(7, '7');
        board.updateCell(8, '8');
        assertEquals("012345678", board.stingifyBoard());
    }

    @Test (expected=IndexOutOfBoundsException.class) //4.1
    public void testUpdateCellFailure() {
        board.updateCell(9, '#');
    }

    @Test //4.1
    public void testUpdateCellDuplicate() {
        board.updateCell(2, '#');
        board.updateCell(2, '#');
        board.updateCell(2, '#');
        assertEquals("**#******", board.stingifyBoard());
    }

    @Test //5.0
    public void testIsDraw() {
        board.updateCell(0, '0');
        board.updateCell(1, '1');
        board.updateCell(2, '2');
        board.updateCell(3, '3');
        board.updateCell(4, '4');
        board.updateCell(5, '5');
        board.updateCell(6, '6');
        board.updateCell(7, '7');
        board.updateCell(8, '8');
        assertEquals(true, board.isDraw());
    }

    @Test //5.1
    public void testIsDrawFailure() {
        board.updateCell(0, 'X');
        assertEquals(false, board.isDraw());
    }
}
