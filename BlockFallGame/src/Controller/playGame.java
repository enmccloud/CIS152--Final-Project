/**************************************************************
* Name        : Block Fall Game CIS 152 Data Structure Final
* Author      : Nikki McCloud
* Created     : 12/15/2020
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program allows the user to stack blocks in
* 				a line in order to score points.
*               Input:  Used keypad to direct blocks.
*               Output: Score points and progress or game over.
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/
package Controller;

import java.awt.event.WindowAdapter;

import javax.swing.WindowConstants;

import Model.Blocks;
import Model.GameLogic;
import View.GameBoard;

public class playGame {

	public static void main(String[] args) {

		// Create a new game
		GameLogic play = new GameLogic();

		// On exit event close the window
		play.addWindowListener(new WindowAdapter() {
			@SuppressWarnings("unused")
			public void windowClosing() {
				System.exit(0);
			}
		});

		// Size of the window
		play.setSize(Blocks.BLOCK_SIZE * GameBoard.WIDTH + 140, Blocks.BLOCK_SIZE * GameBoard.HEIGHT + 40);
		play.setVisible(true);
		play.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		play.displayHighScores(null);
	}
}
