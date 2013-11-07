package com.gcc.monopoleirb.core.rules.impl;

import java.util.EnumSet;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.DicePair;
import com.gcc.monopoleirb.core.domain.PlayBoolean;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.JailSquare;
import com.gcc.monopoleirb.core.squares.SquareType;
import com.gcc.monopoleirb.core.squares.policies.JailPolicy;
import com.gcc.monopoleirb.ui.IUserInterface;

public class GoingInJailRule implements IRule {

	@Override
	public EnumSet<SquareType> getConcernedSquareTypes() {
		return EnumSet.of(SquareType.JAIL_SQUARE);
	}

	@Override
	public void applyRule(ISquare square, Player player, GameModel context,
			IUserInterface ui, DicePair dices, PlayBoolean canStillPlay) {

		JailSquare jail = (JailSquare) square;
		if (jail.isSimpleVisit()) {
			ui.displayMessage(player.getDisplayedForm()
					+ " visit the premises of the prison and laught !");
			return;
		}

		boolean isInJail = new JailPolicy().goInJail(ui, jail, player, dices);
		canStillPlay.setValue(!isInJail);
	}
}
