/* Copyright (c) 2016, Ben Adamsky */

public class HumanPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	private int playerID, row, col;
	private Board board;
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public HumanPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		this.row = row;
		this.col = col;
		this.board = new Board(this.row,this.col);
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		System.out.println("Player last moved " + c);
	}
	
	//returns column of where to play a token
	public int playToken(){
		System.out.println("Enter column: ");
		int c = IO.readInt();
		while(c < 0 || c >= col)
		{
			System.out.println("Enter column: ");
			c = IO.readInt();
		}
		while(board.play(getPlayerID(),c) == false)
		{
			System.out.println("Enter column: ");
			c = IO.readInt();
		}
		return c;
	}
	
	//get this player's id
	public int getPlayerID(){
		return this.playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		this.playerID = 0;
		board = new Board(this.row,this.col);
	}

	
}