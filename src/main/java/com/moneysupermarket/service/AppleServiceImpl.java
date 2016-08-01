package com.moneysupermarket.service;

import com.moneysupermarket.domain.Apple;
import com.moneysupermarket.validator.FruitValidator;

public class AppleServiceImpl implements AppleService {

	private FruitValidator<Apple> fruitValidator;

	public AppleServiceImpl(final FruitValidator<Apple> fruitValidator) {
		this.fruitValidator = fruitValidator;
	}

	@Override
	public boolean isApplePeelable(final Apple apple) {
		return fruitValidator.validate(apple);
	}

	@Override
	public void eatApple(Apple apple) {
		
		boolean isApplePeelable = isApplePeelable(apple) && this.fruitValidator.canBePeeled(apple) ? true : false;
		if (!isApplePeelable) {
			throw new RuntimeException("Apple is not peelable,hence cannot be eaten");
		}
	}
}
