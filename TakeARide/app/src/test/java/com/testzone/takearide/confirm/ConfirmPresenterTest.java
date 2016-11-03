package com.testzone.takearide.confirm;

import com.testzone.takearide.model.Fare;
import com.testzone.takearide.model.RiderList;

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
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConfirmPresenterTest {

	@Mock
	ConfirmView view;

	@Captor
	private ArgumentCaptor<Float> cost;
	@Captor
	private ArgumentCaptor<Integer> quantity;


	private ConfirmPresenter presenter;
	private Fare fare;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		fare = new Fare();
		fare.description = "2.5 Hour Ticket";
		fare.price = 1.5f;

		presenter = new ConfirmPresenter(view, RiderList.Rider.ADULT, fare);
	}

	@After
	public void tearDown() {
		presenter.detachView();
	}

	@Test
	public void adjustQuantity() {
		presenter.adjustQuantity(1);

		verify(view).setCurrentPurchase(cost.capture(), quantity.capture());

		// Not ideal but it gets the job done with static data
		assertEquals(cost.getValue(), fare.price * 2);
		assertEquals(quantity.getValue().intValue(), 2);
	}
}