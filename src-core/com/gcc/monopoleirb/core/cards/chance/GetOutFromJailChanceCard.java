package com.gcc.monopoleirb.core.cards.chance;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.cards.CardMessages;
import com.gcc.monopoleirb.core.cards.CardsBundle;
import com.gcc.monopoleirb.core.cards.IGameCard;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.ui.IUserInterface;

public class GetOutFromJailChanceCard implements IGameCard {

	@Override
	public String getTitle() {
		return CardMessages.GET_OUT_FROM_JAIL_TITLE;
	}

	@Override
	public String getRuleText() {
		return CardMessages.GET_OUT_FROM_JAIL;
	}

	@Override
	public void applyCardRule(GameModel context, Player p, IUserInterface ui) {
		p.getCardsBundle().addCard(this, CardsBundle.CHANCE_CARD);
		context.getCardsBundle().removeCard(this, CardsBundle.CHANCE_CARD);

	}

	@Override
	public String toString() {
		return "GetOutFromJailChanceCard [getTitle()=" + getTitle() + "]";
	}

}
