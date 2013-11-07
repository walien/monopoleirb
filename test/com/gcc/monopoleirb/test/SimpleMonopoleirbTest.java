package com.gcc.monopoleirb.test;

import java.util.LinkedList;
import java.util.List;

import com.gcc.monopoleirb.core.CoreInitializer;
import com.gcc.monopoleirb.core.GameBoard;
import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.rules.impl.BuildingRule;
import com.gcc.monopoleirb.core.rules.impl.BuyingAPropertyRule;
import com.gcc.monopoleirb.core.rules.impl.ChanceSquareRule;
import com.gcc.monopoleirb.core.rules.impl.CommunityChestSquareRule;
import com.gcc.monopoleirb.core.rules.impl.DepartureRule;
import com.gcc.monopoleirb.core.rules.impl.DiceDoubleRule;
import com.gcc.monopoleirb.core.rules.impl.FreeParkSquareRule;
import com.gcc.monopoleirb.core.rules.impl.GoingInJailRule;
import com.gcc.monopoleirb.core.rules.impl.RentingAPropertyRule;
import com.gcc.monopoleirb.core.rules.impl.TaxSquareRule;
import com.gcc.monopoleirb.core.squares.ChanceSquare;
import com.gcc.monopoleirb.core.squares.CommunityChestSquare;
import com.gcc.monopoleirb.core.squares.DepartureSquare;
import com.gcc.monopoleirb.core.squares.Field;
import com.gcc.monopoleirb.core.squares.FreeParkSquare;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.JailSquare;
import com.gcc.monopoleirb.core.squares.PropertySquare;
import com.gcc.monopoleirb.core.squares.PublicService;
import com.gcc.monopoleirb.core.squares.SquareFamily;
import com.gcc.monopoleirb.core.squares.TaxSquare;
import com.gcc.monopoleirb.core.squares.TrainStation;
import com.gcc.monopoleirb.ui.impl.CommandLineUI;

public class SimpleMonopoleirbTest {

	private static final int BOARD_TURNS = 500;
	private static final boolean DEMO_MODE = true;

	public static void main(String[] args) {

		// 0. Initialize the system
		CoreInitializer.init();

		// 1. The Game Board (which init all of MVC components)
		new GameBoard(new CommandLineUI(DEMO_MODE));

		// 2. The Game Model
		GameModel model = GameBoard.getGameModel();

		// 3.Square family
		SquareFamily trainStationsFamily = new SquareFamily("train station", 4);
		SquareFamily publicServicesFamily = new SquareFamily("public services",
				2);
		SquareFamily roseFamily = new SquareFamily("rose", 2);
		SquareFamily cyanFamily = new SquareFamily("cyan", 3);
		SquareFamily violetFamily = new SquareFamily("violet", 3);
		SquareFamily orangeFamily = new SquareFamily("orange", 3);
		SquareFamily redFamily = new SquareFamily("red", 3);
		SquareFamily yellowFamily = new SquareFamily("yellow", 3);
		SquareFamily greenFamily = new SquareFamily("green", 3);
		SquareFamily blueFamily = new SquareFamily("blue", 2);

		model.getSquareFamilies().put(1, trainStationsFamily);
		model.getSquareFamilies().put(2, publicServicesFamily);
		model.getSquareFamilies().put(3, roseFamily);
		model.getSquareFamilies().put(4, cyanFamily);
		model.getSquareFamilies().put(5, violetFamily);
		model.getSquareFamilies().put(6, orangeFamily);
		model.getSquareFamilies().put(7, redFamily);
		model.getSquareFamilies().put(8, yellowFamily);
		model.getSquareFamilies().put(9, greenFamily);
		model.getSquareFamilies().put(10, blueFamily);

		// 4. Squares instantiation
		model.getSquares().add(new DepartureSquare("Départ"));

		// 4.1 LEFT SIDE
		model.getSquares().add(
				new Field("Boulevard de Belleville", 6000, roseFamily));
		model.getSquares().add(new CommunityChestSquare());
		model.getSquares().add(new Field("Rue Lecourbe", 6000, roseFamily));
		model.getSquares().add(new TaxSquare("Impots sur le revenu", 15000));
		model.getSquares().add(
				new TrainStation("Gare Montparnasse", 20000,
						trainStationsFamily));
		model.getSquares()
				.add(new Field("Rue De Vaugirard", 10000, cyanFamily));
		model.getSquares().add(new ChanceSquare());
		model.getSquares().add(
				new Field("Rue De Courcelles", 10000, cyanFamily));
		model.getSquares().add(
				new Field("Avenue de La République", 12000, cyanFamily));

		// 4.2 CORNER
		model.getSquares().add(new JailSquare("Simple Visite", true));

		// 4.3 UPPER SIDE
		model.getSquares().add(
				new Field("Boulevard de la Villette", 14000, violetFamily));
		model.getSquares().add(
				new PublicService("EDF", 15000, publicServicesFamily));
		model.getSquares().add(
				new Field("Avenue de Neuilly", 14000, violetFamily));
		model.getSquares()
				.add(new Field("Rue de Paradis", 16000, violetFamily));
		model.getSquares().add(
				new TrainStation("Gare de Lyon", 20000, trainStationsFamily));

		model.getSquares().add(new Field("Avenue Mozart", 18000, orangeFamily));
		model.getSquares().add(new CommunityChestSquare());
		model.getSquares().add(
				new Field("Boulevard Saint-Michel", 18000, orangeFamily));
		model.getSquares().add(new Field("Place Pigalle", 20000, orangeFamily));

		// 4.4 CORNER
		model.getSquares().add(new FreeParkSquare("Parc Gratuit"));

		// 4.5 RIGHT SIDE
		model.getSquares().add(new Field("Avenue Matignon", 22000, redFamily));
		model.getSquares().add(new ChanceSquare());
		model.getSquares().add(
				new Field("Boulevard Malesherbes", 22000, redFamily));
		model.getSquares().add(
				new Field("Avenue Henri-Martin", 24000, redFamily));

		model.getSquares().add(
				new TrainStation("Gare du Nord", 20000, trainStationsFamily));

		model.getSquares().add(
				new Field("Faubourg Saint-Honoré", 26000, yellowFamily));
		model.getSquares().add(
				new Field("Place de la Bourse", 26000, yellowFamily));
		model.getSquares().add(
				new PublicService("Veolia", 15000, publicServicesFamily));
		model.getSquares()
				.add(new Field("Rue La Fayette", 28000, yellowFamily));

		// 4.6 CORNER
		model.getSquares().add(new JailSquare("Prison", false));

		// 4.7 BOTTOM SIDE
		model.getSquares().add(
				new Field("Avenue de Breteuil", 30000, greenFamily));
		model.getSquares().add(new Field("Avenue Foch", 30000, greenFamily));
		model.getSquares().add(new CommunityChestSquare());
		model.getSquares().add(
				new Field("Boulevard des Capucines", 32000, greenFamily));

		model.getSquares().add(
				new TrainStation("Gare Saint-Lazare", 20000,
						trainStationsFamily));

		model.getSquares().add(new ChanceSquare());

		model.getSquares().add(
				new Field("Avenue des Champs-Elysées", 35000, blueFamily));
		model.getSquares().add(new TaxSquare("Taxe de Luxe", 10000));
		model.getSquares().add(new Field("Rue de La Paix", 40000, blueFamily));

		System.out.println("Squares number : " + model.getSquares().size());

		// 5. Rules
		model.getRulesBundle().addRule(new DepartureRule());
		model.getRulesBundle().addRule(new DiceDoubleRule());
		model.getRulesBundle().addRule(new BuyingAPropertyRule());
		model.getRulesBundle().addRule(new RentingAPropertyRule());
		model.getRulesBundle().addRule(new BuildingRule());
		model.getRulesBundle().addRule(new GoingInJailRule());
		model.getRulesBundle().addRule(new ChanceSquareRule());
		model.getRulesBundle().addRule(new CommunityChestSquareRule());
		model.getRulesBundle().addRule(new FreeParkSquareRule());
		model.getRulesBundle().addRule(new TaxSquareRule());

		// 6. Set prices
		setMortgagingAmounts(model.getSquares());
		setRentingPrices(model.getSquares());
		setBuildingPrices(model.getSquares());

		// 7. Players
		model.getPlayers().add(new Player("Elian"));
		model.getPlayers().add(new Player("Joseph"));
		model.getPlayers().add(new Player("Hugues"));
		model.getPlayers().add(new Player("Zoé"));

		// 7. The Game Controller (Executing turns behavior)
		for (int i = 0; i < BOARD_TURNS; i++) {
			GameBoard.getGameController().execNewTurn();
		}

		// 8. Print Final states
		System.out.println("\n-----------------\n");
		for (Player p : model.getPlayers()) {
			System.out.println(p);
		}
		System.out.println("\n-----------------\n");
		for (ISquare s : model.getSquares()) {
			System.out.print(s);
			if (s instanceof Field == false) {
				continue;
			}
			Field f = (Field) s;
			System.out.println(" :::: " + f.getBuildPolicy());
		}
	}

	private static void setRentingPrices(LinkedList<ISquare> squares) {
		for (ISquare square : squares) {
			if (square instanceof Field) {
				Field field = (Field) square;
				field.getRentPolicy().RENT_PRICE = 1000;
				field.getRentPolicy().RENT_PRICE_1_HOUSE = 2000;
				field.getRentPolicy().RENT_PRICE_2_HOUSE = 3000;
				field.getRentPolicy().RENT_PRICE_3_HOUSE = 4000;
				field.getRentPolicy().RENT_PRICE_4_HOUSE = 5000;
				field.getRentPolicy().RENT_PRICE_1_HOTEL = 6000;
			} else if (square instanceof TrainStation) {
				TrainStation station = (TrainStation) square;
				station.RENT_PRICE = 2000;
			}
		}
	}

	private static void setBuildingPrices(LinkedList<ISquare> squares) {
		for (ISquare square : squares) {
			if (square instanceof Field == false) {
				continue;
			}
			Field field = (Field) square;
			field.getBuildPolicy().HOUSE_PRICE = 2500;
			field.getBuildPolicy().HOTEL_PRICE = 5000;
		}
	}

	private static void setMortgagingAmounts(List<ISquare> squares) {
		for (ISquare square : squares) {
			if (square instanceof PropertySquare == false) {
				continue;
			}
			PropertySquare prop = (PropertySquare) square;
			prop.MORGAGING_VALUE = 5000;
		}
	}
}
