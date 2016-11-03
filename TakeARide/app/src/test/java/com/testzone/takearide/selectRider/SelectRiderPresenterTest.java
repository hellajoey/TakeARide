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

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SelectRiderPresenterTest {

	@Mock
	SelectRiderView view;

	private SelectRiderPresenter presenter;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		presenter = new SelectRiderPresenter(view);
	}

	@After
	public void tearDown() {
	}

	@Test
	public void onGetRiderListError() {
		int i = any(Integer.class);
		presenter.onGetRiderListError(i);
		verify(view).displayMessage(i);
	}
}