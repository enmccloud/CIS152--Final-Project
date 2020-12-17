/**
 * Level Time Class
 * 
 * @author Nikki McCloud
 * @version 1.0
 */
package Model;

import java.util.Calendar;
import java.util.Date;

public class LevelTime {

	// Declaring Variables for Timer Mechanic
	private long time;
	private long pastTime;
	private static Calendar calendar = Calendar.getInstance();
	private boolean stopTime;
	private boolean isPaused = false;
	private LevelTime levelTime;
	private long pauseQty = 0;

	/**
	 * Default No Argument Constructor -- Created New Instance of Timer
	 */
	public LevelTime() {
		time = System.currentTimeMillis();
	}

	/**
	 * Getter for time
	 * 
	 * @return time
	 */
	public long getTime() {
		return time;
	}

	/**
	 * Setter for time
	 * 
	 * @param time
	 */
	public void setTime(long time) {
		this.time = time;
	}

	/**
	 * Getter for calendar
	 * 
	 * @return calendar
	 */
	public static Calendar getCalendar() {
		return calendar;
	}

	/**
	 * Setter for calendar
	 * 
	 * @param calendar
	 */
	public static void setCalendar(Calendar calendar) {
		LevelTime.calendar = calendar;
	}

	/**
	 * Getter for stopTime
	 * 
	 * @return stopTime
	 */
	public boolean isStopTime() {
		return stopTime;
	}

	/**
	 * Setter for stopTime
	 * 
	 * @param stopTime
	 */
	public void setStopTime(boolean stopTime) {
		this.stopTime = stopTime;
	}

	/**
	 * Getter for isPaused
	 * 
	 * @return isPaused
	 */
	public boolean isPaused() {
		return isPaused;
	}

	/**
	 * Setter for isPaused
	 * 
	 * @param isPaused
	 */
	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	/**
	 * Getter for timer
	 * 
	 * @return timer
	 */
	public LevelTime getLevelTime() {
		return levelTime;
	}

	/**
	 * Setter for timer
	 * 
	 * @param timer
	 */
	public void setLevelTimer(LevelTime levelTime) {
		this.levelTime = levelTime;
	}

	/**
	 * Getter for pauseQty
	 * 
	 * @return pauseQty
	 */
	public long getPauseQty() {
		return pauseQty;
	}

	/**
	 * Setter for pauseQty
	 * 
	 * @param pauseQty
	 */
	public void setPauseQty(long pauseQty) {
		this.pauseQty = pauseQty;
	}

	/**
	 * Get Past Time Method
	 * 
	 * @return returns amount timer has been running for.
	 */
	public long getPastTime() {
		// Only do the calculation if we are not stoped or paused
		if (this.stopTime == false && this.isPaused == false) {
			pastTime = System.currentTimeMillis() - this.time;
		}
		return pastTime;
	}

	/**
	 * Setter for pastTime
	 * 
	 * @param pastTime
	 */
	public void setPastTime(long pastTime) {
		this.pastTime = pastTime;
	}

	/**
	 * Stop Timer Method
	 * 
	 * @return stops timer.
	 */
	public void stopTimer() {
		stopTime = true;
	}

	/**
	 * Pause Timer Method
	 * 
	 * @param isPaused
	 * @return checks to see if paused and if so when unpaused displays remaining
	 *         time.
	 */
	public void pauseTimer(boolean isPaused) {
		if (isPaused == true) {
			levelTime = new LevelTime();
		} else {
			this.pauseQty += levelTime.getPastTime();
		}
		this.isPaused = isPaused;
	}

	/**
	 * Get Pause Time Method
	 * 
	 * @return pauseQty (pause time left).
	 */
	public long getPauseTime() {
		return this.pauseQty;
	}

	/**
	 * Check If Paused
	 * 
	 * @return isPaused (true or false).
	 */
	public boolean checkIfPaused() {
		return this.isPaused;
	}

	/**
	 * Format Time Method
	 * 
	 * @param date
	 * @return converts time into hours, minutes, seconds, milliseconds to display
	 */
	public static String formatTime(long date) {
		calendar.setTime(new Date(date));

		return calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":"
				+ calendar.get(Calendar.SECOND) + ":" + calendar.get(Calendar.MILLISECOND);
	}
}