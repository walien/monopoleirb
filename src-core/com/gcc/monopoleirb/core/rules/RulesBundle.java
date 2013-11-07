package com.gcc.monopoleirb.core.rules;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.gcc.monopoleirb.core.squares.SquareType;

public class RulesBundle {

	private List<IRule> rules;

	public RulesBundle() {
		rules = new ArrayList<IRule>();
	}

	public List<IRule> getRules() {
		return rules;
	}

	public void addRule(IRule rule) {
		rules.add(rule);
	}

	public void addAllRules(List<IRule> newRules) {
		rules.addAll(newRules);
	}

	public List<IRule> getRulesBySquareType(EnumSet<SquareType> squareTypes) {

		List<IRule> newrules = new ArrayList<IRule>();
		for (IRule rule : rules) {
			for (SquareType type : squareTypes) {
				if (rule.getConcernedSquareTypes().contains(type)) {
					newrules.add(rule);
					break;
				}
			}
		}

		return newrules;
	}
}
