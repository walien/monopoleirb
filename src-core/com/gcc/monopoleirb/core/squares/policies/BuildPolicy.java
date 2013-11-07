package com.gcc.monopoleirb.core.squares.policies;

import com.gcc.monopoleirb.core.domain.Constants;

public class BuildPolicy {

	private int houseNumber;
	private int hotelNumber;

	public int HOUSE_PRICE;
	public int HOTEL_PRICE;

	public BuildPolicy() {
		houseNumber = 0;
		hotelNumber = 0;
	}

	public boolean buildHouse() {
		if (houseNumber >= Constants.MAX_BUILDINGS_PER_FIELD) {
			return false;
		}
		houseNumber++;
		return true;
	}

	public boolean buildHotel() {
		if (houseNumber < Constants.MAX_BUILDINGS_PER_FIELD || hotelNumber > 0) {
			return false;
		}
		houseNumber = 0;
		hotelNumber++;
		return true;
	}

	/**
	 * 
	 * @return -1 if a hotel has been sold, the number of remaining houses
	 *         otherwise
	 */

	public int sellBuilding() {
		if (hotelNumber == 1) {
			hotelNumber = 0;
			houseNumber = Constants.MAX_BUILDINGS_PER_FIELD;
			return -1;
		} else {
			if (houseNumber > 0) {
				houseNumber--;
				return houseNumber;
			}
			return -10;
		}
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public int getHotelNumber() {
		return hotelNumber;
	}

	@Override
	public String toString() {
		return "BuildPolicy [houseNumber=" + houseNumber + ", hotelNumber="
				+ hotelNumber + ", HOUSE_PRICE=" + HOUSE_PRICE
				+ ", HOTEL_PRICE=" + HOTEL_PRICE + "]";
	}

}
