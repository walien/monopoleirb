package com.gcc.monopoleirb.core.squares;

public abstract class Square implements ISquare {

	@Override
	public boolean isType(SquareType type) {
		return getTypes().contains(type);
	}
}
