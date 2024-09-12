/**
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calendar.MeetingCalendar;

/**
 * 
 */
class CalendarEventTest {
	MeetingCalendar cal;
	GregorianCalendar startTime;
	GregorianCalendar endTime;
	GregorianCalendar repeatUntil;
	OneTimeEvent oneTimeEvent;
	PriorityEvent priorityEvent;
	WeeklyEvent weeklyEvent;
	MultiDayPerWeekEvent multiDayPerWeekEvent;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		cal = new MeetingCalendar();
		startTime = new GregorianCalendar(2024,8,12,8,30);
		endTime = new GregorianCalendar(2024,8,12,8,30);
		repeatUntil =new GregorianCalendar(2023,12,28);
		
		oneTimeEvent = new OneTimeEvent("One time meeting", "R111", startTime, endTime);
		priorityEvent = new PriorityEvent("Priority meeting", "R222", startTime, endTime);
		weeklyEvent = new WeeklyEvent("Weekly meeting", "R333", startTime, endTime, repeatUntil);
		
	}


	@Test
	void testOneTimeEvent() {
		assertEquals("One Time Meeting", oneTimeEvent.getDescription());
		assertEquals("R111",oneTimeEvent.getLocation());
		assertEquals(startTime,oneTimeEvent.getStartTime());
		assertEquals(endTime,oneTimeEvent.getEndTime());
		
		oneTimeEvent.scheduleEvent(cal);
		//is there something missing
		
	}
	
	@Test
	void testPriorityEvent() {
		priorityEvent.scheduleEvent(cal);
		
	}
	
	@Test
	void testWeeklyEvent() {
		weeklyEvent.scheduleEvent(cal);
		
	}
	
	@Test
	void testMultiDayPerWeekEvent() {
		multiDayPerWeekEvent.scheduleEvent(cal);
	}
	
	
	/**
	 * Test method for {@link CalendarEvent#CalendarEvent(java.lang.String, java.lang.String, java.util.GregorianCalendar, java.util.GregorianCalendar)}.
	 */
	@Test
	void testCalendarEventStringStringGregorianCalendarGregorianCalendar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link CalendarEvent#scheduleEvent(calendar.MeetingCalendar)}.
	 */
	@Test
	void testScheduleEvent() {
		fail("Not yet implemented");
	}
	

}
