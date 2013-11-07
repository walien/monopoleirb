package com.gcc.monopoleirb.core.squares;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.gcc.monopoleirb.core.domain.Player;

public class JailSquare extends Square {

	private Map<Player, Integer> playersInJail;
	private String displayName;
	private boolean simpleVisit;

	public JailSquare(String name, boolean simpleVisit) {
		playersInJail = new HashMap<Player, Integer>();
		this.displayName = name;
		this.simpleVisit = simpleVisit;
	}

	@Override
	public String getName() {
		return displayName;
	}

	@Override
	public EnumSet<SquareType> getTypes() {
		return EnumSet.of(SquareType.ANY_SQUARE, SquareType.JAIL_SQUARE);
	}

	public boolean isSimpleVisit() {
		return simpleVisit;
	}

	public void goToJail(Player player) {
		playersInJail.put(player, 1);
	}

	public boolean isInJail(Player player) {
		return playersInJail.containsKey(player);
	}

	public void newTurnInJail(Player player) {
		int oldTurnsNumber = playersInJail.get(player);
		playersInJail.put(player, ++oldTurnsNumber);
	}

	public int getJailTurnsNumber(Player player) {
		return playersInJail.get(player);
	}

	public void getOutFromJail(Player player) {
		playersInJail.remove(player);
	}

	@Override
	public String toString() {
		return "JailSquare [displayName=" + displayName + ", playersInJail="
				+ playersInJail + ", simpleVisit=" + simpleVisit + "]";
	}

}
