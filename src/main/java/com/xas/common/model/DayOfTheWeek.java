package com.xas.common.model;

public enum DayOfTheWeek {
	MONDAY(false),
	TUESDAY(false),
	WEDNESDAY(false),
	THURSDAY(false),
	FRIDAY(false),
	SATURDAY(true),
	SUNDAY(true);
	
	public final boolean isWeekend;
	
	private DayOfTheWeek(final boolean isWeekend) {
		this.isWeekend=isWeekend;
	}
	
	public boolean isWeekend() {
		return isWeekend;
	}
	
}
