package com.testzone.takearide.views;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.testzone.takearide.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ItemView extends LinearLayout {

	@Bind(R.id.titleView)
	TextView titleView;
	@Bind(R.id.subtextView)
	TextView subtextView;

	public ItemView(Context context, String title, String subtext) {
		super(context);
		super.inflate(context, R.layout.view_item, this);

		ButterKnife.bind(this);

		titleView.setText(title);
		subtextView.setText((subtext == null) ? "" : subtext);
	}
}