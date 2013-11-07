package com.gcc.monopoleirb.ui.impl.components;

import java.awt.Color;
import java.awt.Rectangle;

import com.gcc.monopoleirb.core.squares.ISquare;

public class UISquare {

	private ISquare square;
	private Rectangle rect;
	private Color color;
	private String label;
	private String price;

	public UISquare(ISquare square, Rectangle rect, Color color, String label,
			String price) {
		super();
		this.square = square;
		this.rect = rect;
		this.color = color;
		this.label = label;
		this.price = price;
	}

	public UISquare(ISquare square, int x, int y, int width, int height,
			String label, String price) {
		this(square, new Rectangle(x, y, width, height), Color.WHITE, label,
				price);
	}

	public ISquare getModelSquare() {
		return square;
	}

	public Rectangle getRect() {
		return rect;
	}

	public Color getColor() {
		return color;
	}

	public String getLabel() {
		return label;
	}

	public String getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "UISquare [color=" + color + ", label=" + label + ", price="
				+ price + ", rect=" + rect + "]";
	}
}
