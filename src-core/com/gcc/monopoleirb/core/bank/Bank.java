package com.gcc.monopoleirb.core.bank;

import java.util.ArrayList;
import java.util.List;

import com.gcc.monopoleirb.core.bank.BankOperation.BankOperationType;

public class Bank {

	private String name;
	private double balance;
	private List<BankOperation> operations;

	public Bank(String name, double balance) {
		this.name = name;
		this.balance = balance;
		this.operations = new ArrayList<BankOperation>();
	}

	public Bank(String name) {
		this(name, 0);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void cleanBank() {
		this.balance = 0;
	}

	public List<BankOperation> getOperations() {
		return operations;
	}

	private boolean debit(double amount) {
		if ((balance - amount) < 0) {
			return false;
		}
		balance -= amount;
		return true;
	}

	public boolean receiveMoney(Bank sender, int amount) {
		if (sender == null) {
			return false;
		}
		balance += amount;
		operations.add(new BankOperation(BankOperationType.CREDIT, amount,
				sender, this, ""));
		return true;
	}

	public boolean sendMoney(Bank receiver, int amount) {
		if (receiver == null || !debit(amount)) {
			return false;
		}
		receiver.receiveMoney(this, amount);
		operations.add(new BankOperation(BankOperationType.DEBIT, amount, this,
				receiver, ""));
		return true;
	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", balance=" + balance + "]";
	}
}