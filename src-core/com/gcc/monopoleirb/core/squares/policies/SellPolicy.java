package com.gcc.monopoleirb.core.squares.policies;

import java.util.ArrayList;
import java.util.List;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.RuleTools;
import com.gcc.monopoleirb.core.squares.Field;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.PropertySquare;
import com.gcc.monopoleirb.core.squares.SquareType;
import com.gcc.monopoleirb.ui.IUserInterface;

public class SellPolicy {

	public void sellPropertiesByAuction(GameModel context, IUserInterface ui,
			Player player) {
		List<PropertySquare> selectedProps = ui.askUserForProperties(context,
				player, player.getOwnedSquare(), 1,
				"Please, select a property to sell : ");
		for (PropertySquare prop : selectedProps) {
			// 1. If the field contains buildings : Sell all buildings
			if (prop.isType(SquareType.FIELD_SQUARE)) {
				Field f = (Field) prop;
				BuildPolicy policy = f.getBuildPolicy();
				if ((policy.getHouseNumber() > 0 || policy.getHotelNumber() > 0)
						&& ui.askUserForBoolean("Before selling the field, you must sell "
								+ "all of houses/hotel built on it ! OK ?")) {
					sellBuilding(context, ui, player, f);
				}
			}
			// 2. Start auction
			new AuctionPolicy().startNewAuction(prop, context, ui,
					prop.getOwner(), prop.getOwner().getBank());
		}
	}

	public void sellProperty(GameModel context, PropertySquare soldSquare,
			Player seller, Player newOwner) {
		if (soldSquare == null || seller == null || newOwner == null) {
			return;
		}
		newOwner.getBank().sendMoney(seller.getBank(), soldSquare.getPrice());

		List<ISquare> ownedSquares = soldSquare.getOwner().getOwnedSquare();
		ownedSquares.remove(soldSquare);

		soldSquare.setOwner(newOwner);
		seller.getOwnedSquare().add(soldSquare);
	}

	public void sellAllBuildingsInAFamily(GameModel context,
			IUserInterface ui, Player player, PropertySquare selectedProp) {
		List<ISquare> familySquares = RuleTools.getSquaresInFamily(context,
				player, selectedProp.getFamily());
		for (ISquare s : familySquares) {
			if (s.isType(SquareType.FIELD_SQUARE) == false) {
				continue;
			}
			Field f = (Field) s;
			sellBuilding(context, ui, player, f);
		}
	}

	public void sellSelectedBuildings(GameModel context, IUserInterface ui,
			Player player) {
		List<ISquare> ownedFields = new ArrayList<ISquare>();
		// 1. Select only fields
		for (ISquare prop : player.getOwnedSquare()) {
			if (prop.isType(SquareType.FIELD_SQUARE) == false) {
				continue;
			}
			Field f = (Field) prop;
			if (f.getBuildPolicy().getHouseNumber() == 0
					&& f.getBuildPolicy().getHotelNumber() == 0) {
				continue;
			}
			ownedFields.add((Field) prop);
		}

		if (ownedFields.size() == 0) {
			ui.displayMessage("You have no building to sell !");
			return;
		}

		List<PropertySquare> selectedProps = ui.askUserForProperties(context,
				player, ownedFields, -1,
				"Please select the property where building(s) will be sold : ");

		for (ISquare s : selectedProps) {
			Field f = (Field) s;
			sellBuilding(context, ui, player, f);
		}
	}

	private void sellBuilding(GameModel context, IUserInterface ui,
			Player player, Field f) {
		int answer = 0;
		while (answer != -10) {
			answer = f.getBuildPolicy().sellBuilding();
			// HOTEL CASE
			if (answer == -1) {
				player.getBank().receiveMoney(context.getMainBank(),
						f.getBuildPolicy().HOTEL_PRICE);
			}
			// HOUSE CASE
			else if (answer >= 0) {
				player.getBank().receiveMoney(context.getMainBank(),
						f.getBuildPolicy().HOUSE_PRICE);
			}
		}
	}
}
