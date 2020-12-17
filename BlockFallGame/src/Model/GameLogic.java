/**
 * Game Logic Class
 * 
 * @author Nikki McCloud
 * @version 1.0
 */
package Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import HighScore.ScoreDeposit;
import View.GameBoard;
import View.GameDisplay;

public class GameLogic extends javax.swing.JFrame implements Runnable, KeyListener, Alert {

	// Intializing Variables for Game Mechanics
	private Thread main;
	private Blocks currentBlock;
	private Blocks nextBlock;
	private GameDisplay display;
	private GameBoard board = new GameBoard();
	private static boolean gameOver = false;
	private boolean pause = false;
	private long pointsScored = 0;
	private int linesCleared = 0;
	private int currentLevel = 0;
	private int blockDrop = BLOCK_TIME;
	private int testing = 0;
	private char rotate = 'R';
	private static int levelAdvance = 1;
	private ScoreDeposit highScores;

	// Constants for Scoring System
	private static final int FIRST_TIER = 50;
	private static final int SECOND_TIER = 100;
	private static final int THIRD_TIER = 200;
	private static final int FOURTH_TIER = 500;

	// Constants for Timing/Block Speed
	private static final int BLOCK_TIME = 500;
	private static final int FAST_FALL = 20;
	private static final int NEXT_LEVEL = 1;

	// New instance of Game Timer (till next Level)
	private HourGlass gameTime = new HourGlass(0, NEXT_LEVEL, 0, 0);

	/**
	 * Default No Argument Constructor --Creating New Instance
	 */
	public GameLogic() {

		gameTime.allTime(this);

		display = new GameDisplay();
		this.add(display);

		currentBlock = new Blocks();
		currentBlock.getRandomPiece();

		nextBlock = new Blocks();
		nextBlock.getRandomPiece();

		display.setFocusable(false);
		display.setBlockRotation("Right");

		this.addKeyListener(this);
		this.gameStart();
	}

	/**
	 * Getter for highScores
	 * 
	 * @return highScores
	 */
	public ScoreDeposit getHighScores() {
		return highScores;
	}

	/**
	 * Setter for highScores
	 * 
	 * @param highScores
	 */
	public void setHighScores(ScoreDeposit highScores) {
		this.highScores = highScores;
	}

	/**
	 * Getter for main
	 * 
	 * @return main
	 */
	public Thread getMain() {
		return main;
	}

	/**
	 * Setter for main
	 * 
	 * @param main
	 */
	public void setMain(Thread main) {
		this.main = main;
	}

	/**
	 * Getter for currentBlock
	 * 
	 * @return currentBlock
	 */
	public Blocks getCurrentBlock() {
		return currentBlock;
	}

	/**
	 * Setter for currentBlock
	 * 
	 * @param currentBlock
	 */
	public void setCurrentBlock(Blocks currentBlock) {
		this.currentBlock = currentBlock;
	}

	/**
	 * Getter for nextBlock
	 * 
	 * @return nextBlock
	 */
	public Blocks getNextBlock() {
		return nextBlock;
	}

	/**
	 * Setter for nextBlock
	 * 
	 * @param nextBlock
	 */
	public void setNextBlock(Blocks nextBlock) {
		this.nextBlock = nextBlock;
	}

	/**
	 * Getter for display
	 * 
	 * @return display
	 */
	public GameDisplay getDisplay() {
		return display;
	}

	/**
	 * Setter for display
	 * 
	 * @param display
	 */
	public void setDisplay(GameDisplay display) {
		this.display = display;
	}

	/**
	 * Getter for board
	 * 
	 * @return board
	 */
	public GameBoard getBoard() {
		return board;
	}

	/**
	 * Setter for board
	 * 
	 * @param board
	 */
	public void setBoard(GameBoard board) {
		this.board = board;
	}

	/**
	 * Getter for gameOver
	 * 
	 * @return gameOver
	 */
	public static boolean isGameOver() {
		return gameOver;
	}

	/**
	 * Setter for gameOver
	 * 
	 * @param gameOver
	 */
	public static void setGameOver(boolean gameOver) {
		GameLogic.gameOver = gameOver;
	}

	/**
	 * Getter for pause
	 * 
	 * @return pause
	 */
	public boolean isPause() {
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
	 * Getter for pointsScored
	 * 
	 * @return pointsScored
	 */
	public long getPointsScored() {
		return pointsScored;
	}

	/**
	 * Setter for pointsScored
	 * 
	 * @param pointsScored
	 */
	public void setPointsScored(long pointsScored) {
		this.pointsScored = pointsScored;
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
	 * Getter for currentLevel
	 * 
	 * @return currentLevel
	 */
	public int getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * Setter for currentLevel
	 * 
	 * @param currentLevel
	 */
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
	 * Getter for blockDrop
	 * 
	 * @return blockDrop
	 */
	public int getBlockDrop() {
		return blockDrop;
	}

	/**
	 * Setter for blockDrop
	 * 
	 * @param blockDrop
	 */
	public void setBlockDrop(int blockDrop) {
		this.blockDrop = blockDrop;
	}

	/**
	 * Getter for testing
	 * 
	 * @return testing
	 */
	public int getTesting() {
		return testing;
	}

	/**
	 * Setter for testing
	 * 
	 * @param testing
	 */
	public void setTesting(int testing) {
		this.testing = testing;
	}

	/**
	 * Getter for rotate
	 * 
	 * @return rotate
	 */
	public char getRotate() {
		return rotate;
	}

	/**
	 * Setter for rotate
	 * 
	 * @param rotate
	 */
	public void setRotate(char rotate) {
		this.rotate = rotate;
	}

	/**
	 * Getter for levelAdvance
	 * 
	 * @return levelAdvance
	 */
	public static int getLevelAdvance() {
		return levelAdvance;
	}

	/**
	 * Setter for levelAdvance
	 * 
	 * @param levelAdvance
	 */
	public static void setLevelAdvance(int levelAdvance) {
		GameLogic.levelAdvance = levelAdvance;
	}

	/**
	 * Getter for gameTime
	 * 
	 * @return gameTime
	 */
	public HourGlass getGameTime() {
		return gameTime;
	}

	/**
	 * Setter for gameTime
	 * 
	 * @param gameTime
	 */
	public void setGameTime(HourGlass gameTime) {
		this.gameTime = gameTime;
	}

	/**
	 * Run Method
	 * 
	 * @return Runs loop that plays the game
	 */
	public void run() {

		// If game is playing display timer.
		while (gameOver == false) {
			if (pause == false) {
				display.setLevelTimer(Integer.parseInt(gameTime.format(gameTime.getTimeToGo()).split(":")[2]));

				// Checks to see if block is able to continue moving
				// down- if not will lock block in place.
				testing = board.dropBlock(currentBlock.getFallingBlock(), currentBlock.getRowCoordinates() + 1,
						currentBlock.getColumnCoordinates(), true);

				if (testing == 1) {
					this.lockInBlock();
				} else {
					currentBlock.pushDown();
				}
				this.drawGame();
			}
			try {
				Thread.sleep(blockDrop);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

		}
		System.gc();
	}

	/**
	 * Lock In Method
	 * 
	 * @return locks block in place if unable to move down further.
	 */
	private void lockInBlock() {
		int rows = 0;

		board.dropBlock(currentBlock.getFallingBlock(), currentBlock.getRowCoordinates(),
				currentBlock.getColumnCoordinates(), false);

		// Checking to see if another block can be dropped.
		if (board.gameOver() == true) {
			GameLogic.gameOver = true;
			display.setGameOver(true);
		} else {
			currentBlock = nextBlock;
			nextBlock = new Blocks();
			nextBlock.getRandomPiece();

			rows = board.playerPoints();

			this.linesCleared += rows;
			this.playerPoints(rows);
		}
	}

	/**
	 * Game Start Method
	 * 
	 * @return starts new instance of game.
	 */
	public void gameStart() {
		GameLogic.gameOver = false;
		main = new Thread(this);
		main.start();
	}

	/**
	 * Reset Game
	 * 
	 * @return resets game and all functions.
	 */
	private void resetGame() {

		gameTime = new HourGlass(0, NEXT_LEVEL, 0, 0);
		gameTime.allTime(this);

		currentBlock = new Blocks();
		currentBlock.getRandomPiece();

		nextBlock = new Blocks();
		nextBlock.getRandomPiece();

		board = new GameBoard();
		this.blockDrop = BLOCK_TIME;

		pause = false;
		display.setPause(false);
		display.setGameOver(false);
		display.setLevel(0);
		pointsScored = 0;
		linesCleared = 0;
		currentLevel = 0;

		GameLogic.gameOver = true;

		try {
			Thread.currentThread();
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		this.gameStart();
	}

	/**
	 * Player Points Method
	 * 
	 * @return assigns points based on tier hit.
	 */
	private void playerPoints(int rows) {
		switch (rows) {
		case 0:
			this.pointsScored += 0;
			break;
		case 1:
			this.pointsScored += GameLogic.FIRST_TIER;
			break;
		case 2:
			this.pointsScored += GameLogic.SECOND_TIER;
			break;
		case 3:
			this.pointsScored += GameLogic.THIRD_TIER;
			break;
		case 4:
			this.pointsScored += GameLogic.FOURTH_TIER;
			break;
		}
	}

	/**
	 * Draw Game Method
	 * 
	 * @return sets values to the game display set.
	 */
	private void drawGame() {
		display.setScore(this.pointsScored);
		display.setLinesCleared(this.linesCleared);
		display.setNextBlock(nextBlock.getFallingBlock());
		display.setBoard(board.createGameBoard());
		display.paintDirections(currentBlock.getColumnCoordinates(), currentBlock.getRowCoordinates());
		display.setBlock(currentBlock.getFallingBlock());
		display.repaint();
	}

	/**
	 * Key Typed Method
	 * 
	 * @return checking for key event
	 */
	public void keyTyped(KeyEvent event) {
	}

	/**
	 * Key Released Method
	 * 
	 * @return checking for key event
	 */
	public void keyReleased(KeyEvent event) {
	}

	/**
	 * Key Pressed Method
	 * 
	 * @param event
	 * @return checking for key event that corresponds with game directions.
	 */
	public void keyPressed(KeyEvent event) {

		// Conditions if the Down Arrow Key is Pressed
		if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			testing = board.dropBlock(currentBlock.getFallingBlock(), currentBlock.getRowCoordinates() + 1,
					currentBlock.getColumnCoordinates(), true);

			if (testing == 1) {
				this.lockInBlock();
			} else {
				this.pointsScored++;
				currentBlock.pushDown();
				this.drawGame();
			}

			// Conditions if the "P" Key is Pressed (Pause Game)
		} else if (event.getKeyCode() == KeyEvent.VK_P) {
			this.pause = !this.pause;
			display.setPause(this.pause);
			gameTime.gamePause(this.pause);
			this.drawGame();

			// Conditions if the Up Arrow Key is Pressed (pivot block)
		} else if (event.getKeyCode() == KeyEvent.VK_UP) {

			if (this.rotate == 'R') {
				testing = board.dropBlock(currentBlock.pivotBlockRight(true), currentBlock.getRowCoordinates(),
						currentBlock.getColumnCoordinates(), true);

				if (testing != 1) {
					currentBlock.pivotBlockRight(false);
					this.drawGame();
				}
			} else {
				testing = board.dropBlock(currentBlock.pivotBlockLeft(true), currentBlock.getRowCoordinates(),
						currentBlock.getColumnCoordinates(), true);
				if (testing != 1) {
					currentBlock.pivotBlockLeft(false);
					this.drawGame();
				}
			}

			// Conditions if the Right Arrow Key is Pressed (move block to right)
		} else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			testing = board.dropBlock(currentBlock.getFallingBlock(), currentBlock.getRowCoordinates(),
					currentBlock.getColumnCoordinates() + 1, true);

			if (testing != 1) {
				currentBlock.moveSideToSide(false, true);
				this.drawGame();
			}

			// Conditions if the Left Arrow Key is Pressed (move block to left)
		} else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			testing = board.dropBlock(currentBlock.getFallingBlock(), currentBlock.getRowCoordinates(),
					currentBlock.getColumnCoordinates() - 1, true);

			if (testing != 1) {
				currentBlock.moveSideToSide(true, false);
				this.drawGame();
			}
		} else if (event.getKeyCode() == KeyEvent.VK_R) {
			if (this.rotate == 'R') {
				this.rotate = 'L';
				display.setBlockRotation("Left");
			} else {
				this.rotate = 'R';
				display.setBlockRotation("Right");
			}
			this.drawGame();
		} else if (event.getKeyCode() == KeyEvent.VK_N) {
			this.resetGame();
		}
	}

	/**
	 * Out of Time Method
	 * 
	 * @param event
	 * @return make all items drop and start new game if player is out of time.
	 */
	public void outOfTime(Event Event) {
		this.blockDrop -= GameLogic.FAST_FALL;
		this.display.setLevel(++this.currentLevel);

		gameTime = new HourGlass(0, NEXT_LEVEL, 0, 0);
		gameTime.allTime(this);
	}

	/**
	 * Display High Score Method
	 * 
	 * @param highScore
	 * @return display list of high scores
	 */
	public void displayHighScores(ScoreDeposit scores) {
		scores = new ScoreDeposit(2);

		String finalMessage = "Great Game!\nInitial Score  Was " + board.playerPoints() + "\n";

		display.outputScore(finalMessage);
		highScores.addNewScore("Player", board.playerPoints());
		display.outputScore("HIGHSCORES ON TETRIS\n" + highScores.getListOfScores());
		highScores.addToFile();
	}
}
