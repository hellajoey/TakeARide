package com.testzone.takearide.confirm;

public interface ConfirmView {
	void setFareViews(String riderType, String fareDescription);

	void setCurrentPurchase(float cost, int quanity);

	void displayMessage(int stringId);
}
