package pack;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import pack.Activity;
import pack.Controller;

public class getActivitiesByDateTest {

	@Test
	public void getActivitiesByDate() {
		Controller test = new Controller();
		
		LocalDate date1 = LocalDate.of(2020, 3, 20);
		LocalDate date2 = LocalDate.of(2020, 3, 19);
		Activity activity1 =  new Activity(1, date1, "Walking", 5);
		Activity activity2 =  new Activity(1, date2, "Jogging", 10);
		String activitiesTextSortedByDate = activity2 + "\n" + activity1 + "\n";
		
		test.addActivity(1, date1, "Walking", 5);
		test.addActivity(1, date2, "Jogging", 10);
		String activitiesTextReturned = test.getActivitiesByDate();
		
		assertEquals(activitiesTextReturned, activitiesTextSortedByDate);
	}

}
