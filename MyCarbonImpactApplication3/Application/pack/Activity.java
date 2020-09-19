package pack;

import java.io.Serializable;
import java.time.LocalDate;

/** 
The Activity class constructs structured activity objects that 
* will be used by the carbon impact application program
* @author Justas Cepaitis * @version 1.0 
* @since 18/03/2020
*/ 

public class Activity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9142678947270585759L;
	
	/** The week. */
	private int week;
	
	/** The date. */
	private LocalDate date;
	
	/** The name. */
	private String name;
	
	/** The points. */
	private int points;
	
	/**
	 * Instantiates a new activity.
	 *
	 * @param Week the week
	 * @param Date the date
	 * @param Name the name
	 * @param Points the points
	 */
	public Activity(int Week, LocalDate Date, String Name, int Points) {
		this.week = Week;
		this.date = Date;
		this.name = Name;
		this.points = Points;
	}
	
	/**
	 * Gets the week of the activity.
	 *
	 * @return Int. Week of activity.
	 */
	public int getWeek() {
		return week;
	}

	/**
	 * Gets the date of the activity.
	 *
	 * @return LocalDate. Date of activity.
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Gets the name of the activity.
	 *
	 * @return String. Name of activity.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the points of the activity.
	 *
	 * @return Int. Points of activity.
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets the date of the activity.
	 *
	 * @param date the new date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Sets the name of the activity.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the points of the activity.
	 *
	 * @param points the new points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * Outputs the activity details in a readable and structured line of text.
	 *
	 * @return String. The activity in a structured, readable String.
	 */
	public String toString() {
		return "[Week]:" + this.week + "    [Date]:" + this.date + "    [Activity]:" + this.name + "    [Points]:" + this.points;
	}
}
