package com.gcc.monopoleirb.core.squares;

import java.util.EnumSet;

import com.gcc.monopoleirb.core.domain.Player;

public class PropertySquare extends Square {

	private String name;
	private int price;
	private Player owner;
	private SquareFamily family;
	private boolean hasBeenMortgaged;

	public int MORGAGING_VALUE;

	public PropertySquare(String name, int price, SquareFamily family) {
		this.name = name;
		this.price = price;
		this.family = family;
		this.hasBeenMortgaged = false;
	}

	public int getPrice() {
		return price;
	}

	protected void setPrice(int price) {
		this.price = price;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	@Override
	public String getName() {
		return name;
	}

	public SquareFamily getFamily() {
		return family;
	}

	@Override
	public EnumSet<SquareType> getTypes() {
		return EnumSet.of(SquareType.ANY_SQUARE, SquareType.PROPERTY_SQUARE);
	}

	public boolean hasBeenMortgaged() {
		return hasBeenMortgaged;
	}

	public void setHasBeenMortgaged(boolean hasBeenMortgaged) {
		this.hasBeenMortgaged = hasBeenMortgaged;
	}

	@Override
	public String toString() {
		return "PropertySquare [MORGAGING_VALUE=" + MORGAGING_VALUE
				+ ", family=" + family.getDisplayName() + ", hasBeenMortgaged="
				+ hasBeenMortgaged + ", name=" + name + ", owner=" + owner
				+ ", price=" + price + "]";
	}
}
