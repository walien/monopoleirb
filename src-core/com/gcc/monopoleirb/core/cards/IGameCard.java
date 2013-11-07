package com.gcc.monopoleirb.core.cards;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.ui.IUserInterface;

public interface IGameCard {

	String getTitle();

	String getRuleText();

	void applyCardRule(GameModel context, Player p, IUserInterface ui);
}
