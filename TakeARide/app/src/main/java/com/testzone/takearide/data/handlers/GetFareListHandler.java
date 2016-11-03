package com.testzone.takearide.data.handlers;

import com.testzone.takearide.model.Fare;

public interface GetFareListHandler {
	void onGetFareListError(int stringId);

	void onGetFareListSuccess(Fare[] fareList);
}
