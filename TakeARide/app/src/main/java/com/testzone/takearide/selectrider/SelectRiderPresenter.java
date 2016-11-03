package com.testzone.takearide.selectrider;

import com.testzone.takearide.data.DataService;

public class SelectRiderPresenter {

	private DataService dataService;
	private SelectRiderView view;

	public SelectRiderPresenter(SelectRiderView view) {
		dataService = new DataService(); // TODO: 11/2/16 -- Inject via DI with real implementation.
		this.view = view;
	}

	public void load() {
		// FIXME: 11/2/16 
	}

	protected void detachView() {
		view = null;
		dataService = null;
	}
}
