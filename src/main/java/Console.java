package ttt;
import java.util.Random;
import java.util.Scanner;

public class Console 
{
	private Board b;
	private int IsOver;
	private int SIZE = 3;

    public Console()  
    {
    	b = new Board();
    	IsOver = b.isOver();
		b.mark = SelectFirstPlayer();
    }
    
	public void PrintBoard()
	{
		for (int i = 0; i < SIZE; i++)
		{
			for (int y = 0; y < SIZE; y++)
			{
				int pos = (SIZE * i+y) + 1;
				char cell = b.cells[i][y];
				//System.out.println(pos);
				if (cell == '*')
				{
					System.out.print(pos + " ");
				}
				else
				{
					System.out.print(cell + " ");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");

	}
	
	public void Play()
	{
		while (true)
		{
			System.out.println("Current player is: " + b.mark);
			readInput();
			PrintBoard();
		}
	}
	
	public void MockPlay()
	{
		MOCKreadInput(2);
		//PrintBoard();
		MOCKreadInput(4);
		//PrintBoard();
		MOCKreadInput(8);
		//PrintBoard();
		for (int i = 1; i < 10; i++)
		{
			MOCKreadInput(i);
			
		}
		PrintBoard();
	}
	
	public void MOCKreadInput(int pos)
	{
		b.updateCell(pos-1);
	}
	
	public void readInput()
	{
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		b.updateCell(input-1);
	}
	
	public char SelectFirstPlayer()
    {
    	Random rand = new Random();
    	int select = rand.nextInt(2);    	
    	if (select == 0)
    	{
    		return 'X';
    	}
    	return 'O';
    }
		
    public int GetIsOver()
    {
    	return IsOver;
    }
    
    public static void main(String[] args) 
    {
		Console c = new Console();
		c.PrintBoard();
		c.MockPlay();
	}
}
