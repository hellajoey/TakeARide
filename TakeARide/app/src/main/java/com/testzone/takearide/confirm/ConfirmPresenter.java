package com.testzone.takearide.confirm;

import com.testzone.takearide.data.DataService;
import com.testzone.takearide.model.Fare;

public class ConfirmPresenter {

	private DataService dataService;
	private ConfirmView view;
	private String riderType;
	private Fare fare;

	public ConfirmPresenter(ConfirmView view, String riderType, Fare fare) {
		dataService = new DataService(); // TODO: 11/2/16 -- Inject via DI with real implementation.
		this.view = view;
		this.riderType = riderType;
		this.fare = fare;
	}

	public void load() {
		view.setFareViews(riderType, fare.description);
	}

	public void detachView() {
		view = null;
		dataService = null;
	}
}
