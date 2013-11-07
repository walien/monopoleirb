package com.gcc.monopoleirb.core;

import java.util.List;

import com.gcc.monopoleirb.core.domain.DicePair;
import com.gcc.monopoleirb.core.domain.PlayBoolean;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.ui.IUserInterface;

/**
 * The game controller
 * 
 * @author Elian ORIOU
 * 
 */

public class GameController {

	// In the controller : The model and the view (Components of the MVC
	// pattern)
	private GameModel context;
	private IUserInterface ui;

	public GameController(GameModel context, IUserInterface ui) {
		this.context = context;
		this.ui = ui;
		this.ui.refreshUI(context);
	}

	public void execNewTurn() {
		if (context == null) {
			return;
		}
		for (Player p : context.getPlayers()) {
			DicePair dices;
			do {
				dices = DicePair.generateDicePair();
				execTurnForPlayer(dices, p);
			} while (p.canMove() && dices.isDouble());
		}
	}

	private void execTurnForPlayer(DicePair dices, Player player) {
		// 1. Check if the player can move (if he's not in jail for instance)
		if (player.canMove()) {
			// 2. Compute new position
			int newPosition = player.getCurrentPosition() + dices.sum();
			// 3. Refresh player position
			newPosition = newPosition % context.getSquares().size();
			player.setPosition(newPosition);
		}

		// 4. The new current square
		ISquare currentSquare = context.getSquares().get(
				player.getCurrentPosition());

		// 5. Display player state
		ui.displayMessage(" --> New turn for : " + player.getDisplayedForm()
				+ " : " + dices + " ==> " + currentSquare.getName());

		// 6. Apply rules (it depend on the square type)
		applyRules(player, currentSquare, dices);

		// 7. Display player state (2nd time)
		ui.displayMessage(player.getName() + "'s turn : "
				+ player.getBoardRounds() + " [" + player.getCurrentPosition()
				+ "]");

		// 8. Refresh UI
		ui.refreshUI(context);
	}

	private void applyRules(Player player, ISquare square, DicePair dices) {
		// Get all rules concerned by the current square
		List<IRule> concernedRules = context.getRulesBundle()
				.getRulesBySquareType(square.getTypes());

		// Apply these rules
		PlayBoolean canStillPlay = new PlayBoolean(true);
		for (IRule rule : concernedRules) {
			rule.applyRule(square, player, context, ui, dices, canStillPlay);
			if (canStillPlay.getValue() == false) {
				return;
			}
		}
	}
}
