package com.gcc.monopoleirb.ui;

import java.util.List;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.PropertySquare;

public interface IUserInterface {

	String askUserForString(String message);

	boolean askUserForBoolean(String message);

	int askUserForInt(String message);

	double askUserForDouble(String message);

	int askUserForList(String message, String[] elements);

	List<PropertySquare> askUserForProperties(GameModel c, Player p,
			List<ISquare> props, int maxSelection, String message);

	void displayMessage(String message);

	boolean refreshUI(GameModel context);

}
