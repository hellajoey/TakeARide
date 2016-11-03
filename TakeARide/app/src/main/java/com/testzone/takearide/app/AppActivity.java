package com.testzone.takearide.app;

import android.support.v7.app.AppCompatActivity;

import com.testzone.takearide.R;

abstract public class AppActivity extends AppCompatActivity {

	protected void overridePendingTransition() {
		overridePendingTransition(R.anim.in, R.anim.out);
	}
}
