class Player extends Game {
  
	public  String getUserInput(){ // Subclass from game abstract class so it inherits all the methods which it now has to fill in.
		String toReturn = null; //Function that takes in user input if invalid input i.e. less than 0 or greater than 6 throws error. 
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
        
	public char[][] playGame(char[][] b){ //Function for the user to play the game 
		
			// player 1
			board=b;
			String userInput = getUserInput();
			int move = Integer.parseInt(userInput); //Input parsed though and made into an integer
			placeCounter('r',move);


			boolean hasWon = false;
			int count = 0;
			// check horizontal for win
			for(int i=0; i<board.length; i++){
				for(int j=0; j<board[i].length; j++){
					if(board[i][j] == 'r'){
						count = count + 1;
						if(count >= 4){
							hasWon = true;
						}
					}
					else{
						count = 0;
					}
				}
				count=0;
			}
			// check vertical for win
			count = 0;
			for(int i=0; i<board[0].length; i++){
				for(int j=0; j<board.length; j++){
					if(board[j][i] == 'r'){
						count = count + 1;
						if(count == 4){
							hasWon = true;
						}
					}
					else{
						count = 0;
					}
				}
				count=0;
			}
			
		    // check upward diagonal for win
		for(int row = 3; row < board.length; row++){
			for(int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == 'r'   && 
					board[row-1][col+1] == 'r' &&
					board[row-2][col+2] == 'r' &&
					board[row-3][col+3] == 'r'){
					hasWon = true;
				}
			}
		}
		
		//check downward diagonal for win
		for(int row = 0; row < board.length - 3; row++){
			for(int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == 'r'   && 
					board[row+1][col+1] == 'r' &&
					board[row+2][col+2] == 'r' &&
					board[row+3][col+3] == 'r'){
					hasWon = true;
				}
			}
		}
		    
			if(hasWon){ //If player has won print this message
				win = true;
				System.out.println("Player Red Has Won!!!");
			}
			
			return board;
		}
		
	
}