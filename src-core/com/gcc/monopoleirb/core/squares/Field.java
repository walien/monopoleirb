package com.gcc.monopoleirb.core.squares;

import java.util.EnumSet;

import com.gcc.monopoleirb.core.squares.policies.BuildPolicy;
import com.gcc.monopoleirb.core.squares.policies.RentPolicy;

public class Field extends PropertySquare {

	private BuildPolicy buildPolicy;
	private RentPolicy rentPolicy;

	public Field(String name, int price, SquareFamily family) {
		super(name, price, family);
		this.buildPolicy = new BuildPolicy();
		this.rentPolicy = new RentPolicy();
	}

	public BuildPolicy getBuildPolicy() {
		return buildPolicy;
	}

	public RentPolicy getRentPolicy() {
		return rentPolicy;
	}

	@Override
	public EnumSet<SquareType> getTypes() {
		return EnumSet.of(SquareType.ANY_SQUARE, SquareType.PROPERTY_SQUARE,
				SquareType.FIELD_SQUARE);
	}
}
