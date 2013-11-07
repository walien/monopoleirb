package com.gcc.monopoleirb.core.squares;

import java.util.EnumSet;

public class DepartureSquare extends Square {

	private String displayName;

	public DepartureSquare(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String getName() {
		return displayName;
	}

	@Override
	public EnumSet<SquareType> getTypes() {
		return EnumSet.of(SquareType.ANY_SQUARE, SquareType.DEPARTURE_SQUARE);
	}

	@Override
	public String toString() {
		return "DepartureSquare [name=" + getName() + "]";
	}

}
