package com.gcc.monopoleirb.core.xml;

import java.util.List;
import java.util.Map;

import com.gcc.monopoleirb.core.cards.IGameCard;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.SquareFamily;

public interface Parser {

	/**
	 * 
	 * @param path
	 */

	void loadConfigurationFile(String path);

	/**
	 * 
	 * @return
	 */

	boolean isValid();

	/**
	 * 
	 * @return
	 */

	List<Player> loadPlayers();

	/**
	 * 
	 * @return
	 */

	Map<Integer, SquareFamily> loadSquareFamilies();

	/**
	 * 
	 * @return
	 */

	List<ISquare> loadSquares();

	/**
	 * 
	 * @return
	 */

	List<IRule> loadRules();

	/**
	 * 
	 * @return
	 */

	List<IGameCard> loadChanceCards();

	/**
	 * 
	 * @return
	 */

	List<IGameCard> loadCommunityChestCards();
}
