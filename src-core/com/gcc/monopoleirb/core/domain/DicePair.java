package com.gcc.monopoleirb.core.domain;

import java.util.Random;
import java.util.Stack;

public class DicePair {

	private static final int MAX_VALUE = 6;
	private static final Random _RANDOM = new Random();
	private int dice1, dice2;
	private static final Stack<DicePair> _HISTORY = new Stack<DicePair>();

	private DicePair(int dice1, int dice2) {
		this.dice1 = dice1;
		this.dice2 = dice2;
	}

	public static DicePair generateDicePair() {
		DicePair pair = new DicePair(_RANDOM.nextInt(MAX_VALUE) + 1,
				_RANDOM.nextInt(MAX_VALUE) + 1);
		_HISTORY.push(pair);
		return pair;
	}

	public static Stack<DicePair> getHistory() {
		return _HISTORY;
	}

	public int getDice1() {
		return dice1;
	}

	public int getDice2() {
		return dice2;
	}

	public boolean isDouble() {
		return dice1 == dice2;
	}

	public int sum() {
		return dice1 + dice2;
	}

	@Override
	public String toString() {
		return "[" + dice1 + ", " + dice2 + "]";
	}
}