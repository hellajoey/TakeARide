package com.testzone.takearide.selectrider;

import android.os.Bundle;

import com.testzone.takearide.R;
import com.testzone.takearide.app.AppActivity;

public class SelectRiderActivity extends AppActivity implements SelectRiderView {

	private SelectRiderPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_rider);
		overridePendingTransition();

		presenter = new SelectRiderPresenter(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		presenter.load();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		presenter.detachView();
	}
}
