package com.testzone.takearide.selectfare;

import com.testzone.takearide.model.RiderList;

public interface SelectFareView {
	void setFareList(RiderList.Fare[] fareList);

	void displayMessage(int stringId);
}
