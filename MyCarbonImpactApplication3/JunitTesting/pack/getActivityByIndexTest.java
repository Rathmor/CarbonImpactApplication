package pack;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import pack.Activity;
import pack.Controller;

public class getActivityByIndexTest {

	@Test
	public void getActivityByIndex() {
		Controller test = new Controller();
		
		LocalDate date1 = LocalDate.of(2020, 3, 19);
		LocalDate date2 = LocalDate.of(2020, 3, 20);
		
		test.addActivity(1, date1, "Walking", 5);
		test.addActivity(1, date2, "Jogging", 10);
		
		Activity activitySelected =  new Activity(1, date2, "Jogging", 10);
		
		Activity activityReturned = test.getActivityByIndex(1);
		assertTrue(activityReturned.toString().equals(activitySelected.toString()));
		
	}

}
