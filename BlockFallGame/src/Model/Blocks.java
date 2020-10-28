/**
 * Blocks Class
 * @author Nikki McCloud
 * @version 1.0
 */
package Model;
import java.awt.Color;

public class Blocks {
	
	//Constant Block Size
	public static final int Block_Size = 16;
	
	//Variables set up as 2D Arrays 
	//No Block Shape
	private int[][] NoBlock = {{0,0,0},
			   				   {0,0,0}};
	
	//Block Shape "I"
	public int[][] IBlock = {{1},
							  {1},
							  {1},
							  {1}};
	
	//Block Shape "J"
	protected int [][] JBlock = {{2,0,0},
							   {2,2,2}};
	
	//Block Shape "L"
	protected int [][] LBlock = {{0,0,3},
            				   {3,3,3}};
	
	//Block Shape "O"
	public int [][] OBlock = {{4,4},    
            				   {4,4}};
	
	//Block Shape "S"
	protected int [][] SBlock = {{0,5,5},
           					   {5,5,0}};
	
	//Block Shape "T"
	protected int [][] TBlock = {{0,6,0},
            				   {6,6,6}};
	
	//Block Shape "Z"
	protected int [][] ZBlock = {{7,7,0},
            				   {0,7,7}};

	/**
	 * Default No Argument Constructor
	 */
	public Blocks() {
	}

	/**
     * Getter for NoBlock
     * @return NoBlock
     */
	 public int[][] getNoBlock() {
		return NoBlock;
	}

	/**
	 * Setter for NoBlock
	 * @param NoBlock
	 */
	public void setNoBlock(int[][] noBlock) {
		NoBlock = noBlock;
	}

	/**
     * Getter for IBlock
     * @return IBlock
     */
	public int[][] getIBlock() {
		return IBlock;
	}

    /**
     * Setter for IBlock
     * @param IBlock
     */
	public void setIBlock(int[][] iBlock) {
		IBlock = iBlock;
	}

	 /**
     * Getter for JBlock
     * @return JBlock
     */
	public int[][] getJBlock() {
		return JBlock;
	}

    /**
     * Setter for JBlock
     * @param JBlock
     */
	public void setJBlock(int[][] jBlock) {
		JBlock = jBlock;
	}

	 /**
     * Getter for LBlock
     * @return LBlock
     */
	public int[][] getLBlock() {
		return LBlock;
	}

    /**
     * Setter for LBlock
     * @param LBlock
     */
	public void setLBlock(int[][] lBlock) {
		LBlock = lBlock;
	}

	 /**
     * Getter for OBlock
     * @return OBlock
     */
	public int[][] getOBlock() {
		return OBlock;
	}

    /**
     * Setter for OBlock
     * @param OBlock
     */
	public void setOBlock(int[][] oBlock) {
		OBlock = oBlock;
	}

	 /**
     * Getter for SBlock
     * @return SBlock
     */
	public int[][] getSBlock() {
		return SBlock;
	}

    /**
     * Setter for SBlock
     * @param SBlock
     */
	public void setSBlock(int[][] sBlock) {
		SBlock = sBlock;
	}

	 /**
     * Getter for TBlock
     * @return TBlock
     */
	public int[][] getTBlock() {
		return TBlock;
	}

    /**
     * Setter for TBlock
     * @param TBlock
     */
	public void setTBlock(int[][] tBlock) {
		TBlock = tBlock;
	}
	
	 /**
     * Getter for ZBlock
     * @return ZBlock
     */
	public int[][] getZBlock() {
		return ZBlock;
	}

    /**
     * Setter for ZBlock
     * @param ZBlock
     */
	public void setZBlock(int[][] zBlock) {
		ZBlock = zBlock;
	}

	/**
	 * BlockColor Method
	 * @param Colors
	 * @return adding colors to blocks.
	 */
	public static Color blockColor(int Colors) {
		switch (Colors) {
		
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
}
