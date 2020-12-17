/**
 * Score Deposit Class
 * 
 * @author Nikki McCloud
 * @version 1.0
 */
package HighScore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ScoreDeposit {

	// Variables for High Score Mechanism
	private File file;
	private Scanner fileReader;
	private ScoreLinkedList<Score> scores;
	private int shift;

	/**
	 * Default No Argument Constructor
	 */
	public ScoreDeposit() {
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param shift - Shifting when adding
	 */
	public ScoreDeposit(int shift) {
		file = new File("highscores.txt");
		try {
			fileReader = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scores = new ScoreLinkedList<>();
		this.shift = shift;
		loadHighScores();

	}

	/**
	 * Getter for shift
	 * 
	 * @return shift
	 */
	public int getShift() {
		return shift;
	}

	/**
	 * Setter for shift
	 * 
	 * @param shift
	 */
	public void setShift(int shift) {
		this.shift = shift;
	}

	/**
	 * Load High Scores Method
	 * 
	 * @param fileReader
	 * @return loads high scores into file if one is available.
	 */
	private void loadHighScores() {
		if (fileReader == null) {
			return;
		}
		while (fileReader.hasNext()) {
			String name = fileReader.next();
			int score = fileReader.nextInt();
			Score newScore = new Score(name, score);
			newScore.Decrypt(shift);
			scores.insertHead(newScore);
		}
	}

	/**
	 * Add New Score
	 * 
	 * @param playerName
	 * @param playerScore
	 * @return adds converted score
	 */
	public void addNewScore(String playerName, int playerScore) {
		Score toInsert = new Score(playerName, playerScore);
		scores.reverseOrder(toInsert);
	}

	/**
	 * Add to File
	 * 
	 * @param scores
	 * @param shift
	 * @return writes to file
	 */
	public void addToFile() {
		fileReader.close();
		Node<Score> currentData = scores.getHead();
		while (currentData != null) {
			Score s = currentData.getData();
			s.encryptPlayerData(shift);
			currentData = currentData.getNext();
		}
		PrintStream output;
		try {
			output = new PrintStream(file);
			output.print(this.getListOfScores());
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Get List of Scores Method
	 * 
	 * @param scores
	 * @return gets list of scores
	 */
	public String getListOfScores() {
		return scores.toString(System.lineSeparator());
	}

	/**
	 * Print List of Scores Method
	 * 
	 * @param scores
	 * @return prints list of scores
	 */
	public static void printListOfScores() {

		ScoreDeposit s = new ScoreDeposit(2);
		Node<Score> cur = s.scores.getHead();
		String toDisplay = "";
		while (cur != null) {
			toDisplay += cur.getData().getScore() + "\n";
			cur = cur.getNext();

		}
		System.out.println(toDisplay);
	}
}
