package com.testzone.takearide.selectrider;

import com.testzone.takearide.R;
import com.testzone.takearide.data.DataService;
import com.testzone.takearide.data.handlers.GetRiderListHandler;
import com.testzone.takearide.model.RiderList;

public class SelectRiderPresenter implements GetRiderListHandler {
	public static final int RESULT_CODE = 1;
	public static final String KEY_RIDER_TYPE = "SelectRiderPresenter.KEY_RIDER_TYPE";

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
	public void onGetRiderListSuccess(RiderList riderList) {
		if (view == null) {
			return;
		} else if (riderList == null) {
			view.displayMessage(R.string.errorGetRiderList);
		} else {
			view.setRiderList(riderList);
		}
	}

	public void detachView() {
		view = null;
		dataService = null;
	}
}
