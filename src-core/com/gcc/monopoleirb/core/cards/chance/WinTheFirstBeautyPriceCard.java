package com.gcc.monopoleirb.core.cards.chance;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.cards.CardMessages;
import com.gcc.monopoleirb.core.cards.IGameCard;
import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.ui.IUserInterface;

public class WinTheFirstBeautyPriceCard implements IGameCard {

	@Override
	public String getTitle() {
		return CardMessages.WIN_FIRST_BEAUTY_PRICE_TITLE;
	}

	@Override
	public String getRuleText() {
		return CardMessages.WIN_FIRST_BEAUTY_PRICE;
	}

	@Override
	public void applyCardRule(GameModel context, Player p, IUserInterface ui) {
		p.getBank().sendMoney(context.getMainBank(),
				Constants.BEAUTY_FIRST_PRICE_AMOUNT);
	}

	@Override
	public String toString() {
		return "WinTheFirstBeautyPriceCard [getTitle()=" + getTitle() + "]";
	}
}
