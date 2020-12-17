/**
 * Hour Glass Class
 * 
 * @author Nikki McCloud
 * @version 1.0
 */
package Model;

import java.util.Calendar;

public class HourGlass {

	// Declaring Variables for Count Down Mechanics
	private Calendar timesOutEnd;
	private LevelTime pause;
	private long pauseQty = 0;
	private long timesOutQty = 0;
	private boolean isPaused;
	private Alert checkTime;

	/**
	 * Parameterized Constructor
	 * 
	 * @param hours
	 * @param minutes
	 * @param seconds
	 * @param milliseconds
	 * @param paramName
	 */
	public HourGlass(int hours, int minutes, int seconds, int milliseconds) {
		timesOutEnd = Calendar.getInstance();

		// Setting the times to correct assignments (hour, minutes, etc.) and looks at
		// time until out of time.
		timesOutEnd.set(Calendar.HOUR_OF_DAY, timesOutEnd.get(Calendar.HOUR_OF_DAY) + hours);
		timesOutEnd.set(Calendar.MINUTE, timesOutEnd.get(Calendar.MINUTE) + minutes);
		timesOutEnd.set(Calendar.SECOND, timesOutEnd.get(Calendar.SECOND) + seconds);
		timesOutEnd.set(Calendar.MILLISECOND, timesOutEnd.get(Calendar.MILLISECOND) + milliseconds);
	}

	/**
	 * Getter for timesOutEnd
	 * 
	 * @return timesOutEnd
	 */
	public Calendar getTimesOutEnd() {
		return timesOutEnd;
	}

	/**
	 * Setter for timesOutEnd
	 * 
	 * @param timesOutEnd
	 */
	public void setTimesOutEnd(Calendar timesOutEnd) {
		this.timesOutEnd = timesOutEnd;
	}

	/**
	 * Getter for pause
	 * 
	 * @return pause
	 */
	public LevelTime getPause() {
		return pause;
	}

	/**
	 * Setter for pause
	 * 
	 * @param pause
	 */
	public void setPause(LevelTime pause) {
		this.pause = pause;
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
	 * Getter for timesOutQty
	 * 
	 * @return timesOutQty
	 */
	public long getTimesOutQty() {
		return timesOutQty;
	}

	/**
	 * Setter for timesOutQty
	 * 
	 * @param timesOutQty
	 */
	public void setTimesOutQty(long timesOutQty) {
		this.timesOutQty = timesOutQty;
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
	 * Getter for checkTime
	 * 
	 * @return checkTime
	 */
	public Alert getCheckTime() {
		return checkTime;
	}

	/**
	 * Setter for checkTime
	 * 
	 * @param checkTime
	 */
	public void setCheckTime(Alert checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * Get Time To Go Method
	 * 
	 * @return checks to see how much time before timer is up.
	 */
	public long getTimeToGo() {
		if (this.isPaused == false) {
			this.timesOutQty = (timesOutEnd.getTime().getTime() + this.pauseQty) - System.currentTimeMillis();
			if (this.timesOutQty <= 0) {
				this.timesUp();
			}
		}
		return this.timesOutQty;
	}

	/**
	 * Format Method
	 * 
	 * @return formates the date to time.
	 */
	public String format(long date) {
		return LevelTime.formatTime(date);
	}

	/**
	 * Check If Paused Method
	 * 
	 * @return checks if paused (true or false)
	 */
	public boolean checkIfPaused() {
		return this.isPaused;
	}

	/**
	 * Game Pause Method
	 * 
	 * @param isPaused
	 * @return pauses timer
	 */
	public void gamePause(boolean isPaused) {
		if (isPaused == true) {
			pause = new LevelTime();
		} else {
			this.pauseQty += pause.getPastTime();
		}
		this.isPaused = isPaused;
	}

	/**
	 * Time Up Method
	 * 
	 * @return checks time and creates new event
	 */
	private void timesUp() {
		this.checkTime.outOfTime(new Event(this));
	}

	/**
	 * All Time Method
	 * 
	 * @param alert
	 * @return notifies interface to alert by checking the time left.
	 */
	public synchronized void allTime(Alert alert) {
		this.checkTime = alert;
	}
}
