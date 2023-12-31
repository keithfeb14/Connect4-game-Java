public class Main {
	
	
	void playGame(){
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in") ;
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
		
		Computer comp=new Computer(); //Create new computer player
		Player pl=new Player(); //Create new user player 
		char[][] b=pl.getBoard(); //Create new board 

		pl.printBoard();
		while(!comp.getWin() && !pl.getWin())
		{
			 b=pl.playGame(b);
			 if(!pl.getWin())
				 b=comp.playGame(b);
			
		}
		
		
	}
        
        public static void main(String[] args)
        {
            Main obj = new Main();
            obj.playGame();
        }

  
	
}