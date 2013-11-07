package com.gcc.monopoleirb.core.squares;

import java.util.EnumSet;

public class PublicService extends PropertySquare {

	public PublicService(String name, int price, SquareFamily family) {
		super(name, price, family);
	}

	@Override
	public EnumSet<SquareType> getTypes() {
		return EnumSet.of(SquareType.ANY_SQUARE, SquareType.PROPERTY_SQUARE,
				SquareType.PUBLIC_SERVICE_SQUARE);
	}

}
