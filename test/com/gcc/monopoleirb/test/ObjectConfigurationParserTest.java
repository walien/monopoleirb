package com.gcc.monopoleirb.test;

import com.gcc.monopoleirb.core.CoreInitializer;
import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.xml.parsers.JAXBConfigurationParser;

public class ObjectConfigurationParserTest {

	public static void main(String[] args) {

		// Init the gameboard
		GameModel model = new GameModel();

		// Init the game engine
		CoreInitializer.init();

		// Load configuration
		JAXBConfigurationParser parser = new JAXBConfigurationParser(model);
		parser.loadConfigurationFile("monopoleirb_conf.xml");

		// Load data
		parser.loadSquareFamilies();
		parser.loadPlayers();
		parser.loadRules();
		parser.loadSquares();
		parser.loadChanceCards();
		parser.loadCommunityChestCards();
	}
}
