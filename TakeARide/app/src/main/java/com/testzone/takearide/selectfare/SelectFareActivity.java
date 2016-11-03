package com.testzone.takearide.selectfare;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.testzone.takearide.R;
import com.testzone.takearide.app.AppActivity;
import com.testzone.takearide.model.RiderList;
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
		String riderType = bundle.getString(SelectRiderPresenter.KEY_RIDER_TYPE);

		presenter = new SelectFarePresenter(this, riderType);
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
	public void setFareList(RiderList.Fare[] fareList) {
		itemContainer.removeAllViews();

		for (int i = 0; i < fareList.length; i++) {
			setItemView(fareList[i]);
		}
	}

	private void setItemView(RiderList.Fare fare) {
		ItemView riderView = new ItemView(this, fare.description, formatCurrency(fare.price), getOnClickListener(fare));
		itemContainer.addView(riderView);
	}

	private String formatCurrency(float value) {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
		return numberFormat.format(value);
	}

	private View.OnClickListener getOnClickListener(final RiderList.Fare fare) {
		return new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// FIXME: 11/3/16
			}
		};
	}

	@Override
	public void displayMessage(int stringId) {
		Toast.makeText(this, getString(stringId), Toast.LENGTH_LONG).show();
	}
}
