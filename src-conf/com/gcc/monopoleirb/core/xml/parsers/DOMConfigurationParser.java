package com.gcc.monopoleirb.core.xml.parsers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.cards.IGameCard;
import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.log.MonopoleirbLogger;
import com.gcc.monopoleirb.core.rules.IRule;
import com.gcc.monopoleirb.core.squares.ChanceSquare;
import com.gcc.monopoleirb.core.squares.CommunityChestSquare;
import com.gcc.monopoleirb.core.squares.DepartureSquare;
import com.gcc.monopoleirb.core.squares.Field;
import com.gcc.monopoleirb.core.squares.FreeParkSquare;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.JailSquare;
import com.gcc.monopoleirb.core.squares.PublicService;
import com.gcc.monopoleirb.core.squares.SquareFamily;
import com.gcc.monopoleirb.core.squares.TaxSquare;
import com.gcc.monopoleirb.core.squares.TrainStation;
import com.gcc.monopoleirb.core.xml.Parser;
import com.gcc.monopoleirb.core.xml.XMLToolkit;

public class DOMConfigurationParser implements Parser {

	private String filePath;
	private Document document;
	private GameModel context;

	public DOMConfigurationParser(GameModel context) {
		if (context == null) {
			throw new IllegalArgumentException("Context is null !");
		}
		this.context = context;
	}

	@Override
	public void loadConfigurationFile(String path) {
		filePath = path;
		if (!isValid()) {
			throw new IllegalStateException(
					"The configuration file is invalid under the definition !");
		}
		SAXBuilder builder = new SAXBuilder();
		try {
			document = builder.build(new File(path));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isValid() {
		if (filePath == null) {
			return false;
		}
		return XMLToolkit.isXMLValid(filePath, Constants.CONF_XSD_PATH);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> loadPlayers() {
		List<Player> players = new ArrayList<Player>(0);
		Element playerElement = document.getRootElement().getChild(
				Constants.TAG_PLAYERS);
		if (null == playerElement) {
			return players;
		}
		List<Element> playerElements = playerElement.getChildren();
		for (Element player : playerElements) {
			Player p = new Player(
					player.getAttributeValue(Constants.ATTR_PLAYER_NAME));
			p.getBank().setBalance(
					Double.parseDouble(player
							.getAttributeValue(Constants.ATTR_PLAYER_BANK)));
			players.add(p);
			MonopoleirbLogger.getLogger()
					.info("[PLAYER] " + p.getDisplayedForm()
							+ " added to the game !");
		}
		return players;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<Integer, SquareFamily> loadSquareFamilies() {
		Map<Integer, SquareFamily> families = new HashMap<Integer, SquareFamily>(
				0);
		Element familyElement = document.getRootElement().getChild(
				Constants.TAG_FAMILIES);
		if (null == familyElement) {
			return families;
		}
		List<Element> familyElements = familyElement.getChildren();
		for (Element family : familyElements) {
			int familyID = Integer.parseInt(family
					.getAttributeValue(Constants.ATTR_FAMILY_ID));
			String familyName = family
					.getAttributeValue(Constants.ATTR_FAMILY_NAME);
			int propsNumber = Integer.parseInt(family
					.getAttributeValue(Constants.ATTR_FAMILY_N_OF_PROPS));
			SquareFamily f = new SquareFamily(familyName, propsNumber);
			families.put(familyID, f);
			MonopoleirbLogger.getLogger().info(
					"[FAMILY] " + f.getDisplayName() + " added to the game !");
		}
		return families;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ISquare> loadSquares() {
		if (context.getSquareFamilies().isEmpty()) {
			return null;
		}
		LinkedList<ISquare> squares = new LinkedList<ISquare>();
		Element squareElement = document.getRootElement().getChild(
				Constants.TAG_SQUARES);
		if (null == squareElement) {
			return squares;
		}
		List<Element> squareElements = squareElement.getChildren();
		for (Element square : squareElements) {
			ISquare newSquare = buildSquare(square);
			squares.add(newSquare);
			MonopoleirbLogger.getLogger().info(
					"[SQUARE] " + newSquare.getName() + " added to the game !");
		}
		MonopoleirbLogger.getLogger().info(
				squares.size() + " squares imported !");
		return squares;
	}

	private ISquare buildSquare(Element squareElt) {
		String eltName = squareElt.getName();
		// 0. Departure Square
		if (eltName.equals(Constants.TAG_DEPARTURE_SQUARE)) {
			return new DepartureSquare(
					squareElt.getAttributeValue(Constants.ATTR_DEPARTURE_NAME));
		}
		// 1. Field or train-station or public-service
		if (eltName.equals(Constants.TAG_FIELD)
				|| eltName.equals(Constants.TAG_TRAIN_STATION)
				|| eltName.equals(Constants.TAG_PUBLIC_SERVICE)) {
			String name = squareElt.getAttributeValue(Constants.ATTR_PROP_NAME);
			int price = Integer.parseInt(squareElt
					.getAttributeValue(Constants.ATTR_PROP_BUYING_PRICE));
			SquareFamily family = context.getSquareFamilies().get(
					Integer.parseInt(squareElt
							.getAttributeValue(Constants.ATTR_PROP_FAMILY)));
			if (family == null) {
				throw new IllegalStateException("The family doesn't exists !");
			}
			int mortgageAmount = Integer.parseInt(squareElt.getChild(
					Constants.TAG_PROP_MORTGAGE_POLICY).getAttributeValue(
					Constants.ATTR_PROP_MORTGAGE_POLICY_AMOUNT));
			// Field case
			if (eltName.equals(Constants.TAG_FIELD)) {
				Field f = new Field(name, price, family);
				// Mortgaging
				f.MORGAGING_VALUE = mortgageAmount;
				// Building
				f.getBuildPolicy().HOUSE_PRICE = Integer.parseInt(squareElt
						.getChild(Constants.TAG_FIELD_BUILD_POLICY)
						.getAttributeValue(
								Constants.TAG_FIELD_BUILD_POLICY_HOUSE_PRICE));
				f.getBuildPolicy().HOTEL_PRICE = Integer.parseInt(squareElt
						.getChild(Constants.TAG_FIELD_BUILD_POLICY)
						.getAttributeValue(
								Constants.TAG_FIELD_BUILD_POLICY_HOTEL_PRICE));
				// Renting
				Element rentPolicy = squareElt
						.getChild(Constants.TAG_PROP_RENT_POLICY);
				f.getRentPolicy().RENT_PRICE_1_HOUSE = Integer
						.parseInt(rentPolicy
								.getAttributeValue(Constants.ATTR_FIELD_RENT_POLICY_1));
				f.getRentPolicy().RENT_PRICE_2_HOUSE = Integer
						.parseInt(rentPolicy
								.getAttributeValue(Constants.ATTR_FIELD_RENT_POLICY_2));
				f.getRentPolicy().RENT_PRICE_3_HOUSE = Integer
						.parseInt(rentPolicy
								.getAttributeValue(Constants.ATTR_FIELD_RENT_POLICY_3));
				f.getRentPolicy().RENT_PRICE_4_HOUSE = Integer
						.parseInt(rentPolicy
								.getAttributeValue(Constants.ATTR_FIELD_RENT_POLICY_4));
				f.getRentPolicy().RENT_PRICE_1_HOTEL = Integer
						.parseInt(rentPolicy
								.getAttributeValue(Constants.ATTR_FIELD_RENT_POLICY_5));
				return f;
			}
			// Train station case
			if (eltName.equals(Constants.TAG_TRAIN_STATION)) {
				TrainStation station = new TrainStation(name, price, family);
				station.MORGAGING_VALUE = mortgageAmount;
				station.RENT_PRICE = Integer.parseInt(squareElt.getChild(
						Constants.TAG_PROP_RENT_POLICY).getAttributeValue(
						Constants.ATTR_TRAIN_STATION_RENTING_PRICE));
				return station;
			}
			// Public service case
			if (eltName.equals(Constants.TAG_PUBLIC_SERVICE)) {
				PublicService service = new PublicService(name, price, family);
				service.MORGAGING_VALUE = mortgageAmount;
				return service;
			}
		}
		// 2. Chance square case
		if (squareElt.getName().equals(Constants.TAG_CHANCE_SQUARE)) {
			return new ChanceSquare();
		}
		// 3. Community chest square
		if (squareElt.getName().equals(Constants.TAG_COMMUNITY_CHEST)) {
			return new CommunityChestSquare();
		}
		// 4. Tax square case
		if (squareElt.getName().equals(Constants.TAG_TAX_SQUARE)) {
			String name = squareElt.getAttributeValue("name");
			int taxAmount = Integer.parseInt(squareElt
					.getAttributeValue(Constants.ATTR_TAX_AMOUNT));
			return new TaxSquare(name, taxAmount);
		}
		// 5. Jail square case
		if (squareElt.getName().equals(Constants.TAG_JAIL)) {
			return new JailSquare(
					squareElt.getAttributeValue(Constants.ATTR_JAIL_NAME),
					Boolean.parseBoolean(squareElt
							.getAttributeValue(Constants.ATTR_JAIL_SIMPLE_VISIT)));
		}
		// 6. Free park case
		if (squareElt.getName().equals(Constants.TAG_FREE_PARK)) {
			return new FreeParkSquare(
					squareElt
							.getAttributeValue(Constants.ATTR_FREE_PARK_SQUARE_NAME));
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IRule> loadRules() {
		List<IRule> rules = new ArrayList<IRule>(0);
		Element rulesElement = document.getRootElement().getChild(
				Constants.TAG_RULES);
		if (null == rulesElement) {
			return rules;
		}
		List<Element> rulesElements = rulesElement.getChildren();
		for (Element rule : rulesElements) {
			String clazz = rule.getAttributeValue(Constants.ATTR_RULE_CLASS);
			if (clazz.isEmpty()) {
				continue;
			}
			try {
				Class<?> ruleClass = Class.forName(clazz);
				Object obj = ruleClass.newInstance();
				if (obj instanceof IRule == false) {
					MonopoleirbLogger
							.getLogger()
							.warning(
									"The object from class \""
											+ clazz
											+ "\" doesn't implements the required interface IRule");
					continue;
				}
				rules.add((IRule) obj);
				MonopoleirbLogger.getLogger().info(
						"[RULE] " + ruleClass.getSimpleName() + " imported !");
			} catch (ClassNotFoundException e) {
				MonopoleirbLogger.getLogger().log(Level.SEVERE, e.getMessage());
			} catch (InstantiationException e) {
				MonopoleirbLogger.getLogger().log(Level.SEVERE, e.getMessage());
			} catch (IllegalAccessException e) {
				MonopoleirbLogger.getLogger().log(Level.SEVERE, e.getMessage());
			}
		}
		MonopoleirbLogger.getLogger().info(rules.size() + " rules imported !");
		return rules;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IGameCard> loadChanceCards() {

		List<IGameCard> result = new ArrayList<IGameCard>(0);
		Element chanceCards = document.getRootElement().getChild(
				Constants.TAG_CHANCE_CARDS);
		if (null == chanceCards) {
			return result;
		}
		List<Element> cardsElements = chanceCards.getChildren();
		for (Element rule : cardsElements) {
			String clazz = rule.getAttributeValue(Constants.ATTR_CARD_CLASS);
			if (clazz.isEmpty()) {
				continue;
			}
			try {
				Class<?> cardClass = Class.forName(clazz);
				Object obj = cardClass.newInstance();
				if (obj instanceof IGameCard == false) {
					MonopoleirbLogger
							.getLogger()
							.warning(
									"The object from class \""
											+ clazz
											+ "\" doesn't implements the required interface IGameGard");
					continue;
				}
				result.add((IGameCard) obj);
				MonopoleirbLogger.getLogger().info(
						"[CARD : CHANCE] " + cardClass.getSimpleName()
								+ " imported !");
			} catch (ClassNotFoundException e) {
				MonopoleirbLogger.getLogger().log(Level.SEVERE, e.getMessage());
			} catch (InstantiationException e) {
				MonopoleirbLogger.getLogger().log(Level.SEVERE, e.getMessage());
			} catch (IllegalAccessException e) {
				MonopoleirbLogger.getLogger().log(Level.SEVERE, e.getMessage());
			}
		}
		MonopoleirbLogger.getLogger().info(
				result.size() + " chance cards imported !");
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IGameCard> loadCommunityChestCards() {

		List<IGameCard> result = new ArrayList<IGameCard>(0);
		Element communityChestCards = document.getRootElement().getChild(
				Constants.TAG_COMMUNITY_CHEST_CARDS);
		if (null == communityChestCards) {
			return result;
		}
		List<Element> cardsElements = communityChestCards.getChildren();
		for (Element rule : cardsElements) {
			String clazz = rule.getAttributeValue(Constants.ATTR_CARD_CLASS);
			if (clazz.isEmpty()) {
				continue;
			}
			try {
				Class<?> cardClass = Class.forName(clazz);
				Object obj = cardClass.newInstance();
				if (obj instanceof IGameCard == false) {
					MonopoleirbLogger
							.getLogger()
							.warning(
									"The object from class \""
											+ clazz
											+ "\" doesn't implements the required interface IGameGard");
					continue;
				}
				result.add((IGameCard) obj);
				MonopoleirbLogger.getLogger().info(
						"[CARD : COMMUNITY CHEST] " + cardClass.getSimpleName()
								+ " imported !");
			} catch (ClassNotFoundException e) {
				MonopoleirbLogger.getLogger().log(Level.SEVERE, e.getMessage());
			} catch (InstantiationException e) {
				MonopoleirbLogger.getLogger().log(Level.SEVERE, e.getMessage());
			} catch (IllegalAccessException e) {
				MonopoleirbLogger.getLogger().log(Level.SEVERE, e.getMessage());
			}
		}
		MonopoleirbLogger.getLogger().info(
				result.size() + " community chest cards imported !");
		return result;
	}
}
