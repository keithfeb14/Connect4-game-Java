import java.util.Random;

class Computer extends Game{ //Subclass from game abstract class so it inherits all
  //the methods which it now has to fill in.
	
	public  String getUserInput(){ //Function that takes in user input 
    //if invalid input i.e. less than 0 or greater than 6 throws error. 
		String toReturn = null;
		try{			
			toReturn = input.readLine();
		}
		catch(Exception e){
			
		}
		return toReturn;
	}
  public void placeCounter(char player, int position){ //Place counter function
		boolean placed = false;
		if(player == 'r'){
			for(int i=board.length-1; i>=0; i--){
				if(!placed){
					if(board[i][position] == 'y'){
						// skip
					}
					else if(board[i][position] != 'r'){
						board[i][position] = 'r';
						placed = true;
					}
				}
			}
		}
		else{
			for(int i=board.length-1; i>=0; i--){
				if(!placed){
					if(board[i][position] == 'r'){
						// skip
					}
					else if(board[i][position] != 'y'){
						board[i][position] = 'y';
						placed = true;
					} 
				}
			}
		}
		
	}
        
	public char[][] playGame(char[][] b){ //Function for the computer to play the game
    //can comment out 58 and 59 and uncomment 56 and 57 to have two users to play the game
		
			board=b;
			boolean hasWon = false;
			int count = 0;
			int move;
			// check horizontal
		
			    //userInput = getUserInput();
				//move = Integer.parseInt(userInput);
				Random rand=new Random();
				move=(rand.nextInt(7));
				placeCounter('y',move);

				printBoard();
				hasWon = false;
				count = 0;
				// check horizontal for win
				for(int i=0; i<board.length; i++){
					for(int j=0; j<board[i].length; j++){
						if(board[i][j] == 'y'){
							count = count + 1;
							if(count >= 4){
								hasWon = true;
							}
						}
						else{
							count=0;
						}
					}
					count = 0;
				}
				// check vertical for win
				count = 0;
				for(int i=0; i<board[0].length; i++){
					for(int j=0; j<board.length; j++){
						if(board[j][i] == 'y'){
							count = count + 1;
							if(count >= 4){
								hasWon = true;
							}
						}
						else{
							 count=0;
						}
					}
					count = 0;
				}
				
				//check upward diagonal for win
			count = 0;
		for(int row = 3; row < board.length; row++){
			for(int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == 'y'   && 
					board[row-1][col+1] == 'y' &&
					board[row-2][col+2] == 'y' &&
					board[row-3][col+3] == 'y'){
					hasWon = true;
				}
			}
		}
		
		//check downward diagonal for win
		count = 0;
		for(int row = 0; row < board.length - 3; row++){
			for(int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == 'y'   && 
					board[row+1][col+1] == 'y' &&
					board[row+2][col+2] == 'y' &&
					board[row+3][col+3] == 'y'){
					hasWon = true;
				}
			}
		}
				
				if(hasWon){ //If computer has won print this statement 
					win = true;
					System.out.println("Player Yellow Has Won!!!");
				}
				
				
				return board;
			}
			
		
		
	
	
}