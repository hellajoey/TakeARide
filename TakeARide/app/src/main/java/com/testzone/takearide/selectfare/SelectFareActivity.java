package com.testzone.takearide.selectfare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.testzone.takearide.R;
import com.testzone.takearide.app.AppActivity;
import com.testzone.takearide.confirm.ConfirmActivity;
import com.testzone.takearide.model.Fare;
import com.testzone.takearide.selectrider.SelectRiderPresenter;
import com.testzone.takearide.views.ItemView;

import java.text.NumberFormat;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SelectFareActivity extends AppActivity implements SelectFareView {

	@Bind(R.id.itemContainer)
	LinearLayout itemContainer;

	private SelectFarePresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_fare);
		overridePendingTransition();

		ButterKnife.bind(this);

		// TODO: 11/3/16 -- Consider sending fare information as a parcelable.
		Bundle bundle = getIntent().getExtras();
		String riderTye = bundle.getString(SelectRiderPresenter.KEY_RIDER_TYPE);

		presenter = new SelectFarePresenter(this, riderTye);
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
	public void setFareList(String riderType, Fare[] fareList) {
		itemContainer.removeAllViews();

		for (int i = 0; i < fareList.length; i++) {
			setItemView(riderType, fareList[i]);
		}
	}

	private void setItemView(String riderType, Fare fare) {
		ItemView riderView = new ItemView(this, fare.description, formatCurrency(fare.price), getOnClickListener(riderType, fare));
		itemContainer.addView(riderView);
	}

	private String formatCurrency(float value) {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
		return numberFormat.format(value);
	}

	private View.OnClickListener getOnClickListener(final String riderType, final Fare fare) {
		return new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(SelectFareActivity.this, ConfirmActivity.class);
				intent.putExtra(SelectFarePresenter.KEY_RIDER_TYPE, riderType);
				intent.putExtra(SelectFarePresenter.KEY_FARE_DESCRIPTION, fare.description);
				intent.putExtra(SelectFarePresenter.KEY_FARE_PRICE, fare.price);
				startActivityForResult(intent, SelectRiderPresenter.RESULT_CODE); // FIXME: 11/3/16 -- this should be passed through
				overridePendingTransition(0, 0);
			}
		};
	}

	@Override
	public void displayMessage(int stringId) {
		Toast.makeText(this, getString(stringId), Toast.LENGTH_LONG).show();
	}
}
