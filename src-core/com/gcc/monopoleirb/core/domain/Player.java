package com.gcc.monopoleirb.core.domain;

import java.util.ArrayList;
import java.util.List;

import com.gcc.monopoleirb.core.bank.Bank;
import com.gcc.monopoleirb.core.cards.CardsBundle;
import com.gcc.monopoleirb.core.squares.ISquare;

public class Player {

	private String name;
	private boolean canMove;
	private Bank bank;
	private int prevPosition;
	private int position;
	private int boardRounds;
	private CardsBundle cardsBundle;
	private List<ISquare> ownedSquares;

	public Player(String name, double initialBalance) {
		this.name = name;
		this.canMove = true;
		this.bank = new Bank(name + "'s Bank", initialBalance);
		this.prevPosition = 0;
		this.position = 0;
		this.boardRounds = 1;
		this.cardsBundle = new CardsBundle();
		this.ownedSquares = new ArrayList<ISquare>();
	}

	public Player(String name) {
		this(name, Constants.INITIAL_PLAYER_AMOUNT);
	}

	public String getName() {
		return name;
	}

	public boolean canMove() {
		return canMove;
	}

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}

	public Bank getBank() {
		return bank;
	}

	public int getPrevPosition() {
		return prevPosition;
	}

	public int getCurrentPosition() {
		return position;
	}

	public void setPosition(int newPosition) {
		this.prevPosition = this.position;
		this.position = newPosition;
	}

	public int getBoardRounds() {
		return boardRounds;
	}

	public void nextRound() {
		this.boardRounds++;
	}

	public CardsBundle getCardsBundle() {
		return this.cardsBundle;
	}

	public List<ISquare> getOwnedSquare() {
		return ownedSquares;
	}

	public String getDisplayedForm() {
		return getName() + " [balance = " + bank.getBalance() + "]";
	}

	@Override
	public String toString() {
		return "Player [bank=" + bank + ", boardRounds=" + boardRounds
				+ ", canMove=" + canMove + ", cardsBundle=" + cardsBundle
				+ ", name=" + name + ", position=" + position
				+ ", prevPosition=" + prevPosition + "]";
	}
}