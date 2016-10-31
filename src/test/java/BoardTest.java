package ttt;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class BoardTest
{
    Board board = new Board();

    @Test //0.0
	public void testColumn() {
        assertEquals(0, board.getCol(0));
        assertEquals(1, board.getCol(7));
		assertEquals(2, board.getCol(2));
	}

    @Test //0.1
    public void testRow() {
        assertEquals(0, board.getRow(0));
        assertEquals(1, board.getRow(5));
        assertEquals(2, board.getRow(8));
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
        assertEquals("*********0", board.stringifyBoard());
    }

    @Test //4.0
    public void testMOCKupdateCell() {
        board.MOCKupdateCell(0, '0');
        board.MOCKupdateCell(1, '1');
        board.MOCKupdateCell(2, '2');
        board.MOCKupdateCell(3, '3');
        board.MOCKupdateCell(4, '4');
        board.MOCKupdateCell(5, '5');
        board.MOCKupdateCell(6, '6');
        board.MOCKupdateCell(7, '7');
        board.MOCKupdateCell(8, '8');
        assertEquals("0123456783", board.stringifyBoard());
    }

    @Test (expected=IndexOutOfBoundsException.class) //4.1
    public void testMOCKupdateCellFailure() {
        board.MOCKupdateCell(9, '#');
    }

    @Test //4.2
    public void testMOCKupdateCellDuplicate() {
        board.MOCKupdateCell(2, 'X');
        board.MOCKupdateCell(2, 'X');
        board.MOCKupdateCell(2, 'X');
        assertEquals("**X******0", board.stringifyBoard());
    }

    @Test //5.0
    public void testIsDraw() {
        board.MOCKupdateCell(0, '0');
        board.MOCKupdateCell(1, '1');
        board.MOCKupdateCell(2, '2');
        board.MOCKupdateCell(3, '3');
        board.MOCKupdateCell(4, '4');
        board.MOCKupdateCell(5, '5');
        board.MOCKupdateCell(6, '6');
        board.MOCKupdateCell(7, '7');
        board.MOCKupdateCell(8, '8');
        assertEquals(true, board.isDraw());
    }

    @Test //5.1
    public void testIsDrawFailure() {
        board.MOCKupdateCell(0, 'X');
        assertEquals(false, board.isDraw());
    }

    @Test //6.0
    public void testHorizontalWinX() {
        board.MOCKupdateCell(0, 'X');
        board.MOCKupdateCell(1, 'X');
        board.MOCKupdateCell(2, 'X');
        assertEquals(1, board.horizontalWin());
    }

    @Test //6.1
    public void testHorizontalWinO() {
        board.MOCKupdateCell(3, 'O');
        board.MOCKupdateCell(4, 'O');
        board.MOCKupdateCell(5, 'O');
        assertEquals(2, board.horizontalWin());
    }

    @Test //7.0
    public void testVerticalWinX() {
        board.MOCKupdateCell(1, 'X');
        board.MOCKupdateCell(4, 'X');
        board.MOCKupdateCell(7, 'X');
        assertEquals(1, board.verticalWin());
    }

    @Test //7.1
    public void testVerticalWinO() {
        board.MOCKupdateCell(2, 'O');
        board.MOCKupdateCell(5, 'O');
        board.MOCKupdateCell(8, 'O');
        assertEquals(2, board.verticalWin());
    }

    @Test //8.0
    public void testCrossX() {
        board.MOCKupdateCell(0, 'X');
        board.MOCKupdateCell(4, 'X');
        board.MOCKupdateCell(8, 'X');
        assertEquals(1, board.crossWin());
    }

    @Test //8.1
    public void testCrossO() {
        board.MOCKupdateCell(2, 'O');
        board.MOCKupdateCell(4, 'O');
        board.MOCKupdateCell(6, 'O');
        assertEquals(2, board.crossWin());
    }

    @Test //9.0
    public void testIsOverO() {
        board.MOCKupdateCell(2, 'O');
        board.MOCKupdateCell(4, 'O');
        board.MOCKupdateCell(6, 'O');
        assertEquals(2, board.isOver());
    }

    @Test //9.1
    public void testIsOverX() {
        board.MOCKupdateCell(0, 'X');
        board.MOCKupdateCell(1, 'X');
        board.MOCKupdateCell(2, 'X');
        assertEquals(1, board.isOver());
    }

    @Test //10
    public void testRealUpdateCell() {
        board.updateCell(0);
        board.updateCell(1);
        board.updateCell(2);
        assertEquals("XOX******0", board.stringifyBoard());
    }
}
