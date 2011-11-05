package com.houston.extreme;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MinusAnswer implements Answer {

	@Override
	public boolean canAnswer(String question) {

		if (question.matches("what is \\d+ minus \\d+")) {

			System.out.println("MINUSQUESTION, we can answer this...");
			return true;
		}

		return false;
	}

	@Override
	public String answer(String question) {

		StringTokenizer stringTokenizer = new StringTokenizer(question, " ");
		int minus = 0;
		int firstInteger = 0;
		boolean isFirst = true;
		List<Integer> numbers = new ArrayList<Integer>();

		while (stringTokenizer.hasMoreElements()) {
			try {
				numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
			} catch (Exception e) {

			}
		}

		int base = numbers.get(0);
		return base - numbers.get(1) + "";

	}
}
