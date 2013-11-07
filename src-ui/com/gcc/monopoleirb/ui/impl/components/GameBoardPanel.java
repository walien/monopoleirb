package com.gcc.monopoleirb.ui.impl.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JPanel;

import com.gcc.monopoleirb.core.GameBoard;
import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.domain.Player;
import com.gcc.monopoleirb.core.squares.ISquare;

public class GameBoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private List<UISquare> uiSquares;
	private Map<Player, Color> playerColors;

	private static final int _CORNER_WIDTH = 100;
	private static final int _CORNER_HEIGHT = 100;
	private static final int _SQUARE_HEIGHT = 100;
	private static final int _LABEL_INTERLINE_SIZE = 10;
	private static final Random _RANDOM = new Random();

	public GameBoardPanel() {
		super();
		uiSquares = new ArrayList<UISquare>();
		playerColors = new HashMap<Player, Color>();
	}

	public void setSquare(List<ISquare> squares) {

		// If the filling of the list is already done : stop
		if (uiSquares.isEmpty() == false) {
			return;
		}

		// 0. Attributes colors
		for (Player player : GameBoard.getGameModel()
				.getPlayers()) {
			playerColors.put(player,
					new Color(_RANDOM.nextInt(256), _RANDOM.nextInt(256),
							_RANDOM.nextInt(256)));
		}

		// 1. Compute dimensions
		Dimension d = getSize();
		int numberOfSquareBySide = (squares.size() / 4) - 1;
		int squareWidth_H = (d.width - 2 * _CORNER_WIDTH)
				/ numberOfSquareBySide;
		int squareHeight_V = (d.height - 2 * _CORNER_HEIGHT)
				/ numberOfSquareBySide;
		int cursorBottom = d.width - _CORNER_WIDTH - squareWidth_H;
		int cursorLeft = d.height - _CORNER_HEIGHT - squareHeight_V;
		int cursorTop = _CORNER_WIDTH;
		int cursorRight = _CORNER_HEIGHT;

		// 2. Paint squares
		for (int i = 0; i < squares.size(); i++) {
			ISquare square = squares.get(i);

			// 2.1 Corners
			if (i == 0) {
				uiSquares.add(new UISquare(square, d.width - _CORNER_WIDTH - 1,
						d.height - _CORNER_HEIGHT - 1, _CORNER_WIDTH,
						_CORNER_HEIGHT, square.getName(), Constants.CURRENCY));
				continue;
			}
			if (i == numberOfSquareBySide + 1) {
				uiSquares.add(new UISquare(square, 0, d.height - _CORNER_HEIGHT
						- 1, _CORNER_WIDTH, _CORNER_HEIGHT, square.getName(),
						Constants.CURRENCY));
				continue;
			}
			if (i == 2 * numberOfSquareBySide + 2) {
				uiSquares.add(new UISquare(square, 0, 0, _CORNER_WIDTH,
						_CORNER_HEIGHT, square.getName(), Constants.CURRENCY));
				continue;
			}
			if (i == 3 * numberOfSquareBySide + 3) {
				uiSquares.add(new UISquare(square, d.width - _CORNER_WIDTH - 1,
						0, _CORNER_WIDTH, _CORNER_HEIGHT, square.getName(),
						Constants.CURRENCY));
				continue;
			}
			// 2.2 Bottom side (1 to 9)
			if (i > 0 && i < numberOfSquareBySide + 1) {
				uiSquares.add(new UISquare(square, cursorBottom, d.height
						- _CORNER_HEIGHT - 1, squareWidth_H, _SQUARE_HEIGHT,
						square.getName(), Constants.CURRENCY));
				cursorBottom -= squareWidth_H;
				continue;
			}
			// 2.3 Left side (11 to 19)
			if (i > numberOfSquareBySide + 1
					&& i <= 2 * numberOfSquareBySide + 1) {
				uiSquares.add(new UISquare(square, 0, cursorLeft,
						_SQUARE_HEIGHT, squareHeight_V, square.getName(),
						Constants.CURRENCY));
				cursorLeft -= squareHeight_V;
				continue;
			}
			// 2.4 Upper side (21 to 29)
			if (i > 2 * numberOfSquareBySide + 2
					&& i < 3 * numberOfSquareBySide + 3) {
				uiSquares.add(new UISquare(square, cursorTop, 0, squareWidth_H,
						_SQUARE_HEIGHT, square.getName(), Constants.CURRENCY));
				cursorTop += squareWidth_H;
				continue;
			}
			// 2.5 Right side (31 to 39)
			if (i > 3 * numberOfSquareBySide + 3) {
				uiSquares.add(new UISquare(square, d.width - _CORNER_WIDTH - 1,
						cursorRight, _SQUARE_HEIGHT, squareHeight_V, square
								.getName(), Constants.CURRENCY));
				cursorRight += squareHeight_V;
				continue;
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		if (uiSquares == null || uiSquares.isEmpty()) {
			return;
		}

		// 0. A (terrible) hack to force the refresh of the panel
		g.clearRect(0, 0, getWidth(), getHeight());

		// 1. Refresh squares
		for (UISquare uiSquare : uiSquares) {
			Rectangle rect = uiSquare.getRect();
			g.drawRect(rect.x, rect.y, rect.width, rect.height);

			String[] nameWords = uiSquare.getLabel().split("\\s");
			int i = 0;
			for (String line : nameWords) {
				g.drawString(line, (rect.x + rect.width / 2)
						- uiSquare.getLabel().length(),
						(rect.y + rect.height / 2) + i);
				i += _LABEL_INTERLINE_SIZE;
			}
		}

		// 2. Refresh players position on the game board
		for (Player player : playerColors.keySet()) {

			int position = player.getCurrentPosition();
			UISquare square = uiSquares.get(position);
			if (null == square) {
				continue;
			}
			Rectangle rect = square.getRect();
			if (null == rect) {
				continue;
			}
			g.setColor(playerColors.get(player));
			g.fillOval(rect.x, rect.y, 20, 20);
			g.setColor(Color.BLACK);
		}
	}
}
