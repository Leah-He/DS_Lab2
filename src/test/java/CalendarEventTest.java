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
	GregorianCalendar startTime1;
	GregorianCalendar endTime1;
	
	GregorianCalendar startTime1_2;
	GregorianCalendar startTime1_3;
	GregorianCalendar startTime1_4;
	GregorianCalendar startTime1_5;
	GregorianCalendar startTime1_6;
	GregorianCalendar startTime1_7;
	GregorianCalendar startTime1_8;
	GregorianCalendar startTime1_9;
	GregorianCalendar startTime1_10;
	GregorianCalendar startTime1_11;
	GregorianCalendar startTime1_12;

	GregorianCalendar startTime2;
	GregorianCalendar endTime2;
	
	GregorianCalendar startTime3;
	GregorianCalendar endTime3;
	
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
		
		startTime1 = new GregorianCalendar(2024,8,12,8,30);
		endTime1 = new GregorianCalendar(2024,8,12,9,30);
		startTime1_2 = new GregorianCalendar(2024,8,19,8,30);
		startTime1_3 = new GregorianCalendar(2024,8,17,8,30);
		startTime1_4 = new GregorianCalendar(2024,10,24,2,30);
		startTime1_5 = new GregorianCalendar(2024,10,31,2,30);
		
		startTime1_6 = new GregorianCalendar(2024,8,16,8,30);
		startTime1_7 = new GregorianCalendar(2024,8,18,8,30);
		startTime1_8 = new GregorianCalendar(2024,10,20,8,30);
		startTime1_9 = new GregorianCalendar(2024,10,11,9,30);
		startTime1_10 = new GregorianCalendar(2024,10,29,9,30);
		startTime1_11 = new GregorianCalendar(2024,10,19,9,30);
		startTime1_12 = new GregorianCalendar(2024,11,6,9,30);
		
		
		startTime2 = new GregorianCalendar(2024,8,12,10,30);
		endTime2 = new GregorianCalendar(2024,8,12,12,30);
		
		startTime3 = new GregorianCalendar(2024,8,12,1,30);
		endTime3 = new GregorianCalendar(2024,8,12,2,30);
		
		
		
		repeatUntil =new GregorianCalendar(2024,10,28,2,30);
		days = new int[] {0,2,4};
		
		//oneTimeEvent = new OneTimeEvent("One Time Meeting", "R111", startTime1, endTime1);
		//priorityEvent = new PriorityEvent("Priority Meeting", "R222", startTime1, endTime1);
		//weeklyEvent = new WeeklyEvent("Weekly Event", "R333", startTime1, endTime1, repeatUntil);
		//multiDayPerWeekEvent = new MultiDayPerWeekEvent("Multi Day Per Week Event", "R444", startTime1, endTime1, repeatUntil, days);
	}


	@Test
	void testOneTimeEvent() {
		
		
		OneTimeEvent oneTimeEvent1 = new OneTimeEvent("One Time Meeting1", "R111", startTime1, endTime1);
		oneTimeEvent1.scheduleEvent(cal);
		assertEquals(oneTimeEvent1.getDescription(), cal.findMeeting(startTime1).getDescription());
		assertEquals("One Time Meeting1", oneTimeEvent1.getDescription());
		assertEquals("R111", oneTimeEvent1.getLocation());
		assertEquals(startTime1, oneTimeEvent1.getStartTime());
		assertEquals(endTime1, oneTimeEvent1.getEndTime());
		
		
		
		OneTimeEvent oneTimeEvent2 = new OneTimeEvent("One Time Meeting2", "R112", startTime2, endTime2);
		oneTimeEvent2.scheduleEvent(cal);
		assertEquals(oneTimeEvent2.getDescription(), cal.findMeeting(startTime2).getDescription());
		assertEquals(oneTimeEvent1.getDescription(), cal.findMeeting(startTime1).getDescription());
		
	
		
		OneTimeEvent oneTimeEvent3 = new OneTimeEvent("One Time Meeting3", "R113", startTime1, endTime1);
		oneTimeEvent3.scheduleEvent(cal);
		assertFalse(oneTimeEvent3.getDescription()==cal.findMeeting(startTime1).getDescription());
		assertEquals(oneTimeEvent1.getDescription(), cal.findMeeting(startTime1).getDescription());
		
		
		
		
		
		//is there something missing?
		
	}
	
	@Test
	void testPriorityEvent() {


		MeetingCalendar cal2 = new MeetingCalendar();
		PriorityEvent priorityEvent1 = new PriorityEvent("priority Meeting1", "R111", startTime1, endTime1);
		priorityEvent1.scheduleEvent(cal2);
		assertEquals(priorityEvent1.getDescription(), cal2.findMeeting(startTime1).getDescription());
		assertEquals("priority Meeting1", priorityEvent1.getDescription());
		assertEquals("R111", priorityEvent1.getLocation());
		assertEquals(startTime1, priorityEvent1.getStartTime());
		assertEquals(endTime1, priorityEvent1.getEndTime());
		
		PriorityEvent priorityEvent2 = new PriorityEvent("priority Meeting2", "R112", startTime2, endTime2);
		priorityEvent2.scheduleEvent(cal2);
		assertEquals(priorityEvent2.getDescription(), cal2.findMeeting(startTime2).getDescription());
		assertEquals(priorityEvent1.getDescription(), cal2.findMeeting(startTime1).getDescription());
		
		PriorityEvent priorityEvent3 = new PriorityEvent("priority Meeting3", "R113", startTime2, endTime2);
		priorityEvent3.scheduleEvent(cal2);
		assertEquals(priorityEvent3.getDescription(), cal2.findMeeting(startTime2).getDescription());
		assertFalse(priorityEvent2.getDescription()== cal2.findMeeting(startTime2).getDescription());
		assertEquals(priorityEvent1.getDescription(), cal2.findMeeting(startTime1).getDescription());
	}
	
	@Test
	void testWeeklyEvent() {
		
		MeetingCalendar cal3 = new MeetingCalendar();
		WeeklyEvent weeklyEvent1 = new WeeklyEvent("weekly Meeting1", "R111", startTime1, endTime1, repeatUntil);
		weeklyEvent1.scheduleEvent(cal3);
		assertEquals("weekly Meeting1", weeklyEvent1.getDescription());
		assertEquals("R111", weeklyEvent1.getLocation()); //xiang zhihou
		assertEquals(startTime1, weeklyEvent1.getStartTime());
		assertEquals(endTime1, weeklyEvent1.getEndTime());
		
		assertEquals(weeklyEvent1.getDescription(), cal3.findMeeting(startTime1).getDescription());
		assertNull(cal3.findMeeting(startTime1_3));
		assertNull(cal3.findMeeting(startTime1_5));
		
		WeeklyEvent weeklyEvent2 = new WeeklyEvent("weekly Meeting2", "R222", startTime2, endTime2, repeatUntil);
		weeklyEvent2.scheduleEvent(cal3);
		GregorianCalendar time1 = new GregorianCalendar(2024,8,19,8,30);
		GregorianCalendar time2 = new GregorianCalendar(2024,8,25,8,30);
		GregorianCalendar time3 = new GregorianCalendar(2024,11,5,10,30);
		
		assertEquals(weeklyEvent1.getDescription(), cal3.findMeeting(time1).getDescription());
		assertNull(cal3.findMeeting(time2));
		assertNull(cal3.findMeeting(time3));
		assertEquals(weeklyEvent1.getDescription(), cal3.findMeeting(startTime1).getDescription());
		
		WeeklyEvent weeklyEvent3 = new WeeklyEvent("weekly Meeting3", "R111", startTime1, endTime1, repeatUntil);
		weeklyEvent3.scheduleEvent(cal3);
		assertFalse(weeklyEvent3.getDescription() == cal3.findMeeting(startTime1).getDescription());
		assertEquals(weeklyEvent1.getDescription(), cal3.findMeeting(startTime1).getDescription());
	}
	
	@Test
	void testMultiDayPerWeekEvent() {
		
		MeetingCalendar cal4 = new MeetingCalendar();
		MultiDayPerWeekEvent multiDayPerWeekEvent = new MultiDayPerWeekEvent("Multi Day Per Week Event1", "R111", startTime1, endTime1, repeatUntil, days);
		multiDayPerWeekEvent.scheduleEvent(cal4);
		assertEquals("Multi Day Per Week Event1", multiDayPerWeekEvent.getDescription());
		assertEquals("R111", multiDayPerWeekEvent.getLocation());
		assertEquals(startTime1, multiDayPerWeekEvent.getStartTime());
		assertEquals(endTime1, multiDayPerWeekEvent.getEndTime());
		
		assertEquals(multiDayPerWeekEvent.getDescription(), cal4.findMeeting(startTime1_6).getDescription());
		
		//GregorianCalendar endTime6 = new GregorianCalendar(2024,8,16,9,30);
		
	//	assertEquals(endTime6, cal4.findMeeting(startTime1_6).getEndTime());
		
		assertEquals(multiDayPerWeekEvent.getDescription(), cal4.findMeeting(startTime1_7).getDescription());
		assertEquals(multiDayPerWeekEvent.getDescription(), cal4.findMeeting(startTime1_8).getDescription());
		assertEquals(multiDayPerWeekEvent.getDescription(), cal4.findMeeting(startTime1_9).getDescription());
		assertNull(cal4.findMeeting(startTime1_10));
		assertNull(cal4.findMeeting(startTime1_11));
		assertNull(cal4.findMeeting(startTime1_12));
	
		MultiDayPerWeekEvent multiDayPerWeekEvent1 = new MultiDayPerWeekEvent("Multi Day Per Week Event2", "R111", startTime1, endTime1, repeatUntil, days);
		multiDayPerWeekEvent1.scheduleEvent(cal4);
		assertEquals(multiDayPerWeekEvent.getDescription(), cal4.findMeeting(startTime1_6).getDescription());
	}
	
	
	
	

}
