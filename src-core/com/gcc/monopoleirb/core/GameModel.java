package com.gcc.monopoleirb.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.gcc.monopoleirb.core.bank.Bank;
import com.gcc.monopoleirb.core.cards.CardsBundle;
import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.RulesBundle;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.SquareFamily;

/**
 * The game model
 * 
 * @author Elian ORIOU
 * 
 */

public class GameModel {

	private final List<Player> players;
	private final LinkedList<ISquare> squares;
	private final Map<Integer, SquareFamily> families;
	private final Bank mainBank;
	private final Bank centralPot;
	private final RulesBundle rulesBundle;
	private final CardsBundle cardsBundle;

	public GameModel() {

		players = new ArrayList<Player>();
		squares = new LinkedList<ISquare>();
		families = new HashMap<Integer, SquareFamily>();
		mainBank = new Bank("Game", Constants.INITIAL_BANK_AMOUNT);
		centralPot = new Bank("Pot");

		rulesBundle = new RulesBundle();
		cardsBundle = new CardsBundle();
	}

	public List<Player> getPlayers() {
		return players;
	}

	public LinkedList<ISquare> getSquares() {
		return squares;
	}

	public Map<Integer, SquareFamily> getSquareFamilies() {
		return families;
	}

	public Bank getMainBank() {
		return mainBank;
	}

	public Bank getCentralPot() {
		return centralPot;
	}

	public RulesBundle getRulesBundle() {
		return rulesBundle;
	}

	public CardsBundle getCardsBundle() {
		return cardsBundle;
	}
}