package com.gcc.monopoleirb.core.squares.policies;

import java.util.Iterator;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.ui.IUserInterface;

public class EndGamePolicy {

	private Iterator<Player> it;

	public void hasLost(GameModel context, IUserInterface ui, Player player,
			int dept) {
		if (player.getOwnedSquare().size() == 0) {
			ui.displayMessage("The player " + player.getDisplayedForm()
					+ " has lost ! Bad luck !");
			removePlayer(context, player);
		} else {
			// TODO
		}
	}

	public void giveUp(GameModel context, IUserInterface ui, Player player) {
		ui.displayMessage("The player " + player.getDisplayedForm()
				+ " has gave up !");
		removePlayer(context, player);
	}

	private void removePlayer(final GameModel context, Player player) {
		// The player has lost
		it = new Iterator<Player>() {

			private int i = -1;

			@Override
			public boolean hasNext() {
				return i < context.getPlayers().size() - 1;
			}

			@Override
			public Player next() {
				return context.getPlayers().get(++i);
			}

			@Override
			public void remove() {
				context.getPlayers().remove(i--);
			}

		};
		for (; it.hasNext();) {
			if (it.next() == player) {
				it.remove();
				return;
			}
		}
	}
}
