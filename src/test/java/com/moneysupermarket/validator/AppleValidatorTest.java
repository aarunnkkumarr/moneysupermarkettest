package com.moneysupermarket.validator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import com.moneysupermarket.domain.Apple;
import com.moneysupermarket.domain.Color;
import com.moneysupermarket.domain.Taste;

public class AppleValidatorTest {

	Apple apple;
	AppleValidator validator;

	@Before
	public void setup() {
		apple = createApple(Color.GREEN, 100, Taste.TOOSWEET, false);
		validator = new AppleValidator();
	}

	@Test
	public void given_AppleWeight_is_19_Then_Return_False() {
		apple = createApple(Color.GREEN, 19, Taste.TOOSWEET, false);
		assertThat(validator.validateForWeight(apple), equalTo(false));

	}

	@Test
	public void given_AppleWeight_is_101_Then_Return_False() {
		apple = createApple(Color.GREEN, 101, Taste.TOOSWEET, false);
		assertThat(validator.validateForWeight(apple), equalTo(false));

	}

	@Test
	public void given_apple_Weight_is_100_Then_Return_True() {
		assertThat(validator.validateForWeight(apple), equalTo(true));

	}

	@Test
	public void given_apple_Weight_is_20_Then_Return_True() {
		apple = createApple(Color.GREEN, 20, Taste.TOOSWEET, false);
		assertThat(validator.validateForWeight(apple), equalTo(true));

	}

	@Test
	public void given_apple_is_Infected_Then_Return_False() {
		apple = createApple(Color.GREEN, 20, Taste.TOOSWEET, true);
		assertThat(validator.validate(apple), equalTo(false));
	}

	@Test
	public void given_apple_is_NotInfected_Then_Return_True() {
		apple = createApple(Color.GREEN, 20, Taste.TOOSWEET, false);
		assertThat(validator.validate(apple), equalTo(true));
	}

	@Test
	public void given_apple_is_NotEdible_Then_Return_False() {
		apple = createApple(Color.GREEN, 20, Taste.SOUR, false);
		assertThat(validator.validate(apple), equalTo(false));
	}

	@Test
	public void given_apple_is_Edible_Then_Return_True() {
		apple = createApple(Color.GREEN, 20, Taste.TOOSWEET, false);
		assertThat(validator.validate(apple), equalTo(true));
	}

	private Apple createApple(Color color, double weight, Taste taste, boolean infected) {
		return new Apple(color, weight, taste, infected);
	}
}
