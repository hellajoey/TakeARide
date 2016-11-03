package com.testzone.takearide.model;

public class RiderList {
    public Rider Adult;
	public Rider Child;
	public Rider Senior;

	public class Rider {
		public static final String TYPE_ADULT = "Rider.TYPE_ADULT";
		public static final String TYPE_CHILD = "Rider.TYPE_CHILD";
		public static final String TYPE_SENIOR = "Rider.TYPE_SENIOR";

		public Fare[] fares;
		public String subtext;
	}

	public class Fare {
		public String description;
		public float price;
	}
}
