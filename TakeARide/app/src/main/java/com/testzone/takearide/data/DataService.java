package com.testzone.takearide.data;

import com.testzone.takearide.R;
import com.testzone.takearide.data.handlers.GetRiderListHandler;

public class DataService {

	public void getRiderList(final GetRiderListHandler getRiderListHandler) {
		String jsonString = "{\n" +
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

		if (true) { // FIXME: 11/2/16
			getRiderListHandler.onGetRiderListError(R.string.errorGetRiderList);
		} else { // FIXME: 11/2/16
			getRiderListHandler.onGetRiderListSuccess();
		}
	}
}
