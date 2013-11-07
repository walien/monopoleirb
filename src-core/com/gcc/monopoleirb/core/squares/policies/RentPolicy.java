package com.gcc.monopoleirb.core.squares.policies;

/**
 * A class which defines the price of the rent of a field depending on the
 * number of houses and hotels built on
 * 
 * @author Elian ORIOU <elian.oriou@gmail.com>
 * 
 */

public class RentPolicy {

	public int RENT_PRICE;

	public int RENT_PRICE_1_HOUSE;
	public int RENT_PRICE_2_HOUSE;
	public int RENT_PRICE_3_HOUSE;
	public int RENT_PRICE_4_HOUSE;

	public int RENT_PRICE_1_HOTEL;

	public int getRentPrice(BuildPolicy buildPolicy) {

		// Price with n houses
		if (buildPolicy.getHouseNumber() > 0) {
			switch (buildPolicy.getHouseNumber()) {
			case 1:
				return RENT_PRICE_1_HOUSE;
			case 2:
				return RENT_PRICE_2_HOUSE;
			case 3:
				return RENT_PRICE_3_HOUSE;
			case 4:
				return RENT_PRICE_4_HOUSE;
			}
			return -1;
		}
		// Price with n hotels
		else if (buildPolicy.getHotelNumber() > 0) {
			return RENT_PRICE_1_HOTEL;
		}
		// Price with no houses and no hotels
		else {
			return RENT_PRICE;
		}
	}

	@Override
	public String toString() {
		return "RentPolicy [RENT_PRICE=" + RENT_PRICE + ", RENT_PRICE_1_HOUSE="
				+ RENT_PRICE_1_HOUSE + ", RENT_PRICE_2_HOUSE="
				+ RENT_PRICE_2_HOUSE + ", RENT_PRICE_3_HOUSE="
				+ RENT_PRICE_3_HOUSE + ", RENT_PRICE_4_HOUSE="
				+ RENT_PRICE_4_HOUSE + ", RENT_PRICE_1_HOTEL="
				+ RENT_PRICE_1_HOTEL + "]";
	}

}