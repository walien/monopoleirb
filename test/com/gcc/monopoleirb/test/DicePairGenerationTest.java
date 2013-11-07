package com.gcc.monopoleirb.test;

import com.gcc.monopoleirb.core.domain.DicePair;

public class DicePairGenerationTest {

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			DicePair pair = DicePair.generateDicePair();
			System.out.println(pair);
			if (pair.isDouble()) {
				System.out.println("-------------DOUBLE-------------");
			}
		}
	}
}
