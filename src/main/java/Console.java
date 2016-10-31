package ttt;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Console 
{
	private Board b;
	private int isOver;
	private int SIZE = 3;
	Random rand;
	
    public Console()  
    {
		rand = new Random();
    	b = new Board();
    	isOver = b.isOver();
		b.mark = SelectFirstPlayer();
    }
    
	//PRINTS A STRAIGHT LINE FOR CONSOLE PRINT
	public void PrintLines(int size)
	{
		char line = '-';
		for (int i = 0; i <= size*4; i++)
		{
			System.out.print(line);
		}
		System.out.println();
	}
	
	//PAUSES GAME FOR 1 SECOND
	public void Sleep()
	{
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//RETURNS TRUE IF INPUT IS VALID.
	public boolean ValidateInput(int input)
	{
		if (input >= 0 && input < SIZE*3)
		{
			if (b.isEmpty(input))
			{
				return true;
			}
		}
		return false;
	}
	
	//READS INPUT FROM KEYBOARD
	public void ReadInput()
	{
		System.out.print("Choose cell: ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		if (ValidateInput(input-1))
		{
			b.updateCell(input-1);
			return;
		}
		ReadInput();
	}
	
	//SETS INPUT FROM PARAMETER
	public void SetInput(int pos)
	{
		if (ValidateInput(pos))
		{
			b.updateCell(pos);
		}
	}
	
	//PRINTS BOARD TO CONSOLE
	public void VisualPrintBoard()
	{
		for (int i = 0; i < SIZE; i++)
		{
			PrintLines(SIZE);
			for (int y = 0; y < SIZE; y++)
			{
				int pos = (SIZE * i+y) + 1;
				char cell = b.cells[i][y];				
				System.out.print("| ");
				
				if (cell == '*')
				{
					System.out.print(pos + " ");
				}
				else
				{
					System.out.print(cell + " ");
				}
			}
			System.out.print("| ");
			System.out.print("\n");
		}
		PrintLines(SIZE);
	}
	
	//TWO PLAYER GAME
	public void TwoPlayer()
	{
		isOver = b.isOver();
		while (isOver == 0)
		{
			System.out.println("Current player is: " + b.mark);
			ReadInput();
			VisualPrintBoard();
			isOver = b.isOver();
		}

		Winner(isOver);
	}
	
	//RANDOM INPUT SELECTION FOR COMPUTER
    public int ComputerSelectGame()
    {
    	int select = rand.nextInt(9);
		while ( !b.isEmpty(select) ) 
		{
			select = rand.nextInt(9);
		}
		return select;
    }
	
	//COMPUTER PLAYER AND HUMAN PLAYER
	public void SinglePlayer()
	{		
		int isOver = b.isOver();
		
		int game = rand.nextInt(2);
		
		while (isOver == 0)
		{
			if (game == 0)
			{
				System.out.println("Computers Turn" + " (" + b.mark + "):");
				Sleep();
				SetInput(ComputerSelectGame());
				VisualPrintBoard();
			}
			else
			{
				System.out.println("Your Turn" + " (" + b.mark + "):");
				ReadInput();
				VisualPrintBoard();
			}
			isOver = b.isOver();
			
			game ^= 1;
		}
		Winner(isOver);
	}
	
	//PRINTS TO CONSOLE WHO IS THE WINNER
	public void Winner(int mark)
	{
		PrintGameOver();

		char win;
		if (mark == 1)
		{
			win = 'X';
		}
		else if (mark == 2)
		{
			win = 'O';
		}
		else
		{
			return;
		}
		
		System.out.println("Congratulations Player " + win + " YOU'RE WINNER!");
	}

	//SELECTS AT RANDOM A PLAYER
	public char SelectFirstPlayer()
    {
    	int select = rand.nextInt(2);    	
    	if (select == 0)
    	{
    		return 'X';
    	}
    	return 'O';
    }
   
    
	  public static void main(String[] args) 
	    {
			PrintWelcome();

			Console c = new Console();
			
			char gameSetting = '-';

			//Full automation for Gradle
			if (gameSetting == '-')
			{
				c.VisualPrintBoard();
				c.MockTestPlay();	
			}
			
			//single player mode
			if (gameSetting == '+')
			{
				c.VisualPrintBoard();
				c.SinglePlayer();
			}
			
			//2-player mode
			if (gameSetting == '/')
			{
				c.VisualPrintBoard();
				c.TwoPlayer();
			}
		}
    
    //MOCK FUNCTIONS:
	public void MockPrintBoard()
	{
		for (int i = 0; i < SIZE; i++)
		{
			for (int y = 0; y < SIZE; y++)
			{
				int pos = (SIZE * i+y) + 1;
				char cell = b.cells[i][y];
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
	
	public void MockPlay()
	{
		SetInput(1);
		SetInput(2);
		SetInput(3);
		for (int i = 0; i < 9; i++)
		{
			SetInput(i);
		}
		MockPrintBoard();
	}
	
	public void MockTestPlay()
	{
		int isOver = b.isOver();
		
   		while (isOver == 0)
		{
			System.out.println("Current player is: " + b.mark);
			SetInput(ComputerSelectGame());
			VisualPrintBoard();
			isOver = b.isOver();
			Sleep();
		}

		Winner(isOver);
	}
	
	//FOR TESTING PURPOSES ONLY
	public String MockReadBoard()
	{
		return b.stringifyBoard();
	}
	
	//Awesome ascii art checking in.
	private static void PrintWelcome() {
		System.out.println("  _____                                    _______ _______ _______ ");
		System.out.println(" / ____|                                  |__   __|__   __|__   __|");
		System.out.println("| (___  _   _ _ __   ___ _ __ __ _ _   _     | |     | |     | |   ");
		System.out.println(" \\___ \\| | | | '_ \\ / _ \\ '__/ _` | | | |    | |     | |     | |   ");
		System.out.println(" ____) | |_| | | | |  __/ | | (_| | |_| |    | |     | |     | |   ");
		System.out.println("|_____/ \\__, |_| |_|\\___|_|  \\__, |\\__, |    |_|ic   |_|ac   |_|oe ");
		System.out.println("	 __/ |                __/ | __/ |                          ");
		System.out.println("	|___/                |___/ |___/                           ");
		System.out.println("___________________________________________________________________\n");
	}

	private static void PrintGameOver() {
		System.out.println("  _____                       ____                 ");
		System.out.println(" / ____|                     / __ \\                ");
		System.out.println("| |  __  __ _ _ __ ___   ___| |  | |_   _____ _ __ ");
		System.out.println("| | |_ |/ _` | '_ ` _ \\ / _ \\ |  | \\ \\ / / _ \\ '__|");
		System.out.println("| |__| | (_| | | | | | |  __/ |__| |\\ V /  __/ |   ");
		System.out.println(" \\_____|\\__,_|_| |_| |_|\\___|\\____/  \\_/ \\___|_|   ");
		System.out.println("												 ");
	}
}
