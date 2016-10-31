package ttt;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

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
	

    @Test //0.0
	public void testIfTestWorks() 
    {
		Console c = new Console();
        assertEquals(0, c.GetIsOver());
	}
	
	@Test //1.1
	public void testprint()
	{
		Console c = new Console();
		c.PrintBoard();
		assertEquals("1 2 3 \n4 5 6 \n7 8 9 \n", outContent.toString());
  }

}