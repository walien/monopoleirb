package com.gcc.monopoleirb.core.squares;

import java.util.EnumSet;

public class FreeParkSquare extends Square {

	private String displayName;

	public FreeParkSquare(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String getName() {
		return displayName;
	}

	@Override
	public EnumSet<SquareType> getTypes() {
		return EnumSet.of(SquareType.ANY_SQUARE, SquareType.FREE_PARK_SQUARE);
	}

	@Override
	public String toString() {
		return "FreeParkSquare []";
	}
}
