package pack;
import static org.junit.Assert.*;
import java.time.LocalDate;

import org.junit.Test;

import pack.Activity;
import pack.Controller;

public class removeActivityTest {

	@Test
	public void removeActivity() {
		Controller test = new Controller();
		
		LocalDate date1 = LocalDate.of(2020, 3, 19);
		LocalDate date2 = LocalDate.of(2020, 3, 20);
		LocalDate date3 = LocalDate.of(2020, 3, 21);
		test.addActivity(1, date1, "Walking", 5);
		test.addActivity(1, date2, "Jogging", 7);
		test.addActivity(1, date3, "Sprinting", 9);
		
		test.removeActivity(1, date2, "Jogging", 7);
		Activity activityRemoved = new Activity(1, date2, "Jogging", 7);
		
		int verify = 0;
		for (int i=0; i<test.getNumberOfActivities(); i++) {
			if (activityRemoved.toString().equals(test.getActivityByIndex(i).toString())) {
				verify++;
			}
		}
		
		if (verify > 0) {
			assertTrue(1 == 2);
		} else {
			assertTrue(true);
		}
	}
}
