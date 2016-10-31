package ttt;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class BoardTest
{
    Board board = new Board();

    @Test //0.0
	public void testColumn()
	{
		assertEquals(2, board.getCol(2));
	}

    @Test //0.1
    public void testRow()
    {
        assertEquals(3, board.getRow(9));
    }
}
