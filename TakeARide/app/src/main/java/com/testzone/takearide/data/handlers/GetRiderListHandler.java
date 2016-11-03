package com.testzone.takearide.data.handlers;

import com.testzone.takearide.model.RiderList;

public interface GetRiderListHandler {
	void onGetRiderListError(int stringId);

	void onGetRiderListSuccess(RiderList riderList);
}
