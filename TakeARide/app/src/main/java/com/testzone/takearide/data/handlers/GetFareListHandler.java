package com.testzone.takearide.data.handlers;

import com.testzone.takearide.model.RiderList;

public interface GetFareListHandler {
	void onGetFareListError(int stringId);

	void onGetFareListSuccess(RiderList.Fare[] fareList);
}
