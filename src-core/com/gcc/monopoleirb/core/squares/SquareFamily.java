package com.gcc.monopoleirb.core.squares;

public class SquareFamily {

	private int familyID;
	private String displayName;
	private int squareNumber;

	public SquareFamily(String displayName, int squareNumber) {
		super();
		this.displayName = displayName;
		this.squareNumber = squareNumber;
	}

	public String getDisplayName() {
		return displayName;
	}

	public int getSquareNumber() {
		return squareNumber;
	}

	@Override
	public String toString() {
		return "SquareFamily [displayName=" + displayName + ", familyID="
				+ familyID + ", squareNumber=" + squareNumber + "]";
	}

}
