package com.gcc.monopoleirb.core.rules.impl;

import java.util.EnumSet;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.DicePair;
import com.gcc.monopoleirb.core.domain.PlayBoolean;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.SquareType;
import com.gcc.monopoleirb.ui.IUserInterface;

public class FreeParkSquareRule implements IRule {

	@Override
	public EnumSet<SquareType> getConcernedSquareTypes() {
		return EnumSet.of(SquareType.FREE_PARK_SQUARE);
	}

	@Override
	public void applyRule(ISquare square, Player player, GameModel context,
			IUserInterface ui, DicePair dices, PlayBoolean canStillPlay) {
		double centralPotAmount = context.getCentralPot().getBalance();
		ui.displayMessage(player.getDisplayedForm() + " won the central pot ! ("
				+ centralPotAmount);
		context.getCentralPot().sendMoney(player.getBank(),
				(int) centralPotAmount);
	}
}
