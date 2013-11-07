package com.gcc.monopoleirb.core.squares;

import java.util.EnumSet;

public class TrainStation extends PropertySquare {

	public int RENT_PRICE;

	public TrainStation(String name, int price, SquareFamily family) {
		super(name, price, family);
	}

	@Override
	public EnumSet<SquareType> getTypes() {
		return EnumSet.of(SquareType.ANY_SQUARE, SquareType.PROPERTY_SQUARE,
				SquareType.TRAIN_STATION_SQUARE);
	}

}
