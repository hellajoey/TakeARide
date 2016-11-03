package com.testzone.takearide.selectfare;

import com.testzone.takearide.model.Fare;

public interface SelectFareView {
	void setFareList(String riderType, Fare[] fareList);

	void displayMessage(int stringId);
}
