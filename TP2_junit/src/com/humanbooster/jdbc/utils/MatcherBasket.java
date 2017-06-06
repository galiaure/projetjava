package com.humanbooster.jdbc.utils;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.humanbooster.jdbc.objects.Basket;

public class MatcherBasket extends TypeSafeMatcher<Basket> {
private Basket basketExpected;
	
	private MatcherBasket(Basket basketExpected) {
		this.basketExpected = basketExpected;
	}
	@Override
	public void describeTo(Description description) {
		description.appendValue(basketExpected);
	}

	@Override
	protected boolean matchesSafely(Basket itemBasket) {
		if(itemBasket.getColor().equals(basketExpected.getColor())
				&& itemBasket.getBrand().equals(basketExpected.getBrand())
				&& itemBasket.getPrice() == basketExpected.getPrice() ) {
			return true;
		}else{
			return false;
		}
	}
	
	public static MatcherBasket myEquals(Basket basketExpected){
		return new MatcherBasket(basketExpected);
	}
}


