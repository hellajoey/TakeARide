package com.testzone.takearide.confirm;

import com.testzone.takearide.data.DataService;
import com.testzone.takearide.model.Fare;

public class ConfirmPresenter {

	private DataService dataService;
	private ConfirmView view;

	public ConfirmPresenter(ConfirmView view, Fare fare) {
		dataService = new DataService(); // TODO: 11/2/16 -- Inject via DI with real implementation.
		this.view = view;
	}

	public void load() {
		// FIXME: 11/3/16
	}

	public void detachView() {
		view = null;
		dataService = null;
	}
}
