package com.testzone.takearide.selectrider;

import android.os.Bundle;

import com.testzone.takearide.R;
import com.testzone.takearide.app.AppActivity;

public class SelectRiderActivity extends AppActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_rider);
		overridePendingTransition();
	}
}
