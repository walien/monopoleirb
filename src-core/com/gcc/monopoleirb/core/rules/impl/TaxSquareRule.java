package com.gcc.monopoleirb.core.rules.impl;

import java.util.EnumSet;
import java.util.List;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.DicePair;
import com.gcc.monopoleirb.core.domain.PlayBoolean;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.rules.RuleTools;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.SquareType;
import com.gcc.monopoleirb.core.squares.TaxSquare;
import com.gcc.monopoleirb.core.squares.policies.EndGamePolicy;
import com.gcc.monopoleirb.core.squares.policies.MortgagePolicy;
import com.gcc.monopoleirb.core.squares.policies.SellPolicy;
import com.gcc.monopoleirb.ui.IUserInterface;

public class TaxSquareRule implements IRule {

	@Override
	public EnumSet<SquareType> getConcernedSquareTypes() {
		return EnumSet.of(SquareType.TAX_SQUARE);
	}

	@Override
	public void applyRule(ISquare square, Player player, GameModel context,
			IUserInterface ui, DicePair dices, PlayBoolean canStillPlay) {

		TaxSquare tax = (TaxSquare) square;

		int taxAmount = tax.getTaxAmount();
		ui.displayMessage("You have to pay a tax costing : " + taxAmount);
		// 1. The player can pay the tax
		if (taxAmount <= player.getBank().getBalance()) {
			player.getBank().sendMoney(context.getMainBank(), taxAmount);
			return;
		}
		// 2. The player cannot pay the tax : he have to choose between mortgage
		// || to sell buildings || to sell properties to the bank

		// 2.1. If the player hasn't enough money and properties to mortgage or
		// to sell : he has lost
		List<ISquare> props = player.getOwnedSquare();
		if (props.size() == 0
				|| RuleTools.getMorgageablePropertiesAmount(context, player) == 0) {
			new EndGamePolicy().hasLost(context, ui, player, taxAmount);
			return;
		}

		// 2.2 Make a choice
		while (true) {
			ui.displayMessage(player.getName() + " [balance : "
					+ player.getBank().getBalance() + "]");
			switch (ui.askUserForList("Would you : ", new String[] {
					"Mortgage properties ?", "Sell properties?",
					"Sell buildings ?", "Give uuuuup !" })) {
			case 0:
				new MortgagePolicy().launchMortgage(context, ui, player,
						taxAmount);
				break;
			case 1:
				new SellPolicy().sellPropertiesByAuction(context, ui, player);
				break;
			case 2:
				new SellPolicy().sellSelectedBuildings(context, ui, player);
				break;
			case 3:
				new EndGamePolicy().giveUp(context, ui, player);
				return;
			}
			// Pay the tax
			if (taxAmount <= player.getBank().getBalance()) {
				ui.displayMessage(player.getDisplayedForm()
						+ " has paid the tax (" + taxAmount + ") !");
				player.getBank().sendMoney(context.getMainBank(), taxAmount);
				break;
			}
		}
	}
}
