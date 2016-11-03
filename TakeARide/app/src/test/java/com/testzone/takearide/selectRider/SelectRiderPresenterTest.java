package com.testzone.takearide.selectRider;

import com.testzone.takearide.model.RiderList;
import com.testzone.takearide.selectrider.SelectRiderPresenter;
import com.testzone.takearide.selectrider.SelectRiderView;

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
public class SelectRiderPresenterTest {

	@Mock
	SelectRiderView view;

	@Captor
	private ArgumentCaptor<RiderList> riderList;

	private SelectRiderPresenter presenter;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		presenter = new SelectRiderPresenter(view);
	}

	@After
	public void tearDown() {
		presenter.detachView();
	}

	@Test
	public void onGetRiderListError() {
		int anyInteger = any(Integer.class);
		presenter.onGetRiderListError(anyInteger);

		verify(view).displayMessage(anyInteger);
	}

	@Test
	public void onGetRiderListSuccess() {
		presenter.load();

		verify(view).setRiderList(riderList.capture());

		// Not ideal but it gets the job done with static data
		assertEquals(riderList.getValue().Adult.fares[0].description, "2.5 Hour Ticket");
	}
}