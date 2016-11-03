package com.testzone.takearide.confirm;

import android.os.Bundle;
import android.widget.TextView;

import com.testzone.takearide.R;
import com.testzone.takearide.app.AppActivity;
import com.testzone.takearide.model.Fare;
import com.testzone.takearide.selectfare.SelectFarePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ConfirmActivity extends AppActivity implements ConfirmView {

	@Bind(R.id.riderView)
	TextView riderView;
	@Bind(R.id.fareView)
	TextView fareView;

	private ConfirmPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm);
		overridePendingTransition();

		ButterKnife.bind(this);

		// TODO: 11/3/16 -- Consider sending rider information as a parcelable.
		Bundle bundle = getIntent().getExtras();
		String riderType = bundle.getString(SelectFarePresenter.KEY_RIDER_TYPE);
		String fareDescription = bundle.getString(SelectFarePresenter.KEY_FARE_DESCRIPTION);
		float price = bundle.getFloat(SelectFarePresenter.KEY_FARE_PRICE);
		Fare fare = new Fare();
		fare.description = fareDescription;
		fare.price = price;

		presenter = new ConfirmPresenter(this, riderType, fare);
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

	@Override
	public void setFareViews(String riderType, String fareDescription) {
		riderView.setText(riderType);
		fareView.setText(fareDescription);
	}
}
