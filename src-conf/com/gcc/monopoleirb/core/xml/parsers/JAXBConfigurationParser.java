package com.gcc.monopoleirb.core.xml.parsers;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.cards.CardsBundle;
import com.gcc.monopoleirb.core.cards.IGameCard;
import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.domain.conf.Configuration;
import com.gcc.monopoleirb.core.domain.conf.Configuration.ChanceCards;
import com.gcc.monopoleirb.core.domain.conf.Configuration.CommunityChestCards;
import com.gcc.monopoleirb.core.domain.conf.Configuration.Families;
import com.gcc.monopoleirb.core.domain.conf.Configuration.Players;
import com.gcc.monopoleirb.core.domain.conf.Configuration.Rules;
import com.gcc.monopoleirb.core.domain.conf.Configuration.Squares;
import com.gcc.monopoleirb.core.domain.conf.TypeCard;
import com.gcc.monopoleirb.core.domain.conf.TypeFamily;
import com.gcc.monopoleirb.core.domain.conf.TypePlayer;
import com.gcc.monopoleirb.core.domain.conf.TypeRule;
import com.gcc.monopoleirb.core.log.MonopoleirbLogger;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.SquareFamily;
import com.gcc.monopoleirb.core.xml.ObjectConverter;
import com.gcc.monopoleirb.core.xml.Parser;

public class JAXBConfigurationParser implements Parser {

	private Configuration configuration;
	private GameModel model;

	public JAXBConfigurationParser(GameModel model) {
		this.model = model;
	}

	@Override
	public void loadConfigurationFile(String path) {
		try {

			// 1. Creates the JAXB context
			JAXBContext context = JAXBContext
					.newInstance(Constants.JAXB_CONTEXT_PACKAGE);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			// 2. Set the configuration schema for validation
			SchemaFactory factory = SchemaFactory
					.newInstance("http://www.w3.org/2001/XMLSchema");
			Schema schema = factory
					.newSchema(new File(Constants.CONF_XSD_PATH));
			unmarshaller.setSchema(schema);

			// 3. Unmarshall configuration objects
			configuration = (Configuration) unmarshaller.unmarshal(new File(
					path));

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public List<Player> loadPlayers() {

		if (configuration == null) {
			return Collections.emptyList();
		}

		// Conf players and engine players
		List<Player> players = new ArrayList<Player>();
		Players p = configuration.getPlayers();
		if (p == null) {
			return Collections.emptyList();
		}
		List<TypePlayer> confPlayers = p.getPlayer();

		// Convert conf players to engine players
		for (TypePlayer confPlayer : confPlayers) {

			Player player = ObjectConverter.confPlayerToPlayer(confPlayer);
			players.add(player);

			MonopoleirbLogger.getLogger().info(
					"[PLAYER] " + player.getDisplayedForm()
							+ " added to the game !");
		}

		// Add players to model
		model.getPlayers().addAll(players);

		return players;
	}

	@Override
	public Map<Integer, SquareFamily> loadSquareFamilies() {

		if (configuration == null) {
			return Collections.emptyMap();
		}

		// Conf players and engine players
		Map<Integer, SquareFamily> families = new HashMap<Integer, SquareFamily>();
		Families f = configuration.getFamilies();
		if (f == null) {
			return Collections.emptyMap();
		}
		List<TypeFamily> confFamilies = f.getFamily();

		// Convert conf players to engine players
		for (TypeFamily confFamily : confFamilies) {
			SquareFamily family = ObjectConverter
					.confFamilyToSquareFamily(confFamily);
			families.put(confFamily.getId().intValue(), family);

			MonopoleirbLogger.getLogger().info(
					"[FAMILY] " + family.getDisplayName()
							+ " added to the game !");
		}

		// Add families to model
		model.getSquareFamilies().putAll(families);

		return families;
	}

	@Override
	public List<ISquare> loadSquares() {

		if (configuration == null) {
			return Collections.emptyList();
		}

		// Conf squares and engine squares
		List<ISquare> squares = new ArrayList<ISquare>();
		Squares s = configuration.getSquares();
		if (s == null) {
			return Collections.emptyList();
		}
		List<Object> confSquares = s
				.getDepartureSquareAndFieldAndTrainStation();

		// Convert conf squares to engine squares
		for (Object confSquare : confSquares) {
			ISquare square = ObjectConverter.confSquareToSquare(confSquare,
					model);
			if (square == null) {
				continue;
			}
			squares.add(square);

			MonopoleirbLogger.getLogger().info(
					"[SQUARE] " + square.getName() + " added to the game !");
		}

		MonopoleirbLogger.getLogger().info(
				squares.size() + " squares imported !");

		// Add squares to model
		model.getSquares().addAll(squares);

		return squares;
	}

	@Override
	public List<IRule> loadRules() {

		if (configuration == null) {
			return Collections.emptyList();
		}

		// Conf rules and engine rules
		List<IRule> rules = new ArrayList<IRule>();
		Rules r = configuration.getRules();
		if (r == null) {
			return Collections.emptyList();
		}
		List<TypeRule> confRules = r.getRule();

		// Convert conf rules to engine rules
		for (TypeRule confRule : confRules) {
			IRule rule = ObjectConverter.confRuleToRule(confRule);
			rules.add(rule);

			MonopoleirbLogger.getLogger().info(
					"[RULE] " + confRule.getClazz() + " imported !");
		}
		MonopoleirbLogger.getLogger().info(rules.size() + " rules imported !");

		// Add rules to rules bundle
		model.getRulesBundle().addAllRules(rules);

		return rules;
	}

	@Override
	public List<IGameCard> loadChanceCards() {

		if (configuration == null) {
			return Collections.emptyList();
		}

		// Conf chance cards and engine chance cards
		List<IGameCard> cards = new ArrayList<IGameCard>();
		ChanceCards cc = configuration.getChanceCards();
		if (cc == null) {
			return Collections.emptyList();
		}

		List<TypeCard> confCards = cc.getCard();

		// Convert conf chance cards to engine chance cards
		for (TypeCard confCard : confCards) {
			IGameCard card = ObjectConverter.confGameCardToGameCard(confCard);
			cards.add(card);

			MonopoleirbLogger.getLogger().info(
					"[CARD : CHANCE] " + confCard.getClazz() + " imported !");
		}

		MonopoleirbLogger.getLogger().info(
				cards.size() + " chance cards imported !");

		// Add chance cards to the cards bundle
		model.getCardsBundle().addAllCards(CardsBundle.CHANCE_CARD, cards);

		return cards;
	}

	@Override
	public List<IGameCard> loadCommunityChestCards() {

		if (configuration == null) {
			return Collections.emptyList();
		}

		// Conf community chest cards and engine community chest cards
		List<IGameCard> cards = new ArrayList<IGameCard>();
		CommunityChestCards cc = configuration.getCommunityChestCards();
		if (cc == null) {
			return Collections.emptyList();
		}
		List<TypeCard> confCards = cc.getCard();

		// Convert conf community chest cards to engine community chest cards
		for (TypeCard confCard : confCards) {
			IGameCard card = ObjectConverter.confGameCardToGameCard(confCard);
			cards.add(card);

			MonopoleirbLogger.getLogger().info(
					"[CARD : COMMUNITY CHEST] " + confCard.getClazz()
							+ " imported !");
		}

		MonopoleirbLogger.getLogger().info(
				cards.size() + " community chest cards imported !");

		// Add community chest cards to the cards bundle
		model.getCardsBundle().addAllCards(CardsBundle.COMMUNITY_CARD, cards);

		return cards;
	}

}
