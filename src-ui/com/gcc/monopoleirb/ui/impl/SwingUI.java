package com.gcc.monopoleirb.ui.impl;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.gcc.monopoleirb.core.GameModel;
import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.log.MonopoleirbLogger;
import com.gcc.monopoleirb.core.squares.ISquare;
import com.gcc.monopoleirb.core.squares.PropertySquare;
import com.gcc.monopoleirb.ui.IUserInterface;
import com.gcc.monopoleirb.ui.impl.components.GameBoardPanel;

public class SwingUI implements IUserInterface {

	private JFrame frame;
	private GameBoardPanel gameBoard;

	private static final int _BOARD_WIDTH = 1024;
	private static final int _BOARD_HEIGHT = 1056;

	public SwingUI() {
		render();
	}

	private void render() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(_BOARD_WIDTH, _BOARD_HEIGHT);
		frame.setVisible(true);
		frame.setTitle(Constants.APP_NAME + " " + Constants.APP_VERSION);

		gameBoard = new GameBoardPanel();
		frame.setContentPane(gameBoard);
	}

	@Override
	public boolean askUserForBoolean(String message) {
		// return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(frame,
		// message, "Question ?", JOptionPane.YES_NO_OPTION);
		return true;
	}

	@Override
	public double askUserForDouble(String message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int askUserForInt(String message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int askUserForList(String message, String[] elements) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PropertySquare> askUserForProperties(GameModel c, Player p,
			List<ISquare> props, int maxSelection, String message) {
		String[] columnNames = { "Property Name", "Property Price" };

		Object[][] data = new Object[props.size()][2];
		int i = 0;
		for (ISquare square : props) {
			PropertySquare prop = (PropertySquare) square;
			data[i][0] = prop.getName();
			data[i][1] = String.valueOf(prop.getPrice());
			i++;
		}

		final JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JScrollPane scrollPane = new JScrollPane(table);

		final JComponent[] inputs = new JComponent[] { new JLabel(message),
				scrollPane };
		JOptionPane.showMessageDialog(null, inputs, p.getName()
				+ " : Choose a property", JOptionPane.PLAIN_MESSAGE);

		if (table.getSelectedRowCount() == 0) {
			return new ArrayList<PropertySquare>(0);
		}
		List<PropertySquare> selectedSquares = new ArrayList<PropertySquare>();
		for (Integer selectedRow : table.getSelectedRows()) {
			selectedSquares.add((PropertySquare) props.get(selectedRow));
		}

		return selectedSquares;
	}

	@Override
	public String askUserForString(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayMessage(String message) {
		// JOptionPane.showMessageDialog(frame, message);
	}

	@Override
	public boolean refreshUI(GameModel context) {
		MonopoleirbLogger.getLogger().info("Refreshing UI");
		gameBoard.setSquare(context.getSquares());
		gameBoard.repaint();
		gameBoard.revalidate();
		return true;
	}
}