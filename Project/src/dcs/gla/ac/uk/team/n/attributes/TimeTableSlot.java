package dcs.gla.ac.uk.team.n.attributes;

import java.util.Date;

public class TimeTableSlot {
	private Date start;
	private Date end;
	
	public TimeTableSlot(Date start, Date end) {
		super();
		this.start = start;
		this.end = end;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
}
