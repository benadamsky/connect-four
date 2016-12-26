/* Copyright (c) 2016, Ben Adamsky */

public class Board {
	
	private int row;
	private int col;
	private char player1;
	private char player2;
	private char[][] board;
	
	public Board() //creates a default board of size 7 columns x 6 rows
	{
		board = new char[6][7];
		this.row = 6;
		this.col = 7;
		for(int x = 0; x < this.row; x++)
			for(int y = 0; y < this.col; y++)
				board[x][y] = ' ';
	}
	
	Board(int row, int col) //creates a board of size row x col
	{
		this.row = row;
		this.col = col;
		if(row <= 0)
			this.row = 6;
		if(col <= 0)
			this.row = 7;
		board = new char[this.row][this.col];
		for(int x = 0; x < this.row; x++)
			for(int y = 0; y < this.col; y++)
				board[x][y] = ' ';
	}

	public int getNumRows() //returns the number of rows in board
	{
		return row;
	}
	
	public int getNumCols() //returns the number of cols in board
	{
		return col;
	}

	public char getPlayerOne() //returns char representing player 1
	{
		return player1;
	}
	public char getPlayerTwo() //returns char representing player 2
	{
		return player2;
	}

	public void setPlayerOne(char o) //sets char representing player 1
	{
		player1 = o;
	}
	public void setPlayerTwo(char t) //sets char representing player 2
	{
		player2 = t;
	}

	public String printBoard()
	{
		String str = "";
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				str+="[" + board[i][j] + "] ";
			}
			str+="\n";
		}
		return str;
	}
	public char getToken(int row, int col) //returns the char representing token at location row,col, '\0' if invalid indices
	{
		char err = '\0';
		if(row>=getNumRows() || row < 0)
			return err;
		if(col>=getNumCols() || col < 0)
			return err;
		return board[row][col];
	}

	public boolean canPlay() //returns true if a token is still able to placed onto the board, false otherwise
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(board[i][j] == ' ')
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean play(int p, int c) //places the appropriate token for player p in column c. returns true if successful, false otherwise.
	{
		for(int i=row-1;i>=0;i--)
		{
			if(board[i][c] == ' ')
			{
				if(p == 1)
				{
					board[i][c] = getPlayerOne();
					return true;
				}
				else if(p == 2)
				{
					board[i][c] = getPlayerTwo();	
					return true;
				}
			}				
		}
		return false;
	}
	
	 // Returns either the ID of the player who has won (1 or 2) OR 0 if the game has ended in a tie OR -1 if nobody has won yet
    public int isFinished() {
        if(canPlay()==false){
            return 0;
        }
        boolean player1wins=false;
        boolean player2wins=false;

        //horizontal check 1
        int player1count=0;
        int player2count=0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if (board[i][j]==player1){
                    player1count++;
                    if (player1count>=4){
                        player1wins=true;
                        return 1;
                    }
                }else{
                    player1count=0;
                }	
            }
        }
        //horizontal check 2
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if (board[i][j]==player2){
                    player2count++;
                    if (player2count>=4){
                        player2wins=true;
                        return 2;

                    }
                }else{
                    player2count=0;
                }
            }
        }

        //Vertical Check 1
        player1count=0;
        player2count=0;
        for(int j=0; j<col; j++)
        {
            for(int i=0; i<row; i++)
            {
                if (board[i][j]==player1)
                {
                    player1count++;
                    if(player1count==4)
                    	return 1;
                }else{
                    player1count=0;
                }	
            }
        }
        
        //Vertical Check 2
        for(int j=0; j<col; j++)
        {
            for(int i=0; i<row; i++)
            {
                if (board[i][j]==player2)
                {
                    player2count++;
                    if(player2count==4)
                    	return 2;      
                }else{
                    player2count=0;
                }
            }
        }
      
        
        //Diagonal Check 1
        int sameLetters = 1;
        char someLetter = ' ';
        char prevLetter = ' ';
        int k = 0;
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                if (k + i > board.length - 1 || j > board[j].length - 1)
                {
                    prevLetter = ' ';
                    break;
                }
                someLetter = board[i+k][j];
                if (someLetter == prevLetter && prevLetter != ' ' && someLetter != ' ')
                {
                    sameLetters++;
                    if (sameLetters == 4)
                    {
                        if (someLetter == getPlayerOne())
                            return 1;
                        if (someLetter == getPlayerTwo())
                            return 2;
                    }
                }
                else 
                {
                    sameLetters = 1;
                }
                k++;
                prevLetter = someLetter;
            }
            k = 0;
            prevLetter = ' ';
        }
        
        //Diagonal Check 2
        sameLetters = 1;
        prevLetter = ' ';
        k = 0;
        for (int i = 1; i < col; i++)
        {
            for (int j = 0; j < row; j++)
            {            
                if (k + i > col - 1 || j > row - 1)
                {
                    prevLetter = ' ';
                    break;
                }   
                someLetter = board[j][i+k];
                if (someLetter == prevLetter && prevLetter != ' ' && someLetter != ' ')
                {
                    sameLetters++;
                    if (sameLetters == 4)
                    {
                        if (someLetter == getPlayerOne())
                            return 1;
                        if (someLetter == getPlayerTwo())
                            return 2;
                    }
                }
                else 
                {
                    sameLetters = 1;
                }
                k++;
                prevLetter = someLetter;
            }
            k = 0;
            prevLetter = ' ';
        }
        
        //Diagonal Check 3
        sameLetters = 1;
        prevLetter = ' ';
        k = 0;    
        for (int i = 0; i < col; i++)
        {
            for (int j = col - 1; j >= 0 ; j--)
            {
                if (k + i > row - 1 || j < 0)
                {
                    prevLetter = ' ';
                    break;
                }
                someLetter = board[i+k][j];
                if (someLetter == prevLetter && prevLetter != ' ' && someLetter != ' ')
                {
                    sameLetters++;
                    if (sameLetters == 4)
                    {
                        if (someLetter == getPlayerOne())
                            return 1;
                        if (someLetter == getPlayerTwo())
                            return 2;
                    }
                }
                else 
                {
                    sameLetters = 1;
                }
                k++;
                prevLetter = someLetter;
            }
            k = 0;
            prevLetter = ' ';   
        }
        
        //Diagonal Check 4
        sameLetters = 1;
        prevLetter = ' ';
        k = 0;  
        for (int i = col - 2; i >= 0; i--)
        {
            for (int j = 0; j < row; j++)
            {
                if (k + i < 0 || j > row - 1)
                {
                    prevLetter = ' ';
                    break;
                }
                someLetter = board[j][i+k];
                if (someLetter == prevLetter && prevLetter != ' ' && someLetter != ' ')
                {
                    sameLetters++;
                    if (sameLetters == 4)
                    {
                        if (someLetter == getPlayerOne())
                            return 1;
                        if (someLetter == getPlayerTwo())
                            return 2;
                    }
                }
                else 
                {
                    sameLetters = 1;
                }              
                k--;
                prevLetter = someLetter;
            }
            k = 0;
            prevLetter = ' ';
        }
        
        if (player1wins==true && player2wins==true){
            return 0;
        }
        if (player1wins==true && player2wins==false){
            return 1;		
        }
        if (player1wins==false && player2wins==true){
            return 2;
        }
        else{
            return -1;
        }

    }

}
