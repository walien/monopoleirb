package com.gcc.monopoleirb.core.rules.impl;

import java.util.EnumSet;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.cards.CardsBundle;
import com.gcc.monopoleirb.core.cards.IGameCard;
import com.gcc.monopoleirb.core.domain.DicePair;
import com.gcc.monopoleirb.core.domain.PlayBoolean;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.SquareType;
import com.gcc.monopoleirb.ui.IUserInterface;

public class CommunityChestSquareRule implements IRule {

	@Override
	public EnumSet<SquareType> getConcernedSquareTypes() {
		return EnumSet.of(SquareType.COMMUNITY_CHEST);
	}

	@Override
	public void applyRule(ISquare square, Player player, GameModel context,
			IUserInterface ui, DicePair dices, PlayBoolean canStillPlay) {
		IGameCard card = context.getCardsBundle().nextCard(
				CardsBundle.COMMUNITY_CARD);
		if (card == null) {
			return;
		}
		ui.displayMessage("COMMUNITY CARD : " + card.getTitle() + " ==> "
				+ card.getRuleText());
		card.applyCardRule(context, player, ui);
	}
}
