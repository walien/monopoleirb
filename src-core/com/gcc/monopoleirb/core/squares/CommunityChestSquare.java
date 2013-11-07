package com.gcc.monopoleirb.core.squares;

import java.util.EnumSet;

public class CommunityChestSquare extends Square {

	@Override
	public String getName() {
		return "Caisse de Communauté";
	}

	@Override
	public EnumSet<SquareType> getTypes() {
		return EnumSet.of(SquareType.ANY_SQUARE, SquareType.COMMUNITY_CHEST);
	}

	@Override
	public String toString() {
		return "CommunityChestSquare []";
	}
}
