package com.testzone.takearide.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.testzone.takearide.R;
import com.testzone.takearide.data.handlers.GetFareListHandler;
import com.testzone.takearide.data.handlers.GetRiderListHandler;
import com.testzone.takearide.model.RiderList;

public class DataService {

	// TODO: 11/3/16 -- Put this in a .json file in assets folder (until we start pulling it from server)
	private static final String RIDER_LIST_JSON = "{\n" +
			"  \"Adult\": {\n" +
			"    \"fares\": [\n" +
			"      { \"description\": \"2.5 Hour Ticket\", \"price\": 2.5 },\n" +
			"      { \"description\": \"1 Day Pass\", \"price\": 5.0 },\n" +
			"      { \"description\": \"30 Day Pass\", \"price\": 100 }\n" +
			"    ],\n" +
			"    \"subtext\": null\n" +
			"  },\n" +
			"  \"Child\": {\n" +
			"    \"fares\": [\n" +
			"      { \"description\": \"2.5 Hour Ticket\", \"price\": 1.5 },\n" +
			"      { \"description\": \"1 Day Pass\", \"price\": 2.0 },\n" +
			"      { \"description\": \"30 Day Pass\", \"price\": 40.0 }\n" +
			"    ],\n" +
			"    \"subtext\": \"Ages 8-17\"\n" +
			"  },\n" +
			"  \"Senior\": {\n" +
			"    \"fares\": [\n" +
			"      { \"description\": \"2.5 Hour Ticket\", \"price\": 1.0 },\n" +
			"      { \"description\": \"1 Day Pass\", \"price\": 2.0 },\n" +
			"      { \"description\": \"30 Day Pass\", \"price\": 40.0 }\n" +
			"    ],\n" +
			"    \"subtext\": \"Ages 60+\"\n" +
			"  }\n" +
			"}";

	private RiderList getRiderList() {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(RIDER_LIST_JSON, RiderList.class);
	}

	public void getRiderList(final GetRiderListHandler getRiderListHandler) {
		RiderList riderList = getRiderList();

		if (riderList == null) {
			getRiderListHandler.onGetRiderListError(R.string.errorGetRiderList);
		} else {
			getRiderListHandler.onGetRiderListSuccess(riderList);
		}
	}

	public void getFareList(String riderType, final GetFareListHandler getFareListHandler) {
		RiderList riderList = getRiderList();

		if (riderList == null) {
			getFareListHandler.onGetFareListError(R.string.errorGetRiderList);
		} else {
			RiderList.Rider rider = null;

			switch (riderType) {
				case RiderList.Rider.ADULT:
					rider = riderList.Adult;
					break;
				case RiderList.Rider.CHILD:
					rider = riderList.Child;
					break;
				case RiderList.Rider.SENIOR:
					rider = riderList.Senior;
					break;
			}

			if (rider == null) {
				getFareListHandler.onGetFareListError(R.string.errorGetRiderList);
			} else {
				getFareListHandler.onGetFareListSuccess(rider.fares);
			}
		}
	}
}
