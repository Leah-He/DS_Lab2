import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public class OneTimeEvent extends CalendarEvent{
	/**
	 * @param description
	 * @param location
	 * @param startTime
	 * @param endTime
	 */
	public OneTimeEvent(String description, String location, GregorianCalendar startTime, GregorianCalendar endTime) {
		super(description, location, startTime, endTime);
	}


	@Override
	public void scheduleEvent(MeetingCalendar calendar) {
		// TODO Auto-generated method stub
		
	}
}
