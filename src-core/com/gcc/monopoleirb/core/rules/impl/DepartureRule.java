package com.gcc.monopoleirb.core.rules.impl;

import java.util.EnumSet;
import java.util.logging.Level;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.domain.DicePair;
import com.gcc.monopoleirb.core.domain.PlayBoolean;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.log.MonopoleirbLogger;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.SquareType;
import com.gcc.monopoleirb.ui.IUserInterface;

public class DepartureRule implements IRule {

	@Override
	public EnumSet<SquareType> getConcernedSquareTypes() {
		return EnumSet.of(SquareType.ANY_SQUARE);
	}

	@Override
	public void applyRule(ISquare square, Player player, GameModel context,
			IUserInterface ui, DicePair dices, PlayBoolean canStillPlay) {
		// If the player is on the departure square or if he crossed the
		// departure square for the first time
		if (player.canMove()
				&& player.getCurrentPosition() <= player.getPrevPosition()) {
			player.nextRound();
			context.getMainBank().sendMoney(player.getBank(),
					Constants.NEW_ROUND_GAIN);
			MonopoleirbLogger.getLogger().log(
					Level.INFO,
					"New turn for " + player.getDisplayedForm()
							+ " / Board rounds : " + player.getBoardRounds()
							+ " / Current position : "
							+ player.getCurrentPosition());
		}
	}
}
