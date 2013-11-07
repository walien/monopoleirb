package com.gcc.monopoleirb.core.domain;

import com.gcc.monopoleirb.core.squares.ISquare;

public class Messages {
	
	public static final String YES_MESSAGE = "yes";

	public static final String getBuyQuestionMessage(Player p, ISquare s) {
		return p.getName() + ", would you like to buy the field named : "
				+ s.getName() + " ?";
	}

}
