package com.gcc.monopoleirb.core.rules.impl;

import java.util.EnumSet;
import java.util.Stack;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.domain.DicePair;
import com.gcc.monopoleirb.core.domain.PlayBoolean;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.JailSquare;
import com.gcc.monopoleirb.core.squares.SquareType;
import com.gcc.monopoleirb.core.squares.policies.JailPolicy;
import com.gcc.monopoleirb.ui.IUserInterface;

public class DiceDoubleRule implements IRule {

	@Override
	public EnumSet<SquareType> getConcernedSquareTypes() {
		return EnumSet.of(SquareType.ANY_SQUARE);
	}

	@Override
	public void applyRule(ISquare square, Player player, GameModel context,
			IUserInterface ui, DicePair dices, PlayBoolean canStillPlay) {

		// If the player had made 3 doubles, he goes to jail
		if (!heHadMadeTooManyDoubles()) {
			return;
		}

		// Search a jail square
		JailSquare jail = null;
		for (ISquare sq : context.getSquares()) {
			if (sq.isType(SquareType.JAIL_SQUARE)) {
				jail = (JailSquare) sq;
				break;
			}
		}
		if (jail == null) {
			return;
		}

		// Go in jail
		ui.displayMessage("The player " + player.getName() + " has made "
				+ Constants.DOUBLES_TO_GO_IN_JAIL + " doubles : He goes in jail !");
		new JailPolicy().goInJail(ui, jail, player, dices);
		canStillPlay.setValue(false);
	}

	private boolean heHadMadeTooManyDoubles() {
		Stack<DicePair> pairs = DicePair.getHistory();
		if (pairs.size() < Constants.DOUBLES_TO_GO_IN_JAIL) {
			return false;
		}
		int doubles = 0;
		for (int i = pairs.size() - 1; i >= 0; i--) {
			DicePair pair = pairs.get(i);
			if (pair.isDouble()) {
				doubles++;
			} else {
				break;
			}
		}
		if (doubles == Constants.DOUBLES_TO_GO_IN_JAIL) {
			return true;
		}
		return false;
	}
}
