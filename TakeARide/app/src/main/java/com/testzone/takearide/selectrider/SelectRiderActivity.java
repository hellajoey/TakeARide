package com.testzone.takearide.selectrider;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.testzone.takearide.R;
import com.testzone.takearide.app.AppActivity;
import com.testzone.takearide.model.RiderList;
import com.testzone.takearide.views.ItemView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SelectRiderActivity extends AppActivity implements SelectRiderView {

	@Bind(R.id.itemContainer)
	LinearLayout itemContainer;

	private SelectRiderPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_rider);
		overridePendingTransition();

		ButterKnife.bind(this);

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

	@Override
	public void setRiderList(RiderList riderList) {
		itemContainer.removeAllViews();

		RiderList.Rider adult = riderList.Adult;
		if (adult != null) {
			setItemView(adult, R.string.selectRider_adult, RiderList.Rider.TYPE_ADULT);
		}
		RiderList.Rider child = riderList.Child;
		if (child != null) {
			setItemView(child, R.string.selectRider_child, RiderList.Rider.TYPE_CHILD);
		}
		RiderList.Rider senior = riderList.Senior;
		if (senior != null) {
			setItemView(senior, R.string.selectRider_senior, RiderList.Rider.TYPE_SENIOR);
		}
	}

	private void setItemView(RiderList.Rider rider, int titleId, String riderType) {
		ItemView riderView = new ItemView(this, getString(titleId), rider.subtext, getOnClickListener(riderType));
		itemContainer.addView(riderView);
	}

	private View.OnClickListener getOnClickListener(final String riderType) {
		return new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(SelectRiderActivity.this, riderType, Toast.LENGTH_LONG).show(); // FIXME: 11/2/16 
			}
		};
	}

	@Override
	public void displayMessage(int stringId) {
		Toast.makeText(this, getString(stringId), Toast.LENGTH_LONG).show();
	}
}
