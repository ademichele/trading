package it.report.helper.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import it.report.helper.DateUtils;

public class DateUtilsTest {
	
	//I did not test the other methods because they are simple methods of Calendar and SimpleDateFormat and I created them just to avoid repeating code
	//I tested only for one currency since the addDate method called in each case is the same, with the only difference of the amount of days added
	@Test
	public void getNextWorkingDay_EUR_shouldBeMonday(){
		String today = "10-05-2018";
		String currency = "EUR";
		Date instructionDate = DateUtils.stringToDate(today);
		Date settlementDate = DateUtils.getNextWorkingDay(instructionDate, currency);
		String nextWorkingDay = DateUtils.dayName(DateUtils.dateToString(settlementDate));	
		assertTrue(nextWorkingDay.equalsIgnoreCase("Monday"));
	}

	@Test
	public void getNextWorkingDay_AED_shouldBeSunday(){
		String today = "10-05-2018";
		String currency = "AED";
		Date instructionDate = DateUtils.stringToDate(today);
		Date settlementDate = DateUtils.getNextWorkingDay(instructionDate, currency);
		String nextWorkingDay = DateUtils.dayName(DateUtils.dateToString(settlementDate));	
		assertTrue(nextWorkingDay.equalsIgnoreCase("Sunday"));
	}
}


