package com.gcc.monopoleirb.test;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.xml.parsers.DOMConfigurationParser;

public class ConfigurationParserTest {

	private static final String _CONF_FILE = "monopoleirb_conf.xml";

	public static void main(String[] args) {

		GameModel context = new GameModel();
		DOMConfigurationParser parser = new DOMConfigurationParser(context);
		parser.loadConfigurationFile(_CONF_FILE);

		System.out.println("==== isValid() => " + parser.isValid());

		context.getPlayers().addAll(parser.loadPlayers());
		context.getSquareFamilies().putAll(parser.loadSquareFamilies());
		context.getSquares().addAll(parser.loadSquares());

		System.out.println(context.getPlayers());
		System.out.println(context.getSquareFamilies());
		System.out.println(context.getSquares());

		System.out.println(context.getSquares().size());
	}
}