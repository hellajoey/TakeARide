package com.testzone.takearide.selectfare;

import com.testzone.takearide.R;
import com.testzone.takearide.data.DataService;
import com.testzone.takearide.data.handlers.GetFareListHandler;
import com.testzone.takearide.model.RiderList;

public class SelectFarePresenter implements GetFareListHandler {

	private DataService dataService;
	private SelectFareView view;
	private String riderType;

	public SelectFarePresenter(SelectFareView view, String riderType) {
		dataService = new DataService(); // TODO: 11/2/16 -- Inject via DI with real implementation.
		this.view = view;
		this.riderType = riderType;
	}

	public void load() {
		dataService.getFareList(riderType, this);
	}

	@Override
	public void onGetFareListError(int stringId) {
		if (view == null) {
			return;
		} else {
			view.displayMessage(stringId);
		}
	}

	@Override
	public void onGetFareListSuccess(RiderList.Fare[] fareList) {
		if (view == null) {
			return;
		} else if (fareList == null || fareList.length == 0) {
			view.displayMessage(R.string.errorGetFareList);
		} else {
			view.setFareList(fareList);
		}
	}

	public void detachView() {
		view = null;
		dataService = null;
	}
}
