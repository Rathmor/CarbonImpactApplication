package pack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({addActivityTest.class, getActivitiesByActivityTest.class, getActivitiesByDateTest.class, getActivitiesTest.class,
	getActivityByIndexTest.class, getActivityTest.class, getNumberOfActivitiesTest.class, getTotalOfAllWeeksTest.class, getTotalTest.class,
	loadFromFileTest.class, removeActivityTest.class, saveToFileTest.class,})
public class TestAll {
	
}
