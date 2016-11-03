package com.testzone.takearide.selectrider;

import com.testzone.takearide.data.DataService;
import com.testzone.takearide.data.handlers.GetRiderListHandler;

public class SelectRiderPresenter implements GetRiderListHandler {

	private DataService dataService;
	private SelectRiderView view;

	public SelectRiderPresenter(SelectRiderView view) {
		dataService = new DataService(); // TODO: 11/2/16 -- Inject via DI with real implementation.
		this.view = view;
	}

	public void load() {
		dataService.getRiderList(this);
	}

	@Override
	public void onGetRiderListError(int stringId) {
		if (view == null) {
			return;
		} else {
			view.displayMessage(stringId);
		}
	}

	@Override
	public void onGetRiderListSuccess() {
		if (view == null) {
			return;
		} else {
			// FIXME: 11/2/16
		}
	}

	protected void detachView() {
		view = null;
		dataService = null;
	}
}
