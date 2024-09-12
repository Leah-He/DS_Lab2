/**
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calendar.Meeting;
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
	int[] days;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		cal = new MeetingCalendar();
		startTime = new GregorianCalendar(2024,8,12,8,30);
		endTime = new GregorianCalendar(2024,8,12,8,30);
		repeatUntil =new GregorianCalendar(2024,12,28);
		days = new int[] {1,3,5};
		
		oneTimeEvent = new OneTimeEvent("One Time Meeting", "R111", startTime, endTime);
		priorityEvent = new PriorityEvent("Priority Event", "R222", startTime, endTime);
		weeklyEvent = new WeeklyEvent("Weekly Event", "R333", startTime, endTime, repeatUntil);
		multiDayPerWeekEvent = new MultiDayPerWeekEvent("Multi Day Per Week Event", "R444", startTime, endTime, repeatUntil, days);
	}


	@Test
	void testOneTimeEvent() {
		assertEquals("One Time Meeting", oneTimeEvent.getDescription());
		assertEquals("R111", oneTimeEvent.getLocation());
		assertEquals(startTime, oneTimeEvent.getStartTime());
		assertEquals(endTime, oneTimeEvent.getEndTime());
		
		oneTimeEvent.scheduleEvent(cal);
		assertEquals(oneTimeEvent, cal.findMeeting(startTime));
		//is there something missing?
		
	}
	
	@Test
	void testPriorityEvent() {
		assertEquals("Priority Meeting", priorityEvent.getDescription());
		assertEquals("R222", priorityEvent.getLocation());
		assertEquals(startTime, priorityEvent.getStartTime());
		assertEquals(endTime, priorityEvent.getEndTime());
		
		priorityEvent.scheduleEvent(cal);
		assertEquals(priorityEvent, cal.findMeeting(startTime));
	}
	
	@Test
	void testWeeklyEvent() {
		assertEquals("Weekly Event", weeklyEvent.getDescription());
		assertEquals("R333", weeklyEvent.getLocation());
		assertEquals(startTime, weeklyEvent.getStartTime());
		assertEquals(endTime, weeklyEvent.getEndTime());
		assertEquals(repeatUntil, weeklyEvent.getRepeatUntil());
		
		weeklyEvent.scheduleEvent(cal);
		assertEquals(weeklyEvent, cal.findMeeting(startTime));
		
	}
	
	@Test
	void testMultiDayPerWeekEvent() {
		assertEquals("Multi Day Per Week Event", multiDayPerWeekEvent.getDescription());
		assertEquals("R444", multiDayPerWeekEvent.getLocation());
		assertEquals(startTime, multiDayPerWeekEvent.getStartTime());
		assertEquals(endTime, multiDayPerWeekEvent.getEndTime());
		assertEquals(repeatUntil, multiDayPerWeekEvent.getRepeatUntil());
		assertEquals(days, multiDayPerWeekEvent.getDays());
		
		multiDayPerWeekEvent.scheduleEvent(cal);
		assertEquals(multiDayPerWeekEvent, cal.findMeeting(startTime));
		
		
	}
	
	
	/**
	 * Test method for {@link CalendarEvent#CalendarEvent(java.lang.String, java.lang.String, java.util.GregorianCalendar, java.util.GregorianCalendar)}.
	 *
	@Test
	void testCalendarEventStringStringGregorianCalendarGregorianCalendar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link CalendarEvent#scheduleEvent(calendar.MeetingCalendar)}.
	 *
	@Test
	void testScheduleEvent() {
		fail("Not yet implemented");
	}
	*/

}
