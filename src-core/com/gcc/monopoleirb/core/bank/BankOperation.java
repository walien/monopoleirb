package com.gcc.monopoleirb.core.bank;

public class BankOperation {

	public enum BankOperationType {
		DEBIT, CREDIT
	};

	private BankOperationType type;
	private int amount;
	private Bank sender;
	private Bank receiver;
	private String comment;

	public BankOperation(BankOperationType type, int amount, Bank sender,
			Bank receiver, String comment) {
		super();
		this.type = type;
		this.amount = amount;
		this.sender = sender;
		this.receiver = receiver;
		this.comment = comment;
	}

	public BankOperationType getType() {
		return type;
	}

	public int getAmount() {
		return amount;
	}

	public Bank getBank1() {
		return receiver;
	}

	public Bank getBank2() {
		return sender;
	}

	public String getComment() {
		return comment;
	}

	@Override
	public String toString() {
		return "BankOperation [type=" + type + ", amount=" + amount
				+ ", sender=" + sender + ", receiver=" + receiver
				+ ", comment=" + comment + "]";
	}
}
