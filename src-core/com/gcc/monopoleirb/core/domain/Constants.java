package com.gcc.monopoleirb.core.domain;

import java.util.logging.Level;

public class Constants {

	// ----------------------
	// SYSTEM CONSTANTS
	// ----------------------

	public static final String APP_NAME = "Monopoleirb";

	public static final String APP_VERSION = "1.0";

	public static final String SYSTEM_LOG_NAME = "monopoleirbLog";

	public static final Level DEFAULT_LOG_LEVEL = Level.INFO;

	public static final String LOG_FILE_NAME = "monopoleirb_log.html";

	public static final String CONF_XSD_PATH = "resources/xsd/monopoleirb_conf.xsd";
	
	public static final String JAXB_CONTEXT_PACKAGE = "com.gcc.monopoleirb.core.domain.conf";

	// ----------------------
	// CONFIGURATION CONSTANTS
	// ----------------------

	// TAGS

	public static final String TAG_SQUARES = "squares";

	public static final String TAG_FAMILIES = "families";

	public static final String TAG_PLAYERS = "players";

	public static final String TAG_RULES = "rules";

	public static final String TAG_CHANCE_CARDS = "chance-cards";

	public static final String TAG_COMMUNITY_CHEST_CARDS = "community-chest-cards";

	public static final String TAG_DEPARTURE_SQUARE = "departure-square";

	public static final String TAG_FIELD = "field";

	public static final String TAG_TRAIN_STATION = "train-station";

	public static final String TAG_CHANCE_SQUARE = "chance-square";

	public static final String TAG_COMMUNITY_CHEST = "community-chest";

	public static final String TAG_TAX_SQUARE = "tax-square";

	public static final String TAG_PUBLIC_SERVICE = "public-service";

	public static final String TAG_JAIL = "jail";

	public static final String TAG_FREE_PARK = "free-park";

	// SUB-TAGS

	public static final String TAG_PROP_MORTGAGE_POLICY = "mortgage-policy";

	public static final String TAG_PROP_RENT_POLICY = "rent-policy";

	public static final String TAG_FIELD_BUILD_POLICY = "build-policy";

	public static final String TAG_FIELD_BUILD_POLICY_HOUSE_PRICE = "housePrice";

	public static final String TAG_FIELD_BUILD_POLICY_HOTEL_PRICE = "hotelPrice";

	// ATRIBUTES

	public static final String ATTR_PLAYER_NAME = "name";

	public static final String ATTR_PLAYER_BANK = "bank";

	public static final String ATTR_FAMILY_ID = "id";

	public static final String ATTR_FAMILY_NAME = "name";

	public static final String ATTR_FAMILY_N_OF_PROPS = "numberOfProperties";

	public static final String ATTR_DEPARTURE_NAME = "name";

	public static final String ATTR_PROP_NAME = "name";

	public static final String ATTR_PROP_FAMILY = "family";

	public static final String ATTR_PROP_BUYING_PRICE = "buyingPrice";

	public static final String ATTR_PROP_MORTGAGE_POLICY_AMOUNT = "amount";

	public static final String ATTR_FIELD_RENT_POLICY_1 = "rent-policy1";

	public static final String ATTR_FIELD_RENT_POLICY_2 = "rent-policy2";

	public static final String ATTR_FIELD_RENT_POLICY_3 = "rent-policy3";

	public static final String ATTR_FIELD_RENT_POLICY_4 = "rent-policy4";

	public static final String ATTR_FIELD_RENT_POLICY_5 = "rent-policy5";

	public static final String ATTR_TRAIN_STATION_RENTING_PRICE = "rentingPrice";

	public static final String ATTR_JAIL_NAME = "name";

	public static final String ATTR_JAIL_SIMPLE_VISIT = "simpleVisit";

	public static final String ATTR_FREE_PARK_SQUARE_NAME = "name";

	public static final String ATTR_TAX_AMOUNT = "taxAmount";

	public static final String ATTR_RULE_CLASS = "class";

	public static final String ATTR_CARD_CLASS = "class";

	// ----------------------
	// AMOUNTS
	// ----------------------

	public static final String CURRENCY = "€";

	public static final double INITIAL_BANK_AMOUNT = 1000000000000000000000.0;

	public static final double INITIAL_PLAYER_AMOUNT = 25000.0;

	public static final int NEW_ROUND_GAIN = 20000;

	public static final int MORTGAGING_PERCENTAGE = 10;

	// CHANCE CARDS AMOUNTS

	public static final int BEAUTY_FIRST_PRICE_AMOUNT = 10000;

	// ----------------------
	// GENERAL CONSTANTS
	// ----------------------

	// Turns number in jail before get out
	public static final int KEEP_IN_JAIL_TURNS = 3;

	// Number of doubles to make in order to go in jail
	public static final int DOUBLES_TO_GO_IN_JAIL = 3;

	// Max number of houses on a field
	public static final int MAX_BUILDINGS_PER_FIELD = 4;

	// If a player has all fields into a family, the rent price is multiply by
	// the factor
	public static final int FULL_FAMILY_RENT_PRICE_FACTOR = 2;

	// On a public service, the rent price is depending on the dice value
	// multiply by a factor (if the owner owns all public services of the family
	// the factor is increased)
	public static final int PUBLIC_SERVICE_RENT_FACTOR = 400;

	public static final int PUBLIC_SERVICE_FULL_FAMILY_RENT_FACTOR = 1200;
}
