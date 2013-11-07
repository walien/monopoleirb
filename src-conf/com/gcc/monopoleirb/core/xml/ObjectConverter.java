package com.gcc.monopoleirb.core.xml;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.cards.IGameCard;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.domain.conf.TypeCard;
import com.gcc.monopoleirb.core.domain.conf.TypeChanceSquare;
import com.gcc.monopoleirb.core.domain.conf.TypeCommunityChest;
import com.gcc.monopoleirb.core.domain.conf.TypeDepartureSquare;
import com.gcc.monopoleirb.core.domain.conf.TypeFamily;
import com.gcc.monopoleirb.core.domain.conf.TypeField;
import com.gcc.monopoleirb.core.domain.conf.TypeFreePark;
import com.gcc.monopoleirb.core.domain.conf.TypeJail;
import com.gcc.monopoleirb.core.domain.conf.TypePlayer;
import com.gcc.monopoleirb.core.domain.conf.TypePublicService;
import com.gcc.monopoleirb.core.domain.conf.TypeRule;
import com.gcc.monopoleirb.core.domain.conf.TypeTaxSquare;
import com.gcc.monopoleirb.core.domain.conf.TypeTrainStation;
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

public class ObjectConverter {

	public static final Player confPlayerToPlayer(TypePlayer player) {
		return new Player(player.getName(), player.getBank().doubleValue());
	}

	public static final ISquare confSquareToSquare(Object square,
			GameModel model) {

		// 0. Retrieve the model
		if (model == null) {
			return null;
		}

		// 1. DepartureSquare
		if (square instanceof TypeDepartureSquare) {
			TypeDepartureSquare departure = (TypeDepartureSquare) square;
			return new DepartureSquare(departure.getName());
		}

		// 2. Field
		if (square instanceof TypeField) {
			TypeField field = (TypeField) square;

			// Retrieve the field family
			SquareFamily family = model.getSquareFamilies().get(
					field.getFamily().intValue());

			// Create the engine object
			Field f = new Field(field.getName(), field.getBuyingPrice()
					.intValue(), family);

			// Mortgaging
			f.MORGAGING_VALUE = field.getMortgagePolicy().getAmount()
					.intValue();

			// Building
			f.getBuildPolicy().HOUSE_PRICE = field.getBuildPolicy()
					.getHousePrice().intValue();
			f.getBuildPolicy().HOTEL_PRICE = field.getBuildPolicy()
					.getHotelPrice().intValue();

			// Renting
			f.getRentPolicy().RENT_PRICE_1_HOUSE = field.getRentPolicy()
					.getRentPolicy1().intValue();
			f.getRentPolicy().RENT_PRICE_2_HOUSE = field.getRentPolicy()
					.getRentPolicy2().intValue();
			f.getRentPolicy().RENT_PRICE_3_HOUSE = field.getRentPolicy()
					.getRentPolicy3().intValue();
			f.getRentPolicy().RENT_PRICE_4_HOUSE = field.getRentPolicy()
					.getRentPolicy4().intValue();
			f.getRentPolicy().RENT_PRICE_1_HOTEL = field.getRentPolicy()
					.getRentPolicy5().intValue();

			return f;
		}

		// 3. Train Station
		if (square instanceof TypeTrainStation) {

			TypeTrainStation train = (TypeTrainStation) square;

			// Retrieve the field family
			SquareFamily family = model.getSquareFamilies().get(
					train.getFamily().intValue());

			// Create the engine object
			TrainStation station = new TrainStation(train.getName(), train
					.getBuyingPrice().intValue(), family);

			// Mortgaging
			station.MORGAGING_VALUE = train.getMortgagePolicy().getAmount()
					.intValue();

			// Renting
			station.RENT_PRICE = train.getRentPolicy().getRentingPrice()
					.intValue();

			return station;
		}

		// 4. Public service
		if (square instanceof TypePublicService) {

			TypePublicService service = (TypePublicService) square;

			// Retrieve the field family
			SquareFamily family = model.getSquareFamilies().get(
					service.getFamily().intValue());

			// Create the engine object
			PublicService publicService = new PublicService(service.getName(),
					service.getBuyingPrice().intValue(), family);

			// Mortgaging
			publicService.MORGAGING_VALUE = service.getMortgagePolicy()
					.getAmount().intValue();

			return publicService;
		}

		// 5. Tax Square
		if (square instanceof TypeTaxSquare) {

			TypeTaxSquare tax = (TypeTaxSquare) square;

			// Create the engine object
			TaxSquare taxSquare = new TaxSquare(tax.getName(), tax
					.getTaxAmount().intValue());

			return taxSquare;
		}

		// 6. Jail Square
		if (square instanceof TypeJail) {

			TypeJail jail = (TypeJail) square;

			// Create the engine object
			return new JailSquare(jail.getName(), jail.isSimpleVisit());
		}

		// 7. Chance Square
		if (square instanceof TypeChanceSquare) {

			// Create the engine object
			return new ChanceSquare();
		}

		// 8. Community Chest Square
		if (square instanceof TypeCommunityChest) {

			// Create the engine object
			return new CommunityChestSquare();
		}

		// 9. Free Park Square
		if (square instanceof TypeFreePark) {

			TypeFreePark free = (TypeFreePark) square;

			// Create the engine object
			return new FreeParkSquare(free.getName());
		}

		return null;
	}

	public static final SquareFamily confFamilyToSquareFamily(TypeFamily family) {
		return new SquareFamily(family.getName(), family
				.getNumberOfProperties().intValue());
	}

	public static final IRule confRuleToRule(TypeRule rule) {

		String clazz = rule.getClazz();
		if (clazz == null || clazz.isEmpty()) {
			return null;
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
				return null;
			}
			return (IRule) obj;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static final IGameCard confGameCardToGameCard(TypeCard rule) {

		String clazz = rule.getClazz();
		if (clazz == null || clazz.isEmpty()) {
			return null;
		}
		try {
			Class<?> ruleClass = Class.forName(clazz);
			Object obj = ruleClass.newInstance();
			if (obj instanceof IGameCard == false) {
				MonopoleirbLogger
						.getLogger()
						.warning(
								"The object from class \""
										+ clazz
										+ "\" doesn't implements the required interface IGameCard");
				return null;
			}
			return (IGameCard) obj;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
}
