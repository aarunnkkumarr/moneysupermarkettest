package com.moneysupermarket.service;

import org.junit.Before;
import org.junit.Test;

import com.moneysupermarket.domain.Apple;
import com.moneysupermarket.domain.Color;
import com.moneysupermarket.domain.Taste;
import com.moneysupermarket.validator.AppleValidator;
import com.moneysupermarket.validator.FruitValidator;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppleServiceImplTest {

	FruitValidator<Apple> appleValidator;
	AppleService appleService;

	@Before
	public void setup() {
		appleValidator = new AppleValidator();
		appleService = new AppleServiceImpl(appleValidator);
	}

	@Test
	public void given_GreenApple_is_Peelable_ThenReturn_True() {
		Apple apple = createApple(Color.GREEN, 20, Taste.TOOSWEET, false);
		assertThat(appleService.isApplePeelable(apple), equalTo(true));
	}
	
	
	@Test
	public void given_GreenApple_is_NotPeelable_ThenReturn_False() {
		Apple apple = createApple(Color.GREEN, 20, Taste.SOUR, true);
		assertThat(appleService.isApplePeelable(apple), equalTo(false));
	}

	@Test
	public void given_RedApple_is_Peelable_ThenReturn_True() {
		Apple apple = createApple(Color.RED, 20, Taste.TOOSWEET, false);
		assertThat(appleService.isApplePeelable(apple), equalTo(true));
	}
	
	@Test
	public void given_RedApple_is_NotPeelable_ThenReturn_False() {
		Apple apple = createApple(Color.RED, 20, Taste.SOUR, true);
		assertThat(appleService.isApplePeelable(apple), equalTo(false));
	}
	
	@Test
	public void given_BlueApple_is_Peelable_ThenReturn_True() {
		Apple apple = createApple(Color.BLUE, 20, Taste.TOOSWEET, false);
		assertThat(appleService.isApplePeelable(apple), equalTo(true));
	}
	
	@Test
	public void given_BlueApple_is_NotPeelable_ThenReturn_False() {
		Apple apple = createApple(Color.RED, 20, Taste.SOUR, true);
		assertThat(appleService.isApplePeelable(apple), equalTo(false));
	}
	
	@Test(expected=RuntimeException.class)
	public void given_Apple_is_NotEatable_ThrowsException(){
		Apple apple = createApple(Color.RED, 20, Taste.SOUR, true);
		appleService.eatApple(apple);
	}
	
	@Test 
	public void given_Apple_is_Eatable_ThrowsNoException(){
		Apple apple = createApple(Color.RED, 20, Taste.TOOSWEET, false);
		appleService.eatApple(apple);
	}
	
	private Apple createApple(Color color, double weight, Taste taste, boolean infected) {
		return new Apple(color, weight, taste, infected);
	}
}
