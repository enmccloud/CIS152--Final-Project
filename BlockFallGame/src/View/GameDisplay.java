/**
 * GameDisplay Class
 * 
 * @author Nikki McCloud
 * @version 1.0
 */
package View;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import Model.Blocks;

public class GameDisplay extends Canvas {

	// Not sure if needed? But was recommended by Eclipse!
	private static final long serialVersionUID = 1L;

	// Used to hold and create displays/graphics
	private Image container;
	private Graphics newDesign;
	private InterfaceType mode;
	private GameBoard window;

	// Variables set up as 2D Arrays
	private int[][] block;
	private int[][] nextBlock;
	private int[][] board;

	// Intializing Variables for Locations
	private int colMult = 0;
	private int rowMult = 0;
	private int row;
	private int col;
	private boolean gameOver = false;
	private boolean pause = false;
	private int linesCleared = 0;
	private long score = 0;
	private String blockRotation = "";
	private int level = 0;
	private int levelTimer = 0;

	// Constants for block size.
	private final static int BLOCK_LENGTH = 16;
	private static final int BLOCKSIZE = 14;

	// Constants for setting up coordinates for all aspects
	// such as playing field, padding around the playing field
	// rows/columns, etc.
	private static final int FIELDXAXIS = 1;
	private static final int FIELDYAXIS = 1;

	private static final int FIELDWIDTH = GameBoard.WIDTH * BLOCK_LENGTH + 5;
	private static final int FIELDHEIGHT = GameBoard.HEIGHT * BLOCK_LENGTH + 3;

	private static final int PADDINGXAXIS = GameBoard.WIDTH * BLOCK_LENGTH + 10;
	private static final int PADDINGYAXIS = 1;

	private static final int PADDINGWIDTH = 120;
	private static final int PADDINGHEIGHT = 80;

	private static final int XAXISDATA = GameBoard.WIDTH * BLOCK_LENGTH + 10;
	private static final int YAXISDATA = 85;

	private static final int WIDTHDATA = 120;
	private static final int HEIGHTDATA = 239;

	private static final int XAXISSCORE = GameBoard.WIDTH * BLOCK_LENGTH + 12;
	private static final int YAXISSCORE = 105;

	private static final int XAXISROWS = GameBoard.WIDTH * BLOCK_LENGTH + 12;
	private static final int YAXISROWS = 125;

	private static final int ROTATIONXLOC = GameBoard.WIDTH * BLOCK_LENGTH + 12;
	private static final int ROTATIONYLOC = 145;

	private static final int LEVELXLOC = GameBoard.WIDTH * BLOCK_LENGTH + 12;
	private static final int LEVELYLOC = 165;

	private static final int XTIMEREMAINING = GameBoard.WIDTH * BLOCK_LENGTH + 12;
	private static final int YTIMEREMAINING = 185;

	/**
	 * Default No Argument Constructor
	 */
	public GameDisplay() {
	}

	/**
	 * Getter for Block
	 * 
	 * @return block
	 */
	public int[][] getBlock() {
		return block;
	}

	/**
	 * Setter for Block
	 * 
	 * @param block
	 */
	public void setBlock(int[][] block) {
		this.block = block;
	}

	/**
	 * Getter for colMult
	 * 
	 * @return colMult
	 */
	public int getColMult() {
		return colMult;
	}

	/**
	 * Getter for nextBlock
	 * 
	 * @return nextBlock
	 */
	public int[][] getNextBlock() {
		return nextBlock;
	}

	/**
	 * Setter for nextBlock
	 * 
	 * @param nextBlock
	 */
	public void setNextBlock(int[][] nextBlock) {
		this.nextBlock = nextBlock;
	}

	/**
	 * Getter for board
	 * 
	 * @return board
	 */
	public int[][] getBoard() {
		return board;
	}

	/**
	 * Setter for board
	 * 
	 * @param board
	 */
	public void setBoard(int[][] board) {
		this.board = board;
	}

	/**
	 * Setter for colMult
	 * 
	 * @param colMult
	 */
	public void setColMult(int colMult) {
		this.colMult = colMult;
	}

	/**
	 * Getter for rowMult
	 * 
	 * @return rowMult
	 */
	public int getRowMult() {
		return rowMult;
	}

	/**
	 * Setter for rowMult
	 * 
	 * @param rowMult
	 */
	public void setRowMult(int rowMult) {
		this.rowMult = rowMult;
	}

	/**
	 * Getter for row
	 * 
	 * @return row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Setter for row
	 * 
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Getter for col
	 * 
	 * @return col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Setter for col
	 * 
	 * @param col
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * Getter for gameOver
	 * 
	 * @return gameOver
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * Setter for gameOver
	 * 
	 * @param gameOver
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	/**
	 * Getter for pause
	 * 
	 * @return pause
	 */
	public boolean getPause() {
		return pause;
	}

	/**
	 * Setter for pause
	 * 
	 * @param pause
	 */
	public void setPause(boolean pause) {
		this.pause = pause;
	}

	/**
	 * Getter for linesCleared
	 * 
	 * @return linesCleared
	 */
	public int getLinesCleared() {
		return linesCleared;
	}

	/**
	 * Setter for linesCleared
	 * 
	 * @param linesCleared
	 */
	public void setLinesCleared(int linesCleared) {
		this.linesCleared = linesCleared;
	}

	/**
	 * Getter for score
	 * 
	 * @return score
	 */
	public long getScore() {
		return score;
	}

	/**
	 * Setter for score
	 * 
	 * @param score
	 */
	public void setScore(long score) {
		this.score = score;
	}

	/**
	 * Getter for blockRotation
	 * 
	 * @return blockRotation
	 */
	public String getBlockRotation() {
		return blockRotation;
	}

	/**
	 * Setter for blockRotation
	 * 
	 * @param blockRotation
	 */
	public void setBlockRotation(String blockRotation) {
		this.blockRotation = blockRotation;
	}

	/**
	 * Getter for level
	 * 
	 * @return level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Setter for level
	 * 
	 * @param level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Getter for levelTimer
	 * 
	 * @return levelTimer
	 */
	public int getLevelTimer() {
		return levelTimer;
	}

	/**
	 * Setter for levelTimer
	 * 
	 * @param levelTimer
	 */
	public void setLevelTimer(int levelTimer) {
		this.levelTimer = levelTimer;
	}

	/**
	 * Paint Directions Method
	 * 
	 * @param column
	 * @param row
	 * @return where to paint
	 */
	public void paintDirections(int column, int row) {
		this.colMult = column;
		this.rowMult = row;
	}

	/**
	 * Update Method
	 * 
	 * @param g
	 * @return update paint
	 */
	public void update(Graphics g) {
		this.paint(g);
	}

	/**
	 * Paint Method
	 * 
	 * @param g
	 * @return creating visuals for display
	 */
	public void paint(Graphics g) {

		if (container == null) {
			container = createImage(this.getWidth(), this.getHeight());
		}

		// Creating display with background, borders, sub sections, text, etc.
		newDesign = container.getGraphics();
		newDesign.clearRect(0, 0, this.getWidth(), this.getHeight());
		newDesign.setColor(Color.DARK_GRAY);
		newDesign.fillRect(0, 0, this.getWidth(), this.getHeight());
		newDesign.setColor(Color.GREEN);
		newDesign.drawRect(FIELDXAXIS, FIELDYAXIS, FIELDWIDTH, FIELDHEIGHT);
		newDesign.drawRect(PADDINGXAXIS, PADDINGYAXIS, PADDINGWIDTH, PADDINGHEIGHT);
		newDesign.drawRect(XAXISDATA, YAXISDATA, WIDTHDATA, HEIGHTDATA);

		// Creating a Block (design)
		int row = BLOCK_LENGTH * rowMult + 3;
		int column = BLOCK_LENGTH * colMult;

		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[0].length; j++) {
				if (block[i][j] != 0) {
					newDesign.setColor(Blocks.blockColor(block[i][j]));
					newDesign.drawRect(column + 5, row, BLOCKSIZE, BLOCKSIZE);
				}
				column += BLOCK_LENGTH;
			}
			column = BLOCK_LENGTH * colMult;
			row += BLOCK_LENGTH;

		}

		// Creating the Board
		row = 3;
		column = 0;

		for (int k = 0; k < board.length; k++) {
			for (int l = 0; l < board[0].length; l++) {
				if (board[k][l] != 0) {
					newDesign.setColor(Blocks.blockColor(board[k][l]));
					newDesign.fillRect(column + 5, row, BLOCKSIZE, BLOCKSIZE);
				}
				column += BLOCK_LENGTH;
			}
			column = 0;
			row += BLOCK_LENGTH;
		}
		newDesign.setColor(Color.GREEN);

		// Setting up Position for Next Block Drop
		int middleRow = (PADDINGHEIGHT - (this.nextBlock.length * BLOCK_LENGTH)) / 2;
		int middleColumn = (PADDINGWIDTH - (this.nextBlock[0].length * BLOCK_LENGTH)) / 2;
		int nextRow = 2 + middleRow;
		int nextColumn = GameBoard.WIDTH * BLOCK_LENGTH + 5 + 5 + middleColumn;

		// Creating Next Block
		for (int i = 0; i < this.nextBlock.length; i++) {
			for (int j = 0; j < this.nextBlock[0].length; j++) {
				if (this.nextBlock[i][j] != 0) {
					newDesign.setColor(Blocks.blockColor(this.nextBlock[i][j]));
					newDesign.drawRect(nextColumn, nextRow, BLOCKSIZE, BLOCKSIZE);
				}
				nextColumn += BLOCK_LENGTH;
			}
			nextColumn = GameBoard.WIDTH * BLOCK_LENGTH + 10 + middleColumn;
			nextRow += BLOCK_LENGTH;
		}

		// Side Panel Data Display
		newDesign.setColor(Color.MAGENTA);

		newDesign.drawString("Rotate Block: " + this.blockRotation, ROTATIONXLOC, ROTATIONYLOC);
		newDesign.drawString("Level: " + this.level, LEVELXLOC, LEVELYLOC);
		newDesign.drawString("Next level in: " + levelTimer, XTIMEREMAINING, YTIMEREMAINING);

		newDesign.drawString("Cleared Lines: " + this.linesCleared, XAXISROWS, YAXISROWS);

		if (score >= 1000) {
			newDesign.drawString("HIGH SCORE! Total score: ", XAXISSCORE, YAXISSCORE);
		} else if (score == 500) {
			newDesign.drawString("Great Job! Total score: ", XAXISSCORE, YAXISSCORE); // <-Number of the beast
		} else {
			newDesign.drawString("Total score: " + score, XAXISSCORE, YAXISSCORE);
		}

		// Creating Pause Note
		if (this.pause == true) {
			newDesign.setFont(new Font("", Font.BOLD, 13));
			newDesign.setColor(Color.MAGENTA);
			newDesign.drawString("PAUSED", GameBoard.WIDTH * BLOCK_LENGTH + 45, 250);
		}

		// Creating Game Over Note
		if (this.gameOver == true) {
			newDesign.setFont(new Font("", Font.BOLD, 13));
			newDesign.setColor(Color.BLUE);
			newDesign.drawString("GAME OVER! Play Again?", GameBoard.WIDTH * BLOCK_LENGTH + 32, 250);
		}

		// Clean Up
		newDesign.dispose();
		g.drawImage(container, 0, 0, this);
	}

	/**
	 * Output Score Method
	 * 
	 * @param score
	 * @return score output
	 */
	public void outputScore(String score) {
		switch (mode) {
		case CONSOLE:
			System.out.println(score);
			break;
		case WINDOW:
			window.setOutput(score);
			break;
		default:
			throw new IllegalArgumentException("Invalid Output.");
		}
	}
}
