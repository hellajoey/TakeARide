package com.testzone.takearide.confirm;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.testzone.takearide.R;
import com.testzone.takearide.app.AppActivity;
import com.testzone.takearide.model.Fare;
import com.testzone.takearide.selectfare.SelectFarePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ConfirmActivity extends AppActivity implements ConfirmView {

	@Bind(R.id.itemContainer)
	LinearLayout itemContainer;

	private ConfirmPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm);
		overridePendingTransition();

		ButterKnife.bind(this);

		// TODO: 11/3/16 -- Consider sending fare information as a parcelable.
		Bundle bundle = getIntent().getExtras();
		String description = bundle.getString(SelectFarePresenter.KEY_FARE_DESCRIPTION);
		float price = bundle.getFloat(SelectFarePresenter.KEY_FARE_PRICE);
		Fare fare = new Fare();
		fare.description = description;
		fare.price = price;

		presenter = new ConfirmPresenter(this, fare);
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
