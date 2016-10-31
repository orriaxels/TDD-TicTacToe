package ttt;

public class Console 
{
	private Board b;
	private int IsOver;
	private int SIZE = 3;

    public Console()  
    {
    	b = new Board();
    	IsOver = b.isOver();
    }
    
	public void PrintBoard()
	{
		for (int i = 0; i < SIZE; i++)
		{
			for (int y = 0; y < SIZE; y++)
			{
				int pos = (SIZE * i+y) + 1;
				char eb = b.cells[i][y];
				//System.out.println(pos);
				if (eb == '*')
				{
					System.out.print(pos);
				}
				else
				{
					System.out.print(eb);
				}
			}
			System.out.print("\n");
		}
	}
	
    public int GetIsOver()
    {
    	return IsOver;
    }
    
    public static void main(String[] args) 
    {
		Console c = new Console();
		c.PrintBoard();
	}
}
