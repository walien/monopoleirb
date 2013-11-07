package com.gcc.monopoleirb.core.rules.impl;

import java.util.EnumSet;
import java.util.List;
import java.util.logging.Level;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.DicePair;
import com.gcc.monopoleirb.core.domain.PlayBoolean;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.log.MonopoleirbLogger;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.rules.RuleTools;
import com.gcc.monopoleirb.core.squares.Field;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.PropertySquare;
import com.gcc.monopoleirb.core.squares.SquareType;
import com.gcc.monopoleirb.ui.IUserInterface;

public class BuildingRule implements IRule {

	@Override
	public EnumSet<SquareType> getConcernedSquareTypes() {
		return EnumSet.of(SquareType.FIELD_SQUARE);
	}

	@Override
	public void applyRule(ISquare square, Player player, GameModel context,
			IUserInterface ui, DicePair dices, PlayBoolean canStillPlay) {

		Field f = (Field) square;
		// This rules is applied when the player is the owner of the field and
		// when he's got all fields in the field's family
		if (f.getOwner() != player
				|| !RuleTools.checkIfHasAllProperties(context, player,
						f.getFamily())) {
			return;
		}
		// The player cannot build anything on a mortgaged field
		if (f.hasBeenMortgaged()) {
			return;
		}

		boolean heHasBuiltHouse = true;

		// 1. Let the player select the appropriate fields to build on
		List<PropertySquare> selected = ui.askUserForProperties(context,
				player,
				RuleTools.minimumBuiltFields(context, player, f.getFamily()),
				1, "Please select fields to build in !");
		if (selected == null || selected.size() == 0) {
			return;
		}
		f = (Field) selected.get(0);

		// 2. He can build house
		if (player.getBank().getBalance() >= f.getBuildPolicy().HOUSE_PRICE
				&& ui.askUserForBoolean("Would you like to built an house ?")) {

			heHasBuiltHouse = f.getBuildPolicy().buildHouse();
			MonopoleirbLogger.getLogger().log(
					Level.INFO,
					"The player " + player.getDisplayedForm()
							+ " has built a house !");
		}

		// 3. He can build hotel
		if (player.getBank().getBalance() >= f.getBuildPolicy().HOTEL_PRICE) {
			if (!heHasBuiltHouse
					&& ui.askUserForBoolean("Would you like to built an hotel ?")) {
				f.getBuildPolicy().buildHotel();
			}
			MonopoleirbLogger.getLogger().log(
					Level.INFO,
					"The player " + player.getDisplayedForm()
							+ " has built a hotel!");
		}
	}
}
