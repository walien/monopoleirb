package com.gcc.monopoleirb.core;

import com.gcc.monopoleirb.ui.IUserInterface;

public class GameBoard {

	private static GameModel _MODEL;
	private static IUserInterface _UI;
	private static GameController _CONTROLLER;

	public GameBoard(final IUserInterface ui) {
		_UI = ui;
		_MODEL = new GameModel();
		_CONTROLLER = new GameController(_MODEL, _UI);
	}

	public static GameModel getGameModel() {
		return _MODEL;
	}

	public static IUserInterface getUserInterface() {
		return _UI;
	}

	public static GameController getGameController() {
		return _CONTROLLER;
	}
}
