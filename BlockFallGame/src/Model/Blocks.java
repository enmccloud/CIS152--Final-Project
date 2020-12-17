/**
 * Blocks Class
 * @author Nikki McCloud
 * @version 1.0
 */
package Model;

import java.awt.Color;
import View.GameBoard;

public class Blocks {

	// Constant Block Size
	public static final int BLOCK_SIZE = 16;

	// Variables set up as 2D Arrays
	// No Block Shape
	private int[][] NoBlock = { { 0, 0, 0 }, { 0, 0, 0 } };

	// Block Shape "I"
	public int[][] IBlock = { { 1 }, { 1 }, { 1 }, { 1 } };

	// Block Shape "J"
	protected int[][] JBlock = { { 2, 0, 0 }, { 2, 2, 2 } };

	// Block Shape "L"
	protected int[][] LBlock = { { 0, 0, 3 }, { 3, 3, 3 } };

	// Block Shape "O"
	public int[][] OBlock = { { 4, 4 }, { 4, 4 } };

	// Block Shape "S"
	protected int[][] SBlock = { { 0, 5, 5 }, { 5, 5, 0 } };

	// Block Shape "T"
	protected int[][] TBlock = { { 0, 6, 0 }, { 6, 6, 6 } };

	// Block Shape "Z"
	protected int[][] ZBlock = { { 7, 7, 0 }, { 0, 7, 7 } };

	// 2D Array Variable holds block location
	// Starting Block Locations
	private int[][] blockCoordinates;
	private int blockColumn = 0;
	private int blockRow = 5;

	/**
	 * Default No Argument Constructor
	 */
	public Blocks() {
	}
	
	/**
	 * Getter for NoBlock
	 * 
	 * @return NoBlock
	 */
	public int[][] getNoBlock() {
		return NoBlock;
	}

	/**
	 * Setter for NoBlock
	 * 
	 * @param NoBlock
	 */
	public void setNoBlock(int[][] noBlock) {
		NoBlock = noBlock;
	}

	/**
	 * Getter for IBlock
	 * 
	 * @return IBlock
	 */
	public int[][] getIBlock() {
		return IBlock;
	}

	/**
	 * Setter for IBlock
	 * 
	 * @param IBlock
	 */
	public void setIBlock(int[][] iBlock) {
		IBlock = iBlock;
	}

	/**
	 * Getter for JBlock
	 * 
	 * @return JBlock
	 */
	public int[][] getJBlock() {
		return JBlock;
	}

	/**
	 * Setter for JBlock
	 * 
	 * @param JBlock
	 */
	public void setJBlock(int[][] jBlock) {
		JBlock = jBlock;
	}

	/**
	 * Getter for LBlock
	 * 
	 * @return LBlock
	 */
	public int[][] getLBlock() {
		return LBlock;
	}

	/**
	 * Setter for LBlock
	 * 
	 * @param LBlock
	 */
	public void setLBlock(int[][] lBlock) {
		LBlock = lBlock;
	}

	/**
	 * Getter for OBlock
	 * 
	 * @return OBlock
	 */
	public int[][] getOBlock() {
		return OBlock;
	}

	/**
	 * Setter for OBlock
	 * 
	 * @param OBlock
	 */
	public void setOBlock(int[][] oBlock) {
		OBlock = oBlock;
	}

	/**
	 * Getter for SBlock
	 * 
	 * @return SBlock
	 */
	public int[][] getSBlock() {
		return SBlock;
	}

	/**
	 * Setter for SBlock
	 * 
	 * @param SBlock
	 */
	public void setSBlock(int[][] sBlock) {
		SBlock = sBlock;
	}

	/**
	 * Getter for TBlock
	 * 
	 * @return TBlock
	 */
	public int[][] getTBlock() {
		return TBlock;
	}

	/**
	 * Setter for TBlock
	 * 
	 * @param TBlock
	 */
	public void setTBlock(int[][] tBlock) {
		TBlock = tBlock;
	}

	/**
	 * Getter for ZBlock
	 * 
	 * @return ZBlock
	 */
	public int[][] getZBlock() {
		return ZBlock;
	}

	/**
	 * Setter for ZBlock
	 * 
	 * @param ZBlock
	 */
	public void setZBlock(int[][] zBlock) {
		ZBlock = zBlock;
	}

	/**
	 * Getter for BlockCoordinates
	 * 
	 * @return blockCoordinates
	 */
	public int[][] getBlockCoordinates() {
		return blockCoordinates;
	}

	/**
	 * Setter for BlockCoordinates
	 * 
	 * @param blockCoordinates
	 */
	public void setBlockCoordinates(int[][] blockCoordinates) {
		this.blockCoordinates = blockCoordinates;
	}

	/**
	 * Getter for BlockColumn
	 * 
	 * @return blockColumn
	 */
	public int getBlockColumn() {
		return blockColumn;
	}

	/**
	 * Setter for BlockColumn
	 * 
	 * @param blockColumn
	 */
	public void setBlockColumn(int blockColumn) {
		this.blockColumn = blockColumn;
	}

	/**
	 * Getter for BlockRow
	 * 
	 * @return blockRow
	 */
	public int getBlockRow() {
		return blockRow;
	}

	/**
	 * Setter for BlockRow
	 * 
	 * @param blockRow
	 */
	public void setBlockRow(int blockRow) {
		this.blockRow = blockRow;
	}

	/**
	 * Get Falling Block Method
	 * 
	 * @return blockCoordinates
	 */
	public int[][] getFallingBlock() {
		return blockCoordinates;
	}

	/**
	 * BlockColor Method
	 * 
	 * @param Colors
	 * @return adding colors to blocks.
	 */
	public static Color blockColor(int colors) {
		switch (colors) {
		case 1:
			return Color.GREEN;
		case 2:
			return Color.MAGENTA;
		case 3:
			return Color.PINK;
		case 4:
			return Color.CYAN;
		case 5:
			return Color.YELLOW;
		case 6:
			return Color.BLUE;
		case 7:
			return Color.RED;
		}
		return null;
	}

	/**
	 * Select Block
	 * 
	 * @param IBlock
	 * @param JBlock
	 * @param LBlock
	 * @param OBlock
	 * @param SBlock
	 * @param TBlock
	 * @param ZBlock
	 * @return Random Block
	 */
	public int[][] getRandomPiece() {

		int RandomNo = (int) (0 + Math.random() * 7);

		switch (RandomNo) {
		case 0:
			this.blockCoordinates = IBlock;
			return IBlock;
		case 1:
			this.blockCoordinates = JBlock;
			return JBlock;
		case 2:
			this.blockCoordinates = LBlock;
			return LBlock;
		case 3:
			this.blockCoordinates = OBlock;
			return OBlock;
		case 4:
			this.blockCoordinates = SBlock;
			return SBlock;
		case 5:
			this.blockCoordinates = TBlock;
			return TBlock;
		case 6:
			this.blockCoordinates = ZBlock;
			return ZBlock;
		default:
			return null;
		}
	}

	/**
	 * Get Coordinates of Block in Column
	 * 
	 * @return blockColumn
	 */
	public int getColumnCoordinates() {
		return blockColumn;
	}

	/**
	 * Get Coordinates of Block in Row
	 * 
	 * @return blockRow
	 */
	public int getRowCoordinates() {
		return blockRow;
	}

	/**
	 * Pivot Block Right
	 * 
	 * @param blockCoordinates
	 * @param blockColumn
	 * @return Pivot Block 90 Degrees to the Right
	 */
	public int[][] pivotBlockRight(boolean pivotTest) {

		// Swaps height and width and stores in a 2d array
		int width = this.blockCoordinates.length;
		int height = this.blockCoordinates[0].length;
		int[][] pivot90Degrees = new int[height][width];

		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				pivot90Degrees[row][column] = this.blockCoordinates[width - column - 1][row];
			}
		}
		// Ensures it within Board Boundaries
		if (this.blockColumn + width > GameBoard.WIDTH) {
			this.blockColumn = GameBoard.WIDTH - width;
		}
		if (pivotTest == false) {
			this.blockCoordinates = pivot90Degrees;
		}
		return pivot90Degrees;
	}

	/**
	 * Pivot Block Left Method
	 * 
	 * @param blockCoordinates
	 * @param blockColumn
	 * @return Pivot Block Left- 270 Degrees
	 */
	public int[][] pivotBlockLeft(boolean pivotTest) {

		// Swaps height and width and stores in a 2d array
		int width = this.blockCoordinates.length;
		int height = this.blockCoordinates[0].length;
		int[][] pivot270Degrees = new int[height][width];

		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				pivot270Degrees[row][column] = this.blockCoordinates[column][height - row - 1];
			}
		}
		// Ensures it within Board Boundaries
		if (this.blockColumn + width > GameBoard.WIDTH) {
			this.blockColumn = GameBoard.WIDTH - width;
		}
		if (pivotTest == false) {
			this.blockCoordinates = pivot270Degrees;
		}
		return pivot270Degrees;
	}

	/**
	 * Push Block Down
	 * 
	 * @param blockCoordinates
	 * @param blockRow
	 * @return move block down (if room to move).
	 */
	public int pushDown() {
		if (blockCoordinates.length + this.blockColumn < GameBoard.HEIGHT) {
			this.blockRow++;
			return 1;
		}
		return 0;
	}

	/**
	 * Move Block Side To Side
	 * 
	 * @param blockCoordinates
	 * @param blockColumn
	 * @return move block left or right
	 */
	public void moveSideToSide(boolean left, boolean right) {

		if (left == true && right == false) {
			if (this.blockColumn > 0) {
				this.blockColumn--;
			}
		} else if (left == false && right == true) {

			// Ensures it within Board Boundaries
			if (this.blockColumn + blockCoordinates[0].length < GameBoard.WIDTH) {
				this.blockColumn++;
			}
		}
	}
}
