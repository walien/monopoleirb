package com.gcc.monopoleirb.core.squares.policies;

import java.util.List;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.RuleTools;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.PropertySquare;
import com.gcc.monopoleirb.ui.IUserInterface;

public class MortgagePolicy {

	public void launchMortgage(GameModel context, IUserInterface ui,
			Player player, int taxAmount) {

		// Get mortgageable properties
		List<ISquare> mortgageableSquares = RuleTools
				.getMortgageableProperties(context, player);
		while (true) {

			if (mortgageableSquares.size() == 0) {
				ui.displayMessage("There are no more property to mortgage !");
				break;
			}

			List<PropertySquare> selectedProps = ui.askUserForProperties(
					context, player, mortgageableSquares, 1,
					"Please, select a property to mortgage !");

			if (selectedProps == null || selectedProps.size() == 0) {
				continue;
			}
			PropertySquare selectedProp = selectedProps.get(0);

			// 1. If the player has bought all fields of a family he must sell
			// all buildings built on each fields of the family in order to
			// mortgage
			if (RuleTools.checkIfHasAllProperties(context, player,
					selectedProp.getFamily())
					&& ui.askUserForBoolean("If a field in the family that you "
							+ "choosed has buildings, they will be sold ! OK ?")) {
				new SellPolicy().sellAllBuildingsInAFamily(context, ui, player,
						selectedProp);
				if (askToContinue(player, ui, taxAmount)) {
					break;
				}
			}

			// 2. The property is mortgaged
			selectedProp.setHasBeenMortgaged(true);
			// 3. The mortgaged properties is removed from the original
			// list in order to propose non-already mortgaged properties to the
			// player
			mortgageableSquares.remove(selectedProp);
			// 4. The player received the mortgaging money
			player.getBank().receiveMoney(context.getMainBank(),
					selectedProp.MORGAGING_VALUE);

			// 5. If the player can pay the tax without mortgaging let him
			// choose what to DO !
			if (askToContinue(player, ui, taxAmount)) {
				break;
			}
		}
	}

	private boolean askToContinue(Player player, IUserInterface ui,
			int taxAmount) {
		if (player.getBank().getBalance() >= taxAmount) {
			return ui
					.askUserForList(
							"Your have enough money to pay the tax without mortgaging, what do you want to do ?",
							new String[] { "Stop i'm scared !!",
									"Continue to mortgage!" }) == 0;
		}
		return false;
	}

	public void unMortgageProperty(GameModel context, Player player,
			PropertySquare prop) {
		int amount = prop.MORGAGING_VALUE
				+ (prop.MORGAGING_VALUE / Constants.MORTGAGING_PERCENTAGE);
		if (player.getBank().getBalance() < amount) {
			return;
		}
		if (player.getBank().sendMoney(context.getMainBank(), amount)) {
			prop.setHasBeenMortgaged(false);
		}
	}
}
