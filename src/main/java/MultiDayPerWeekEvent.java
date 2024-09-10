import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public class MultiDayPerWeekEvent extends CalendarEvent{

	/**
	 * @param description
	 * @param location
	 * @param startTime
	 * @param endTime
	 */
	public MultiDayPerWeekEvent(String description, String location, GregorianCalendar startTime,
			GregorianCalendar endTime) {
		super(description, location, startTime, endTime);
	}

	@Override
	public void sheduleEvent(MeetingCalendar calendar) {
		// TODO Auto-generated method stub
		
	}

}
