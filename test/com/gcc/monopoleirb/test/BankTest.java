package com.gcc.monopoleirb.test;

import com.gcc.monopoleirb.core.bank.Bank;

public class BankTest {

	public static void main(String[] args) {
		Bank b1 = new Bank("B1", 10000);
		Bank b2 = new Bank("B2", 5000);

		// Attented result : b1.balance = 9000 and b2.balance = 6000;
		b1.sendMoney(b2, 1000);
		assert b1.getBalance() == 9000;
		assert b2.getBalance() == 6000;

		System.out.println(b1.getOperations());
		System.out.println(b2.getOperations());
	}

}
