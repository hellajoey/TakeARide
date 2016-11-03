package com.testzone.takearide.selectFare;

import com.testzone.takearide.model.RiderList;
import com.testzone.takearide.selectfare.SelectFarePresenter;
import com.testzone.takearide.selectfare.SelectFareView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SelectFarePresenterTest {

	@Mock
	SelectFareView view;

	@Captor
	private ArgumentCaptor<RiderList.Fare[]> fareList = ArgumentCaptor.forClass(RiderList.Fare[].class);

	private SelectFarePresenter presenter;
	private String adultFare1Description = "2.5 Hour Ticket";

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		presenter = new SelectFarePresenter(view, RiderList.Rider.TYPE_ADULT);
	}

	@After
	public void tearDown() {
		presenter.detachView();
	}

	@Test
	public void onGetFareListError() {
		int anyInteger = any(Integer.class);
		presenter.onGetFareListError(anyInteger);

		verify(view).displayMessage(anyInteger);
	}

	@Test
	public void onGetFareListSuccess() {
		presenter.load();

		verify(view).setFareList(fareList.capture());

		// Not ideal but it gets the job done with static data
		assertEquals(fareList.getValue()[0].description, adultFare1Description);
	}
}