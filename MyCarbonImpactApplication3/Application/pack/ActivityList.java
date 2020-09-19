package pack;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * The ActivityList Class is the Model of the Carbon Impact Application Program that processes
 * a list of activity objects and operates on them using various methods
 * to update/add/remove the activities.
 * @author Justas Cepaitis * @version 1.0 
 * @since 18/03/2020
 */
public class ActivityList {
	
	/** The activity list. */
	ArrayList<Activity> activityList = new ArrayList<Activity>();
	
	/**
	 * This method creates a new activity using the parameters passed to it
	 * and adds the activity passed to it to the ArrayList activityList.
	 *
	 * @param week. Week of activity
	 * @param date. Date of activity
	 * @param name. Name of activity
	 * @param points. Points of activity
	 */
	public void setActivity(int week, LocalDate date, String name, int points) {
		Activity activity = new Activity(week, date, name, points);
		activityList.add(activity);
	}
	
	/**
	 * This method returns an activity corresponding to the parameters passed
	 * to the method by constructing a new activity out of the parameters.
	 *
	 * @param week. Week of activity
	 * @param date. Date of activity
	 * @param name. Name of activity
	 * @param points. Points of activity
	 * @return Activity. The activity corresponding to the parameters passed.
	 */
	public Activity getActivity(int week, LocalDate date, String name, int points) {
		Activity activity =  new Activity(week, date, name, points);
		return activity;
	}
	
	/**
	 * This method sets the list of activities to the contents of the ArrayList received as a parameter.
	 * 
	 * @param importedActivityList. ArrayList of activities.
	 */
	public void setActivitiesFromFile(ArrayList<Activity> importedActivityList) {
		activityList = importedActivityList;
	}
	
	/**
	 * This method returns the activity at the specified index.
	 *
	 * @param index of the activity desired
	 * @return Activity. The activity Corresponding to index
	 */
	public Activity getActivityByIndex(int index) {
		return activityList.get(index);
	}
	
	/**
	 * This method returns a string of activities from activityList sorted by their dates
	 * and separated by a \n.
	 *
	 * @return String. The activities in String form separated by \n and sorted by their dates
	 */
	public String getActivitiesByDate() {
		String text = "";
		Collections.sort(activityList, new Comparator<Activity>() {
			@Override
			public int compare(Activity o1, Activity o2) {
				return  o1.getDate().compareTo(o2.getDate());
			}
		});
		
		for (int i=0; i<activityList.size(); i++) {
			text += activityList.get(i) + "\n";
		}
		return text;
	}
	
	/**
	 * This method returns the sum of all points of all activities in the activityList.
	 *
	 * @return int. The total points of all weeks
	 */
	public int getTotalPointsOfAllWeeks() {
		int total = 0;
		for (int i=0; i<activityList.size(); i++) {
			total += activityList.get(i).getPoints();
		}
		return total;
	}
	
	/**
	 * This method returns a string of activities from activityList sorted by their names
	 * and separated by a \n.
	 *
	 * @return String. The activities in String form separated by \n and sorted by their names
	 */
	public String getActivitiesByActivity() {
		String text = "";
		Collections.sort(activityList, new Comparator<Activity>() {
			@Override
			public int compare(Activity o1, Activity o2) {
				return  o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
			}
		});
		
		for (int i=0; i<activityList.size(); i++) {
			text += activityList.get(i) + "\n";
		}
		return text;
	}
	
	/**
	 * This method searches through the array activityList removes an activity from activityList 
	 * which corresponds to the parameters passed.
	 * 
	 * @param Week. Week of activity
	 * @param Date. Date of activity
	 * @param Name. Name of activity
	 * @param Points. Points of activity
	 */
	public void removeActivity(int Week, LocalDate Date, String Name, int Points) {
		Activity activity = new Activity(Week, Date, Name, Points);
		for (int i = 0; i < activityList.size(); i++) {
			if (activityList.get(i).toString().equals(activity.toString())) {
				activityList.remove(i);
			}
		}
	}
	
	/**
	 * This method returns a string of activities from activityList separated by a \n.
	 *
	 * @return String. The activities in String form separated by \n
	 */
	public String getActivitiesText() {
		String text = "";
		for (int i = 0; i < activityList.size(); i++) {
			text += activityList.get(i) + "\n";
		}
		return text;
	}
	
	/**
	 * This method returns an ArrayList containing activity objects.
	 *
	 * @return ArrayList. The list of activities.
	 */
	public ArrayList<Activity> getActivities() {
		return activityList;
	}
	
	/**
	 * This method returns the total points of a week of activities in the activityList.
	 *
	 * @param week of activities to have their total points returned
	 * @return Int. The added up points of the week of activities
	 */
	public int getTotalPoints(int week) {
		int total = 0;
		for (int i = 0; i < activityList.size(); i++) {
			if (activityList.get(i).getWeek() == week) {
				total += activityList.get(i).getPoints();
			}
		}
		return total;
	}
}
