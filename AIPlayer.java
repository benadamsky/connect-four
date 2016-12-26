/* Copyright (c) 2016, Ben Adamsky */

public class AIPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	private int playerID, row, col, lastMove;
	private char pChar, eChar;
	private Board b;
	private boolean firstMove;
	private int[] arr;
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		this.row = row;
		this.col = col;
		this.b = new Board(this.row,this.col);
		this.firstMove=true;
		arr=new int[this.row]; 
		
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		System.out.println("Player last moved " + c);
		lastMove = c;
	}
	
	//returns column of where to play a token
	public int playToken(){
		for(int i=0;i<arr.length;i=(int)(Math.random()*(b.getNumCols()-0)+0))
		{
			if(arr[i] < b.getNumRows())
			{
				arr[i]++;
				return i;
			}
		}
		return 0;
	}
	
	//get this player's id
	public int getPlayerID(){
		return this.playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		for(int i=0;i<arr.length;i++)
			arr[i]=0;
	}
}