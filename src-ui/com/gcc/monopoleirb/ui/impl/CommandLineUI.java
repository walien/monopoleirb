package com.gcc.monopoleirb.ui.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.log.MonopoleirbLogger;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.PropertySquare;
import com.gcc.monopoleirb.core.squares.SquareType;
import com.gcc.monopoleirb.ui.IUserInterface;

public class CommandLineUI implements IUserInterface {

	private Scanner scanner;
	private boolean demoMode;

	public CommandLineUI(boolean demoMode) {
		this.scanner = new Scanner(System.in);
		this.demoMode = demoMode;
	}

	@Override
	public String askUserForString(String message) {
		displayMessage("==> " + message);
		StringBuilder answer = new StringBuilder();
		if (scanner.hasNext()) {
			answer.append(scanner.nextLine());
		}
		return answer.toString();
	}

	@Override
	public int askUserForInt(String message) {
		MonopoleirbLogger.getLogger().log(Level.INFO, "Ask user for integer");
		try {
			return Integer.parseInt(askUserForString(message));
		} catch (NumberFormatException ex) {
			MonopoleirbLogger.getLogger().log(Level.WARNING,
					"Bad answer (it's not an Integer !)");
			return -1;
		}
	}

	@Override
	public double askUserForDouble(String message) {
		MonopoleirbLogger.getLogger().log(Level.INFO, "Ask user for double");
		try {
			return Double.parseDouble(askUserForString(message));
		} catch (NumberFormatException ex) {
			MonopoleirbLogger.getLogger().log(Level.WARNING,
					"Bad answer (it's not an Double !)");
			return -1;
		}
	}

	@Override
	public boolean askUserForBoolean(String message) {
		MonopoleirbLogger.getLogger().log(Level.INFO, "Ask user for boolean");
		if (demoMode) {
			return true;
		}
		String answer = askUserForString(message);
		if ("yes".equals(answer) || "y".equals(answer) || "oui".equals(answer)
				|| "o".equals(answer)) {
			return true;
		}
		return false;
	}

	@Override
	public List<PropertySquare> askUserForProperties(GameModel context,
			Player player, List<ISquare> props, int numberOfSelection,
			String message) {
		if (props.size() == 0) {
			return null;
		}

		List<PropertySquare> selectedProps = new ArrayList<PropertySquare>(0);

		MonopoleirbLogger.getLogger().log(Level.INFO, "Ask user for property");
		displayMessage(message);

		int i = -1;
		for (ISquare prop : props) {
			if (prop.isType(SquareType.PROPERTY_SQUARE) == false) {
				continue;
			}
			PropertySquare propS = (PropertySquare) prop;
			System.out.println(++i + " - " + prop.getName() + " ["
					+ propS.getFamily() + "] " + " price : " + propS.getPrice()
					+ " mortgaging : " + propS.MORGAGING_VALUE);
		}
		int answer = -1;
		int z = 1;
		do {
			answer = askUserForInt("The property to select [0-" + i + "] ?");
			if (answer >= 0 && answer < props.size()) {
				selectedProps.add((PropertySquare) props.get(answer));
			}
			z++;
		} while (answer > 0
				&& (numberOfSelection == -1 || z < numberOfSelection));

		return selectedProps;
	}

	@Override
	public int askUserForList(String message, String[] elements) {
		displayMessage(message);
		int i = -1;
		for (String element : elements) {
			displayMessage("[" + ++i + "] -> " + element);
		}
		return askUserForInt("Votre choix ?");
	}

	@Override
	public void displayMessage(String message) {
		MonopoleirbLogger.getLogger().log(Level.INFO,
				"Displayed on UI : \"" + message + "\"");
		System.out.println(message);
	}

	@Override
	public boolean refreshUI(GameModel context) {
		return true;
	}
}