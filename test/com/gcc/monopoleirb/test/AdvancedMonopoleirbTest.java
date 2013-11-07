package com.gcc.monopoleirb.test;

import com.gcc.monopoleirb.core.CoreInitializer;
import com.gcc.monopoleirb.core.GameBoard;
import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.squares.Field;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.xml.Parser;
import com.gcc.monopoleirb.core.xml.parsers.JAXBConfigurationParser;
import com.gcc.monopoleirb.ui.impl.SwingUI;

public class AdvancedMonopoleirbTest {

	private static final int _BOARD_TURNS = 100;
	// private static final boolean _DEMO_MODE = true;
	private static final String _CONF_FILE_PATH = "monopoleirb_conf.xml";

	public static void main(String[] args) {
		// 0. Initialize the system
		CoreInitializer.init();

		// 1. The Game Board (which init all MVC components)
		new GameBoard(new SwingUI());

		// 2. The Game Model
		GameModel model = GameBoard.getGameModel();

		// 3. Import players, square families, squares, rules and cards from
		// the configuration file
		Parser parser = new JAXBConfigurationParser(model);
		parser.loadConfigurationFile(_CONF_FILE_PATH);
		parser.loadPlayers();
		parser.loadSquareFamilies();
		parser.loadSquares();
		parser.loadRules();
		parser.loadChanceCards();
		parser.loadCommunityChestCards();

		// 4. Shuffle cards
		model.getCardsBundle().shuffleCards();

		// 5. Launch game
		for (int i = 0; i < _BOARD_TURNS; i++) {
			GameBoard.getGameController().execNewTurn();
		}

		// 6. Print Final states
		System.out.println("\n-----------------\n");
		for (Player p : model.getPlayers()) {
			System.out.println(p);
		}
		System.out.println("\n-----------------\n");
		for (ISquare s : model.getSquares()) {
			System.out.print(s);
			if (s instanceof Field == false) {
				continue;
			}
			Field f = (Field) s;
			System.out.println(" :::: " + f.getBuildPolicy());
		}
	}
}