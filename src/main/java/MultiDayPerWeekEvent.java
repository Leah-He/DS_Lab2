import java.util.GregorianCalendar;

import calendar.Meeting;
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

	@Override
	public void scheduleEvent(MeetingCalendar calendar) {
		// TODO Auto-generated method stub
		Meeting newMeeting = new Meeting(getDescription(), getLocation(),getStartTime(), getEndTime(), getRepeatUntil(), getDays());
		calendar.addMeeting(newMeeting);
		calendar.doesMeetingConflict(newMeeting);
		calendar.removeMeeting(newMeeting);
	}

}
