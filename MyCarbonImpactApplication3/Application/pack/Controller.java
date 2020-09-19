package pack;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The Controller Class is the Controller of the Carbon Impact Application program
 * and acts as the base of operation of the program, separating the View from the ActivityList. It
 * listens for calls from the View class to receive user requests and communicate the requested operations
 * to the Model.
 * @author Justas Cepaitis * @version 1.0 
 * @since 18/03/2020
 */
public class Controller {
	
	/** The appModel is an Object of the AcitivityList class used by the Controller class to communicate with the ActivityList. */
	ActivityList appModel = new ActivityList();
	
	/**
	 * This method checks the points of the activity passed to it, ensuring it is no less than -10 
	 * and no greater than +10, outputting an appropriate message if activity did not meet requirement. 
	 * If the activity meets requirements, the activity is passed to the Model class setActivity() method
	 * to add it to the list of activities. 
	 *
	 * @param week. Week of activity
	 * @param date. Date of activity
	 * @param name. Name of activity
	 * @param points. Points of activity
	 */
	public void addActivity(int week, LocalDate date, String name, int points) {
		if ((points >= -10 && points <= 10) == false) {
			System.out.println("Points must be between -10 and 10!");
		} else {
			appModel.setActivity(week, date, name, points);
			System.out.println("Success!");
		}
	}
	
	/**
	 * This method returns an activity which corresponds to the entered parameters by calling
	 * the ActivityList getActivity() method .
	 *
	 * @param week. Week of activity
	 * @param date. Date of activity
	 * @param name. Name of activity
	 * @param points. Points of activity
	 * @return Activity. The activity corresponding to the parameters passed.
	 */
	public Activity getActivity(int week, LocalDate date, String name, int points) {
		return appModel.getActivity(week, date, name, points);
	}
	
	/**
	 * This method returns an activity by its index by calling
	 * the ActivityList method getActivityByIndex().
	 *
	 * @param index. Index states the position of the desired activity
	 * @return Activity. Returns an activity corresponding to specified index
	 */
	public Activity getActivityByIndex(int index) {
		return appModel.getActivityByIndex(index);
	}
	
	/**
	 * This method returns a list of activities in String form by calling
	 * the ActivityList method getActivitiesText() and storing the output of
	 * the method in a String called text.
	 *
	 * @return String. Returns a \n separated String of activities
	 */
	public String getActivitiesText() {
		String text = appModel.getActivitiesText();
		return text;
	}
	
	/**
	 * This method returns activities by date by calling
	 * the ActivityList method getActivitiesByDate().
	 * 
	 * @return String. Returns a \n separated String of activities sorted by their dates
	 */
	public String getActivitiesByDate() {
		String text = appModel.getActivitiesByDate();
		return text;
	}
	
	/**
	 * This method returns activities by name by calling
	 * the ActivityList method getActivitiesByActivity().
	 *
	 * @return String. Returns a \n separated String of activities sorted by their names
	 */
	public String getActivitiesByActivity() {
		String text = appModel.getActivitiesByActivity();
		return text;
	}
	
	/**
	 * This method returns the size of the list of activities in ActivityList by calling
	 * the ActivityList method getActivities().
	 *
	 * @return Int. Returns the number of activities
	 */
	public int getNumberOfActivities() {
		return appModel.getActivities().size();
	}
	
	/**
	 * This method removes an activity by passing the activity passed to it to the
	 * ActivityList removeActivity() method.
	 *
	 * @param Week. Week of the activity
	 * @param Date. Date of the activity
	 * @param Name. Name of the activity
	 * @param Points. Points of the activity
	 */
	public void removeActivity(int Week, LocalDate Date, String Name, int Points) {
		appModel.removeActivity(Week, Date, Name, Points);
	}
	
	/**
	 * This method returns the total points of a week of activities by calling the
	 * ActivityList method getTotalPoints() and storing its return value in an integer 
	 * variable called total.
	 *
	 * @param week. Week of activities to have their total points returned
	 * @return Int. The added up points of the week of activities
	 */
	public int getTotal(int week) {
		int total = appModel.getTotalPoints(week);
		return total;
	}
	
	/**
	 * This method returns the total points of all activities by calling the
	 * ActivityList method getTotalPointsOfAllWeeks() and storing its return value in an integer 
	 * variable called total.
	 *
	 * @return Int. The added up points of all activities
	 */
	public int getTotalOfAllWeeks() {
		int total = appModel.getTotalPointsOfAllWeeks();
		return total;
	}
	
	/**
	 * This method utilizes serialization in order to save the existing activities entered by the user
	 * to a file called "activities.txt". This method checks if the "activities.txt" file exists before operating,
	 * if the file exists, the file is recreated to clear its contents. the activities are loaded into the file using
	 * the ActivityList getActivities() method.
	 */
	public void saveToFile() {
	  try {
		File file = new File("Resources\\activities.txt");
			if (file.exists() == true) {
				file.createNewFile();
			}
	     ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Resources\\activities.txt"));
	     os.writeObject(appModel.getActivities());
	     os.close();
	  } 
	  catch (Exception e) {
		 System.out.println("could not save");
		 e.printStackTrace();
	  }
	}
	
	/**
	 * This method utilizes serialization in order to load the activities from a file called "activities.txt".
	 * the activities are loaded into the list of activities in ActivityList by this method reading every object
	 * in the file line by line and calling the ActivityList setActivitiesFromFile() method to add each object to the
	 * list of activities
	 */
	@SuppressWarnings({ "unchecked" })
	public void loadFromFile() {
	  try {
	     ObjectInputStream is = new ObjectInputStream(new FileInputStream("Resources\\activities.txt"));
	     appModel.setActivitiesFromFile((ArrayList<Activity>) is.readObject());
	     is.close();       
	  } 
	  catch (Exception ex) {
	     System.out.println("could not load");
	     ex.printStackTrace();
	  }
	}
}
