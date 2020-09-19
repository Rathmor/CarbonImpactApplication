package pack;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import pack.Activity;
import pack.Controller;

public class saveToFileTest {

	@Test
	public void saveToFile() {
		Controller test = new Controller();
		
		LocalDate date1 = LocalDate.of(2020, 3, 19);
		LocalDate date2 = LocalDate.of(2020, 3, 20);
		LocalDate date3 = LocalDate.of(2020, 3, 21);
		
		test.addActivity(1, date1, "Walking", 5);
		test.addActivity(2, date2, "Jogging", 7);
		test.addActivity(1, date3, "Sprinting", 9);
		ArrayList<Activity> listOfActivities = test.appModel.getActivities();
		test.saveToFile();
		test.loadFromFile();
		
		int count = 0;
		for (int i=0; i<test.getNumberOfActivities(); i++) {
			if (listOfActivities.get(i).toString().equals(test.getActivityByIndex(i).toString())) {
				count++;
			}
		}
		
		if (count == test.getNumberOfActivities()) {
			assertTrue(true);
		} else {
			assertTrue(1 == 2);
		}
	}
}
