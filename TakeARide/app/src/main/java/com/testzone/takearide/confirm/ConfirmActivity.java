package com.testzone.takearide.confirm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.testzone.takearide.R;
import com.testzone.takearide.app.AppActivity;
import com.testzone.takearide.model.Fare;
import com.testzone.takearide.selectfare.SelectFarePresenter;
import com.testzone.takearide.selectrider.SelectRiderPresenter;

import java.text.NumberFormat;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmActivity extends AppActivity implements ConfirmView {

	@Bind(R.id.riderView)
	TextView riderView;
	@Bind(R.id.fareView)
	TextView fareView;
	@Bind(R.id.quantityView)
	TextView quantityView;
	@Bind(R.id.confirmButton)
	Button confirmButton;

	private ConfirmPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm);
		overridePendingTransition();

		ButterKnife.bind(this);

		// get the rider/fare information
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

	@OnClick(R.id.moreButton)
	public void onMoreButtonClick() {
		presenter.adjustQuantity(1);
	}

	@OnClick(R.id.fewerButton)
	public void onFewerButtonClick() {
		presenter.adjustQuantity(-1);
	}

	@OnClick(R.id.confirmButton)
	public void onConfirmButtonClick() {
		presenter.confirmPurchase();
	}

	@Override
	public void setCurrentPurchase(float cost, int quantity) {
		quantityView.setText(Integer.toString(quantity));

		String priceString = formatCurrency(cost);
		String text = String.format(getString(R.string.confirm_purchaseOrder), quantity, priceString);
		confirmButton.setText(text);
	}

	private String formatCurrency(float price) {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
		return numberFormat.format(price);
	}

	@Override
	public void setFareViews(String riderType, String fareDescription) {
		riderView.setText(riderType);
		fareView.setText(fareDescription);
	}

	@Override
	public void returnHome() {
		setResult(SelectRiderPresenter.RESULT_CODE, new Intent());
		finish();
	}
}
