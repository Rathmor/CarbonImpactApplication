package pack;
import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Test;

import pack.Activity;
import pack.Controller;

public class addActivityTest {

	@Test
	public void addActivity() {
		Controller test = new Controller();
		LocalDate date= LocalDate.of(2020, 3, 19);
		
		test.addActivity(1, date, "Walking", 10);
		Activity activityAdded = new Activity(1, date, "Walking", 10);

		int verify = 0;
		for (int i=0; i<test.getNumberOfActivities(); i++) {
			if (activityAdded.toString().equals(test.getActivityByIndex(i).toString())) {
				verify++;
			}
		}
		
		if (verify > 0) {
			assertTrue(true);
		} else {
			assertTrue(1 == 2);
		}
	}
}
