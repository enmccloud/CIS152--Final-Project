/**
 * GameBoard Class
 * 
 * @author Nikki McCloud
 * @version 1.0
 */
package View;

public class GameBoard {

	// Constants for height and width of board.
	public final static int WIDTH = 11;
	public final static int HEIGHT = 20;
	
	private javax.swing.JTextArea BoardPanel;

	// 2D Array PlayingField (game board)
	private int[][] playingField = new int[20][11];

	/**
	 * Default No Argument Constructor
	 */
    public GameBoard() {
       
    }

	/**
	 * CreateGameBoard Method
	 * 
	 * @param PlayingField
	 * @return creating new playing field.
	 */
	public int[][] createGameBoard() {
		return playingField;
	}

	/**
	 * DropBlock Method
	 * 
	 * @param block
	 * @param row
	 * @param column
	 * @param dropTest
	 * @param playingField
	 * @return adds a block to the board.
	 */
	public int dropBlock(int[][] block, int row, int column, boolean dropTest) {
		int startColumn = column;
		for (int r = 0; r < block.length; r++) {
			for (int c = 0; c < block[0].length; c++) {
				try {
					if (this.playingField[row][column] != 0 && block[r][c] != 0) {
						return 1;
					} else {
						if (dropTest == false) {
							this.playingField[row][column] |= block[r][c];
						}
						column++;
					}
				} catch (java.lang.ArrayIndexOutOfBoundsException ex) {
					return 1;
				}
			}
			row++;
			column = startColumn;
		}
		return 0;
	}

	/**
	 * ClearBlockLine Method
	 * 
	 * @param PlayingField
	 * @param Height
	 * @param Width
	 * @param line
	 * @return clears line when line is made.
	 */
	private void clearBlockLine(int line) {
		if (line < 0 || line >= HEIGHT) {
			return;
		}
		for (; line > 0; line--) {
			for (int x = 0; x < WIDTH; x++) {
				playingField[line][x] = playingField[line - 1][x];
			}
		}
		for (int x = 0; x < WIDTH; x++) {
			playingField[0][x] = 0;
		}
	}

	/**
	 * GameOver Method
	 * 
	 * @param PlayingField
	 * @return if board is full game over.
	 */
	public boolean gameOver() {
		for (int i = 0; i < playingField[0].length; i++) {
			if (playingField[0][i] != 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * PlayerPoints Method
	 * 
	 * @param PlayingField
	 * @return calculates points for lines cleared.
	 */
	public int playerPoints() {
		int linesCleared = 0;
		int blocksPerRow = 0;

		for (int row = 0; row < playingField.length; row++) {
			for (int column = 0; column < playingField[0].length; column++) {
				if (playingField[row][column] != 0) {
					blocksPerRow++;
				}
			}
			if (blocksPerRow >= playingField[0].length) {
				clearBlockLine(row);
				linesCleared++;
			}
			blocksPerRow = 0;
		}
		return linesCleared;
	}
	
    /**
     * Set Output Method
     * 
     * @param toOutput 
     * -- Updates the game window with parameter string
     */
    public void setOutput(String toOutput){
         BoardPanel.setText(toOutput);
         this.display(true);
    }
    
   public void display(boolean display) {
   }
}
