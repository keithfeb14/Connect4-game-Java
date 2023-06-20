import java.io.BufferedReader;
import java.io.InputStreamReader;


abstract class Game{ // Abstract class that creates function with no bodies which the sub classes need to instantiate. 
	protected BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	protected char[][] board = new char[6][7];
	protected boolean win = false;
	
	abstract public String getUserInput();
	abstract public void placeCounter(char player, int position);
	abstract public char[][] playGame(char[][] b);
	
	public void printBoard() //Function that prints the board
	{
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] == 'r'){
					System.out.print("| r ");
				}
				else if(board[i][j] == 'y'){
					System.out.print("| y ");
				}
				else{
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("  0   1   2   3   4   5   6");
	}
	
	public char[][] getBoard()
	{
		return board;
	}
	
	public boolean getWin()
	{
		return win;
	}
	
	
}