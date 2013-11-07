package com.gcc.monopoleirb.core.rules.impl;

import java.util.EnumSet;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.domain.DicePair;
import com.gcc.monopoleirb.core.domain.PlayBoolean;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.rules.RuleTools;
import com.gcc.monopoleirb.core.squares.Field;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.PropertySquare;
import com.gcc.monopoleirb.core.squares.SquareType;
import com.gcc.monopoleirb.core.squares.TrainStation;
import com.gcc.monopoleirb.ui.IUserInterface;

public class RentingAPropertyRule implements IRule {

	@Override
	public EnumSet<SquareType> getConcernedSquareTypes() {
		return EnumSet.of(SquareType.PROPERTY_SQUARE);
	}

	@Override
	public void applyRule(ISquare square, Player player, GameModel context,
			IUserInterface ui, DicePair dices, PlayBoolean canStillPlay) {

		PropertySquare prop = (PropertySquare) square;
		// The rule concern only player on an another player's property
		if (prop.getOwner() == null || prop.getOwner() == player) {
			return;
		}
		// The player cannot rent a mortgaged property
		if (prop.hasBeenMortgaged()) {
			return;
		}

		// If the property is a Field
		if (prop.isType(SquareType.FIELD_SQUARE)) {
			Field f = (Field) prop;
			// Pay the rent to the field owner (the rent amount is depending on
			// the number of houses and hotels built on the field : defined into
			// the rent policy)
			int rentPrice = f.getRentPolicy().getRentPrice(f.getBuildPolicy());
			// The rent price is multiply by a factor if the owner owns all
			// fields of a family (by 2 for instance)
			if (RuleTools.checkIfHasAllProperties(context, player,
					f.getFamily())) {
				rentPrice *= Constants.FULL_FAMILY_RENT_PRICE_FACTOR;
			}
			ui.displayMessage(prop.getOwner().getName()
					+ " rent his property to " + player.getName() + " ("
					+ rentPrice + ")");
			player.getBank().sendMoney(prop.getOwner().getBank(), rentPrice);
			return;
		}
		// If the property is a Public Service
		if (prop.isType(SquareType.PUBLIC_SERVICE_SQUARE)) {
			// The rent price is multiply by a factor depending on the
			// number of public services owns by the owner (400 | 1200 for
			// instance)
			int factor = Constants.PUBLIC_SERVICE_RENT_FACTOR;
			if (RuleTools.checkIfHasAllProperties(context, player,
					prop.getFamily())) {
				factor = Constants.PUBLIC_SERVICE_FULL_FAMILY_RENT_FACTOR;
			}
			int rentPrice = dices.sum() * factor;
			player.getBank().sendMoney(prop.getOwner().getBank(), rentPrice);
			ui.displayMessage(prop.getOwner().getName()
					+ " rent his property to " + player.getName() + " ("
					+ rentPrice + ")");
			return;
		}
		// If the property is a Train Station
		if (prop.isType(SquareType.TRAIN_STATION_SQUARE)) {
			TrainStation station = (TrainStation) prop;
			int rentPrice = station.RENT_PRICE;
			int numberOfTrainStations = RuleTools.numberOfPropertiesInFamily(
					context, player, station.getFamily());
			player.getBank().sendMoney(station.getOwner().getBank(),
					rentPrice * numberOfTrainStations);
			ui.displayMessage(prop.getOwner().getName()
					+ " rent his property to " + player.getName() + " ("
					+ rentPrice + ")");
			return;
		}
	}
}
