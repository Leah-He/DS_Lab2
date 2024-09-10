import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public class WeeklyEvent extends CalendarEvent{
	private GregorianCalendar repeatUntil;

	/**
	 * @param description
	 * @param location
	 * @param startTime
	 * @param endTime
	 * @param repeatUntil
	 */
	public WeeklyEvent(String description, String location, GregorianCalendar startTime, GregorianCalendar endTime,
			GregorianCalendar repeatUntil) {
		super(description, location, startTime, endTime);
		this.setRepeatUntil(repeatUntil);
	}

	@Override
	public void sheduleEvent(MeetingCalendar calendar) {
		// TODO Auto-generated method stub
		
	}

	public GregorianCalendar getRepeatUntil() {
		return repeatUntil;
	}

	public void setRepeatUntil(GregorianCalendar repeatUntil) {
		this.repeatUntil = repeatUntil;
	}

}
