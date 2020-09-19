package pack;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import pack.Activity;
import pack.Controller;

public class getActivitiesTest {

	@Test
	public void getActivities() {
		Controller test = new Controller();
		
		LocalDate date1 = LocalDate.of(2020, 3, 19);
		LocalDate date2 = LocalDate.of(2020, 3, 20);
		
		test.addActivity(1, date1, "Walking", 5);
		test.addActivity(1, date2, "Jogging", 10);
		
		Activity activity1 =  new Activity(1, date1, "Walking", 5);
		Activity activity2 =  new Activity(1, date2, "Jogging", 10);
		
		String activitiesText = activity1 + "\n" + activity2 + "\n";
		String activitiesTextReturned = test.getActivitiesText();
		
		assertEquals(activitiesText, activitiesTextReturned);
	}

}
