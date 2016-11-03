package com.testzone.takearide.model;

public class RiderList {
    public Rider Adult;
	public Rider Child;
	public Rider Senior;

	public class Rider {
		public Fare[] fares;
		public String subtext;
	}

	public class Fare {
		public String description;
		public float price;
	}
}
