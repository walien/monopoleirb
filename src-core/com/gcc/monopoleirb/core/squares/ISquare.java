package com.gcc.monopoleirb.core.squares;

import java.util.EnumSet;

public interface ISquare {

	String getName();

	EnumSet<SquareType> getTypes();

	boolean isType(SquareType type);
}
