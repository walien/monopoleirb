package com.gcc.monopoleirb.core.squares;

import java.util.EnumSet;

public class TaxSquare extends Square {

	private String name;
	private int taxAmount;

	public TaxSquare(String name, int taxAmount) {
		this.name = name;
		this.taxAmount = taxAmount;
	}

	public int getTaxAmount() {
		return taxAmount;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public EnumSet<SquareType> getTypes() {
		return EnumSet.of(SquareType.ANY_SQUARE, SquareType.TAX_SQUARE);
	}

	@Override
	public String toString() {
		return "TaxSquare [name=" + name + ", taxAmount=" + taxAmount + "]";
	}
}
