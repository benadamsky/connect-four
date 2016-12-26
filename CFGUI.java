/* Copyright (c) 2016, Ben Adamsky */

import java.awt.*;
import javax.swing.*;

/**
 * A CFGUI is a graphical window designed for the game of connect four.
 * It knows how to display player names, and the board.
 * MADE IT SO TOP ROW IS board[6] and last row is board[0]
 */
public class CFGUI extends JFrame
{
	private Board board;
	private CFPanel panel;
	private Color p1c, p2c;
	
	
	
	/**
	 * Create a ConnectFourBoardWindow for the given board.
	 */
	public CFGUI(Board board, ChipColor p1color, ChipColor p2color)
	{
		this.board = board;

		this.setTitle("Connect Four");
		int x = board.getNumCols() *100+ 30;
		int y = board.getNumRows()*100+150;
		this.setSize(x, y);
		
		p1c = p1color.getColor();
		p2c = p2color.getColor();
		
		
		Container content = getContentPane();
		content.setLayout(null);

		panel = new CFPanel();
		content.add(panel);
		panel.setBounds(0, 0, x, y);
		panel.setBackground(Color.yellow);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}

	/**
	 * Re-draw the window -
	 * this method should be called whenever there is a change to the board.
	 */
	public void redraw()
	{
		this.repaint();
		/*try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{
			// should never happen
		}*/
	}
	
	/**
	 * Prints which player one or tie if tie
	 * id = 1 if player 1 won, 2 if player 2 won, -1 if its a tie.
	 */
	public void gameOver(int id){
	    if(panel!=null){
	        panel.printWin(id);
	    }
	}
	
	/**
	 * Close the window (remove it from the screen) -
	 * this method should be called when the game ends.
	 */
	public void close()
	{
		this.setVisible(false);
		this.dispose();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	// inner classes
	//////////////////////////////////////////////////////////////////////////////////////////////

	private class CFPanel extends JPanel
	{
		
		public void printWin(int id){
		    if(id==0){
		        GIO.displayMessage("It's a Tie!");
		    }
		    else{
		        GIO.displayMessage("Player "+id+ " wins!");
		    }
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			if (CFGUI.this.board == null)
			{
				return;
			}
			
			Board board = CFGUI.this.board;
			char p1 = board.getPlayerOne();
			char p2 = board.getPlayerTwo();
			
			int rowMax = board.getNumRows();
			if(rowMax<1){
			    GIO.displayMessage("Error: Board has no rows.");
				System.exit(1);
			}
			int colMax = board.getNumCols(); 
			if(colMax<1){
			    GIO.displayMessage("Error: Board has no columns.");
			    System.exit(1);
			}
			for(int row = 0; row<rowMax; row++){
				for(int col = 0; col<colMax; col++){
				    char currSpace = board.getToken(row,col);
				    
					if(currSpace==p1){
						g.setColor(p1c);
					}
					else if(currSpace==p2){
						g.setColor(p2c);
					}
					else{
						g.setColor(Color.white);
					}
					g.fillOval(col*100 +10, (row)*100 +10, 90, 90);
				}
			}
			for(int col = 0; col<colMax; col++){
				g.setColor(Color.BLACK);
				g.setFont(new Font("SansSerif", Font.BOLD, 30));
				g.drawString(""+col, col*100 +50,rowMax*100+50);
			}
			
		}
	}
}
