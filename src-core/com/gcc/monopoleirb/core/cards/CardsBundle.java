package com.gcc.monopoleirb.core.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsBundle {

	private List<IGameCard> chanceCards;
	private List<IGameCard> communityCards;
	private int chanceCursor;
	private int communityCursor;

	public static final int CHANCE_CARD = 11;
	public static final int COMMUNITY_CARD = 12;

	public CardsBundle() {
		this.chanceCards = new ArrayList<IGameCard>();
		this.communityCards = new ArrayList<IGameCard>();
		this.chanceCursor = 0;
		this.communityCursor = 0;
	}

	public List<IGameCard> getCards(int cardsType) {
		if (cardsType == CHANCE_CARD) {
			return chanceCards;
		}
		if (cardsType == COMMUNITY_CARD) {
			return communityCards;
		}
		return null;
	}

	private int nextCursor(int cardsType) {
		if (cardsType == CHANCE_CARD) {
			if (chanceCursor >= chanceCards.size() - 1) {
				chanceCursor = 0;
			}
			return chanceCursor++;
		}
		if (cardsType == COMMUNITY_CARD) {
			if (communityCursor >= communityCards.size() - 1) {
				communityCursor = 0;
			}
			return communityCursor++;
		}
		return -1;
	}

	public IGameCard nextCard(int cardsType) {
		List<IGameCard> cards = getCards(cardsType);
		if (cards == null || cards.size() == 0) {
			return null;
		}
		return cards.get(nextCursor(cardsType));
	}

	public void addCard(IGameCard card, int cardsType) {
		List<IGameCard> cards = getCards(cardsType);
		if (cards == null) {
			return;
		}
		cards.add(card);
	}

	public void addAllCards(int cardsType, List<IGameCard> newCards) {
		List<IGameCard> cards = getCards(cardsType);
		if (cards == null) {
			return;
		}
		cards.addAll(newCards);
	}

	public void removeCard(IGameCard card, int cardsType) {
		List<IGameCard> cards = getCards(cardsType);
		if (cards == null) {
			return;
		}
		// FIXME bizarre behavior ?
		cards.remove(card);
	}

	public void replaceCard(IGameCard card, int cardsType) {
		List<IGameCard> cards = getCards(cardsType);
		if (cards == null) {
			return;
		}
		cards.add(card);
	}

	public void shuffleCards() {
		Collections.shuffle(chanceCards);
		Collections.shuffle(communityCards);
	}

	@Override
	public String toString() {
		return "CardsBundle [chanceCards=" + chanceCards + ", communityCards="
				+ communityCards + "]";
	}
}