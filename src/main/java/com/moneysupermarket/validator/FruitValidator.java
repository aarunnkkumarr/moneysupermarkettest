package com.moneysupermarket.validator;

import com.moneysupermarket.domain.Fruit;

public interface FruitValidator<T extends Fruit> {
	
	public boolean validateForWeight(T fruit);

	public boolean canBePeeled(T fruit);

	public boolean validate(T fruit);

}
