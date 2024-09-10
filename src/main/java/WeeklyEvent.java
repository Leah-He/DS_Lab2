import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public class WeeklyEvent extends CalendarEvent{

	/**
	 * @param description
	 * @param location
	 * @param startTime
	 * @param endTime
	 */
	public WeeklyEvent(String description, String location, GregorianCalendar startTime, GregorianCalendar endTime) {
		super(description, location, startTime, endTime);
	}

	@Override
	public void sheduleEvent(MeetingCalendar calendar) {
		// TODO Auto-generated method stub
		
	}

}
