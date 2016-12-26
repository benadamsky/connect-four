/* Copyright (c) 2016, Ben Adamsky */

import java.io.IOException;

public class ConnectFour{
	
	
	public static void main(String[] args){
		
		//Create new board object
		
		//Set player tokens for player 1 and player 2
		//Create Player objects
		//Note, the code below works because of the interface Player. All classes that "implement" Player can be
		// typed as Player. Makes switching from Human to AI Players really easy. For a challenge, you might
		// consider:
		//		1. asking the user whether he/she wants to play against a human or a computer
		//		2. implementing multiple AI players (easy, med, hard) that the user can choose to play against
		Board b = new Board();
		Player p1 = new HumanPlayer(1,6,7);
		b.setPlayerOne('A');
		//Player p2 = new HumanPlayer(1,6,7); //comment this line when testing AIPlayer
		
		Player p2 = new AIPlayer(2,6,7); //uncomment this line when testing AIPlayer
		b.setPlayerTwo('B');
		
		//Print your empty board
		System.out.print(b.printBoard());
		
		
	    CFGUI gui = new CFGUI(b,ChipColor.BLACK,ChipColor.RED);
	    
	    do
	    {
	    b.play(p1.getPlayerID(), p1.playToken());
	    gui.redraw();
	    if(b.isFinished()==-1)
	    {
	    	b.play(p2.getPlayerID(), p2.playToken());
	    	gui.redraw();
	    }
	    }while(b.isFinished()==-1);
	    System.out.print(b.printBoard());
	    
	    if(b.isFinished()==0)
	    	gui.gameOver(-1);
	    else
	    	gui.gameOver(b.isFinished());
		
	    System.out.println("Game over! Type any key and press enter to close GUI menu...");
	    try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    gui.close();
		
		//WHILE the board is still playable
		//	get a column to play from player 1
		//	play that token on the board
		//  print the board
		//		has anyone won yet?
		// do the above for player 2
		
		// Get the status code from the board (isFinished())
		
		// Print out the results of the game
		
		
	}
	
}