package com.houston.extreme;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PowerAnswer implements Answer {

	@Override
	public boolean canAnswer(String question) {
		// what is 11 to the power of 2
		if (question.matches("what is \\d+ to the power of \\d+")) {

			System.out.println("POWERQUESTION, we can answer this...");
			return true;
		}
		return false;
	}

	@Override
	public String answer(String question) {
		StringTokenizer stringTokenizer = new StringTokenizer(question, " ");

		List<Integer> numbers = new ArrayList<Integer>();

		while (stringTokenizer.hasMoreElements()) {
			try {
				numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
			} catch (Exception e) {

			}
		}

		int base = numbers.get(0);
		return new Double(Math.pow(base, numbers.get(1))).intValue() + "";

	}

}
