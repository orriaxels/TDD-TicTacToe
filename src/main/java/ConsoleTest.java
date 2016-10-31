package ttt;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConsoleTest
{
    Console c = new Console();

    @Test //0.0
	public void testIfTestWorks() 
    {
        assertEquals(0, c.GetIsOver());
	}
}