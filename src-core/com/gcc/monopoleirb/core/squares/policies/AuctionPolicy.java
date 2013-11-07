package com.gcc.monopoleirb.core.squares.policies;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.bank.Bank;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.squares.PropertySquare;
import com.gcc.monopoleirb.core.squares.SquareType;
import com.gcc.monopoleirb.ui.IUserInterface;

public class AuctionPolicy {

	public void startNewAuction(PropertySquare square, GameModel context,
			IUserInterface ui, Player auctionLauncher, Bank auctionLauncherBank) {

		if (square == null
				|| square.isType(SquareType.PROPERTY_SQUARE) == false
				|| context == null || ui == null || auctionLauncherBank == null) {
			return;
		}

		int currentPrice = square.getPrice();
		ui.displayMessage("==> Start new auction at " + currentPrice
				+ " for : " + square.getName());

		Player bestOfferer = null;
		while (true) {
			for (Player player : context.getPlayers()) {
				// 0. Check if the current player is the seller (or the auction
				// launcher). If it is, he can't play.
				if (player == auctionLauncher) {
					continue;
				}
				// 1. At the end of a turn, if no other offer was made, the
				// auction is won by the best offerer
				if (bestOfferer != null && player == bestOfferer) {
					finishAuction(ui, (PropertySquare) square,
							auctionLauncherBank, bestOfferer, currentPrice);
					return;
				}
				// 2. Check if the player had enough money to participate at
				// the auction
				if (currentPrice > player.getBank().getBalance()) {
					continue;
				}
				int answer = ui.askUserForInt(player.getDisplayedForm()
						+ " ? Your new price ?");
				if (answer == -1) {
					continue;
				}
				// 3. Check if the player had enough money to offer the
				// price
				if (answer > player.getBank().getBalance()) {
					ui.displayMessage("You haven't enought money !");
					continue;
				}
				if (answer > currentPrice) {
					currentPrice = answer;
					bestOfferer = player;
				} else {
					ui.displayMessage("You must offer an higher price !");
					continue;
				}
			}
			// If nobody can (or want) buy the field, the auction finished
			if (bestOfferer == null) {
				return;
			}
		}
	}

	private void finishAuction(IUserInterface ui, PropertySquare prop,
			Bank auctionLauncherBank, Player bestOfferer, int offer) {
		// 1. Buy the property and operate the fund transfer
		ui.displayMessage(bestOfferer.getDisplayedForm()
				+ " has won the auction of " + prop.getName() + " !");
		bestOfferer.getBank().sendMoney(auctionLauncherBank, offer);
		prop.setOwner(bestOfferer);
	}
}