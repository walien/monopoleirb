package com.gcc.monopoleirb.core.squares.policies;

import com.gcc.monopoleirb.core.cards.CardsBundle;
import com.gcc.monopoleirb.core.cards.IGameCard;
import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.domain.DicePair;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.RuleTools;
import com.gcc.monopoleirb.core.squares.JailSquare;
import com.gcc.monopoleirb.ui.IUserInterface;

public class JailPolicy {

	public boolean goInJail(IUserInterface ui, JailSquare jail, Player player,
			DicePair dices) {

		// 1. The player is already in Jail
		if (jail.isInJail(player)) {
			// 1.1 Get out from jail if the player has made 3 turns in jail or
			// if he has made a double dice
			if (jail.getJailTurnsNumber(player) == Constants.KEEP_IN_JAIL_TURNS
					|| dices.isDouble()) {
				jail.getOutFromJail(player);
				player.setCanMove(true);
				ui.displayMessage(player.getDisplayedForm()
						+ " got out from jail !");
			}
			// 1.2 Otherwise the player will make a new turn in jail
			else {
				// If the player had a "GetOutFromJailChanceCard", he can get
				// out from jail
				if (useChanceCardToGetOut(player, jail, ui)) {
					return false;
				}
				ui.displayMessage(player.getDisplayedForm()
						+ " made another round in jail !");
				jail.newTurnInJail(player);
			}
		}
		// 2. Otherwise, he goes to jail for the first time
		else {
			// If the player had a "GetOutFromJailChanceCard", he can get
			// out from jail
			if (useChanceCardToGetOut(player, jail, ui)) {
				return false;
			}
			player.setCanMove(false);
			jail.goToJail(player);
			ui.displayMessage(player.getDisplayedForm() + " goes to jail !");
		}
		return true;
	}

	private boolean useChanceCardToGetOut(Player player, JailSquare jail,
			IUserInterface ui) {
		IGameCard card = RuleTools.hadGetOutFromJailChanceCard(player);
		if (card != null) {
			if (ui
					.askUserForBoolean("You have a card \"Jail Exit\". Would you use it ?")) {
				jail.getOutFromJail(player);
				player.getCardsBundle().removeCard(card,
						CardsBundle.CHANCE_CARD);
				ui.displayMessage(player.getDisplayedForm()
						+ " has used his chance card to get out from jail !");
				return true;
			}
		}
		return false;
	}
}
