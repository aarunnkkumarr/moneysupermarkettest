package com.moneysupermarket.validator;

import com.moneysupermarket.domain.Apple;
import com.moneysupermarket.domain.Color;
import com.moneysupermarket.domain.Taste;

public class AppleValidator implements FruitValidator<Apple> {

	private static final double MINIMUM_WEIGHT = 20.00;
	private static final double MAXIMUM_WEIGTH = 100.00;

	@Override
	public boolean validateForWeight(Apple apple) {
		return apple.getWeight() >= MINIMUM_WEIGHT && apple.getWeight() <= MAXIMUM_WEIGTH ? true : false;
	}

	@Override
	public boolean canBePeeled(Apple apple) {
		return apple.getColor() == Color.BLUE ? isSpecialPeelerRequired(apple) : true;
	}

	@Override
	public boolean validate(Apple fruit) {
		return validateForWeight(fruit) && isPeelable(fruit) && isAppleEdible(fruit);
	}

	private boolean isSpecialPeelerRequired(Apple apple) {
		return apple.getColor() == Color.BLUE ? true : false;
	}

	private boolean isPeelable(Apple apple) {
		return !apple.isInfected() && isAppleEdible(apple) ? true : false;
	}

	private boolean isAppleEdible(Apple apple) {
		return apple.getTaste().getValue() > Taste.SOUR.getValue();
	}
}
