package com.gcc.monopoleirb.core.rules;

import java.util.ArrayList;
import java.util.List;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.cards.CardsBundle;
import com.gcc.monopoleirb.core.cards.IGameCard;
import com.gcc.monopoleirb.core.cards.chance.GetOutFromJailChanceCard;
import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.squares.Field;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.PropertySquare;
import com.gcc.monopoleirb.core.squares.SquareFamily;
import com.gcc.monopoleirb.core.squares.SquareType;

public class RuleTools {

	public static List<ISquare> getSquaresInFamily(GameModel context,
			Player player, SquareFamily f) {
		List<ISquare> familySquares = new ArrayList<ISquare>();
		for (ISquare square : player.getOwnedSquare()) {
			if (square.isType(SquareType.PROPERTY_SQUARE) == false) {
				continue;
			}
			PropertySquare prop = (PropertySquare) square;
			if (prop.getFamily() != f) {
				continue;
			}
			familySquares.add(square);
		}
		return familySquares;
	}

	public static int numberOfPropertiesInFamily(GameModel context,
			Player player, SquareFamily family) {
		return getSquaresInFamily(context, player, family).size();
	}

	public static boolean checkIfHasAllProperties(GameModel context,
			Player player, SquareFamily family) {
		List<ISquare> squares = getSquaresInFamily(context, player, family);
		for (ISquare square : squares) {
			PropertySquare f = (PropertySquare) square;
			if (f.hasBeenMortgaged()) {
				return false;
			}
		}
		return squares.size() == family.getSquareNumber();
	}

	public static List<ISquare> minimumBuiltFields(GameModel context,
			Player player, SquareFamily family) {
		List<ISquare> squares = new ArrayList<ISquare>();
		int minHouses = Constants.MAX_BUILDINGS_PER_FIELD;
		// 1. Determines the minimum number
		for (ISquare square : player.getOwnedSquare()) {
			if (square.isType(SquareType.FIELD_SQUARE) == false) {
				continue;
			}
			Field f = (Field) square;
			if (f.getFamily() != family) {
				continue;
			}
			if (f.getBuildPolicy().getHouseNumber() < minHouses) {
				minHouses = f.getBuildPolicy().getHouseNumber();
			}
		}
		for (ISquare square : player.getOwnedSquare()) {
			if (square.isType(SquareType.FIELD_SQUARE) == false) {
				continue;
			}
			Field f = (Field) square;
			if (f.getFamily() != family
					|| f.getBuildPolicy().getHouseNumber() != minHouses) {
				continue;
			}
			squares.add(f);
		}
		return squares;
	}

	public static List<ISquare> getMortgageableProperties(GameModel context,
			Player p) {
		List<ISquare> squares = new ArrayList<ISquare>();
		for (ISquare sq : p.getOwnedSquare()) {
			if (sq.isType(SquareType.PROPERTY_SQUARE) == false) {
				continue;
			}
			if (((PropertySquare) sq).hasBeenMortgaged() == false) {
				squares.add(sq);
			}
		}
		return squares;
	}

	public static double getMorgageablePropertiesAmount(GameModel context,
			Player player) {
		List<ISquare> mortgage = getMortgageableProperties(context, player);
		if (mortgage.size() == 0) {
			return 0;
		}
		double sum = -1;
		for (ISquare square : mortgage) {
			PropertySquare prop = (PropertySquare) square;
			sum += prop.MORGAGING_VALUE;
		}
		return sum;
	}

	public static IGameCard hadGetOutFromJailChanceCard(Player p) {
		for (IGameCard card : p.getCardsBundle().getCards(
				CardsBundle.CHANCE_CARD)) {
			if (card instanceof GetOutFromJailChanceCard) {
				return card;
			}
		}
		return null;
	}
}
