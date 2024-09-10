import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public class MultiDayPerWeekEvent extends CalendarEvent{
	private GregorianCalendar repeatUntil;
	private int[] days;

	/**
	 * @param description
	 * @param location
	 * @param startTime
	 * @param endTime
	 * @param repeatUntil
	 * @param days
	 */
	public MultiDayPerWeekEvent(String description, String location, GregorianCalendar startTime,
			GregorianCalendar endTime, GregorianCalendar repeatUntil, int[] days) {
		super(description, location, startTime, endTime);
		this.repeatUntil = repeatUntil;
		this.days = days;
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

	public int[] getDays() {
		return days;
	}

	public void setDays(int[] days) {
		this.days = days;
	}

}
