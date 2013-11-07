package com.gcc.monopoleirb.core.squares;

import java.util.EnumSet;

public class ChanceSquare extends Square {

	@Override
	public String getName() {
		return "Chance";
	}

	@Override
	public EnumSet<SquareType> getTypes() {
		return EnumSet.of(SquareType.ANY_SQUARE, SquareType.CHANCE);
	}

	@Override
	public String toString() {
		return "ChanceSquare []";
	}
}
