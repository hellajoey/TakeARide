package com.testzone.takearide.selectRider;

import com.testzone.takearide.selectrider.SelectRiderPresenter;
import com.testzone.takearide.selectrider.SelectRiderView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SelectRiderPresenterTest {

	@Mock
	SelectRiderView mView;

	private SelectRiderPresenter presenter;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		presenter = new SelectRiderPresenter(mView);
	}

	@After
	public void tearDown() {
	}

	@Test
	public void getInt() {
		presenter.load();
	}
}