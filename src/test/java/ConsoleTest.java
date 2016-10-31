package ttt;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ConsoleTest
{
    //private Console c;
		
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	
	@Before
	public void setUpStreams() 
	{
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUpStreams() 
	{
		System.setOut(null);
	}
	
	
	@Test //1.0
	public void testPrint()
	{
		Console c = new Console();
		c.MockPrintBoard();
		assertEquals("1 2 3 \n4 5 6 \n7 8 9 \n\n", outContent.toString());
	}
	
	@Test //2.0
	public void testSelectFirstPlayer()
	{
		Console c = new Console();
		char Player = c.SelectFirstPlayer();
		boolean test = false;
		if(Player == 'X' || Player == 'O');
		{
			test = true;
		}
		
		assertEquals(true, test);
	}
	
	
	@Test //3.0
	public void testMockPlay()
	{
		Console c = new Console();

		List<String> legalPlays = new ArrayList<String>();
		legalPlays.add("XOXOOXOXO3");
		legalPlays.add("OXOXXOXOX3");
		c.MockPlay();
		String result = c.MockReadBoard();
		boolean test = false;

		if (legalPlays.contains(result))
		{
			test = true;
		}
		
		assertEquals(true, test);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class) //4.0
	public void testMockreadInput()
	{
		Console c = new Console();

		c.MockReadInput(11);
	}
	

}