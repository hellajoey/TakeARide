package com.testzone.takearide.confirm;

import com.testzone.takearide.R;
import com.testzone.takearide.data.DataService;
import com.testzone.takearide.model.Fare;

public class ConfirmPresenter {

	private DataService dataService;
	private ConfirmView view;
	private String riderType;
	private Fare fare;
	private int quantity;

	public ConfirmPresenter(ConfirmView view, String riderType, Fare fare) {
		dataService = new DataService(); // TODO: 11/2/16 -- Inject via DI with real implementation.
		this.view = view;
		this.riderType = riderType;
		this.fare = fare;
		quantity = 1;
	}

	public void load() {
		view.setFareViews(riderType, fare.description);
		setCurrentPurchase();
	}

	public void setCurrentPurchase() {
		view.setCurrentPurchase(fare.price * quantity, quantity);
	}

	public void adjustQuantity(int delta) {
		quantity = Math.max(quantity + delta, 1);
		setCurrentPurchase();
	}

	public void confirmPurchase() {
		view.displayMessage(R.string.confirm_doneMessage);
		// FIXME: 11/3/16 -- need to return home
	}

	public void detachView() {
		view = null;
		dataService = null;
	}
}
