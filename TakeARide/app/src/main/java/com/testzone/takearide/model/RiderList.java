package com.testzone.takearide.model;

public class RiderList {
    public Rider Adult;
	public Rider Child;
	public Rider Senior;

	public class Rider {
		public static final String ADULT = "Adult";
		public static final String CHILD = "Child";
		public static final String SENIOR = "Senior";

		public Fare[] fares;
		public String subtext;
	}
}
