package model.boxtal;

public class Day {
	private String weekday;
	private String open_am;
	private String close_am;
	private String open_pm;
	private String close_pm;

	public String getWeekday() {
		return weekday;
	}

	public String getOpen_am() {
		return open_am;
	}

	public String getClose_am() {
		return close_am;
	}

	public String getOpen_pm() {
		return open_pm;
	}

	public String getClose_pm() {
		return close_pm;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public void setOpen_am(String open_am) {
		this.open_am = open_am;
	}

	public void setClose_am(String close_am) {
		this.close_am = close_am;
	}

	public void setOpen_pm(String open_pm) {
		this.open_pm = open_pm;
	}

	public void setClose_pm(String close_pm) {
		this.close_pm = close_pm;
	}
}