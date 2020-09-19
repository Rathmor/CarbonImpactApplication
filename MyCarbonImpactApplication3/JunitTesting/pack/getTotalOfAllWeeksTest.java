package pack;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import pack.Controller;

public class getTotalOfAllWeeksTest {

	@Test
	public void getTotalOfAllWeeks() {
		Controller test = new Controller();
		
		LocalDate date1 = LocalDate.of(2020, 3, 19);
		LocalDate date2 = LocalDate.of(2020, 3, 20);
		LocalDate date3 = LocalDate.of(2020, 3, 21);
		test.addActivity(1, date1, "Walking", 5);
		test.addActivity(2, date2, "Jogging", 7);
		test.addActivity(1, date3, "Sprinting", 9);
		int totalPoints = 21;
		
		int totalPointsReturned = test.getTotalOfAllWeeks();
		assertEquals(totalPoints, totalPointsReturned);
	}

}
