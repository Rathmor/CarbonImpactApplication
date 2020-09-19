package pack;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import pack.Activity;
import pack.Controller;

public class getActivityTest {

	@Test
	public void getActivity() {
		Controller test = new Controller();
		
		LocalDate date = LocalDate.of(2020, 3, 19);
		Activity dummyActivity = new Activity(1, date, "Walking", 10);
		
		Activity activityReturned = test.getActivity(1, date, "Walking", 10);
		
		assertTrue(dummyActivity.toString().equals(activityReturned.toString()));
	}

}
