package co.edu.uptc.model;

public class Date {
	private byte day;
	private byte month;
	private byte year;
	
	public Date(byte day, byte month, byte year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public byte getDay() {
		return day;
	}

	public void setDay(byte day) {
		this.day = day;
	}

	public byte getMonth() {
		return month;
	}

	public void setMonth(byte month) {
		this.month = month;
	}

	public byte getYear() {
		return year;
	}

	public void setYear(byte year) {
		this.year = year;
	}
	
}
