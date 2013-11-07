package com.gcc.monopoleirb.core.rules.impl;

import java.util.EnumSet;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.DicePair;
import com.gcc.monopoleirb.core.domain.PlayBoolean;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.PropertySquare;
import com.gcc.monopoleirb.core.squares.SquareType;
import com.gcc.monopoleirb.core.squares.policies.AuctionPolicy;
import com.gcc.monopoleirb.ui.IUserInterface;

public class BuyingAPropertyRule implements IRule {

	@Override
	public EnumSet<SquareType> getConcernedSquareTypes() {
		return EnumSet.of(SquareType.PROPERTY_SQUARE);
	}

	@Override
	public void applyRule(ISquare square, Player player, GameModel context,
			IUserInterface ui, DicePair dices, PlayBoolean canStillPlay) {

		// A player can't buy a property during the first round
		if (player.getBoardRounds() == 1) {
			return;
		}
		PropertySquare prop = (PropertySquare) square;

		// 1. The field belongs to the bank
		if (prop.getOwner() == null) {
			// 1.1 Buy the field
			if (ui.askUserForBoolean(player.getDisplayedForm()
					+ " would you like to buy the field named "
					+ prop.getName() + " ?")) {
				if (player.getBank().getBalance() >= prop.getPrice()) {
					prop.setOwner(player);
					player.getOwnedSquare().add(prop);
					player.getBank().sendMoney(context.getMainBank(),
							prop.getPrice());
					ui.displayMessage(player.getName() + " has bought "
							+ prop.getName());
				} else {
					ui.displayMessage("The player is too poor to buy this property !");
				}
			}
			// 1.2 Sell it by auction
			else {
				new AuctionPolicy().startNewAuction(prop, context, ui, null,
						context.getMainBank());
			}
		}
		// 2. The field already belongs to the player
		else if (prop.getOwner().equals(player)) {
			return;
		}
		// 3. The field already belongs to another player (managed by another
		// rule : RentingAPropertyRule)
		else {
			return;
		}
	}
}
