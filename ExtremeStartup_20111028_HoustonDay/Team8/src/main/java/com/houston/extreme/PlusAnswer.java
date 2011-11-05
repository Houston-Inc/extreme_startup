package com.houston.extreme;

import java.util.StringTokenizer;

public class PlusAnswer implements Answer {

	@Override
	public boolean canAnswer(String question) {

		if (question.matches("what is \\d+ plus \\d+")) {

			System.out.println("PLUSQUESTION, we can answer this...");
			return true;
		}

		return false;
	}

	@Override
	public String answer(String question) {

		StringTokenizer stringTokenizer = new StringTokenizer(question, " ");
		int sum = 0;
		while (stringTokenizer.hasMoreElements()) {
			try {

				sum = sum + Integer.parseInt(stringTokenizer.nextToken());

			} catch (Exception e) {

			}
		}

		System.out.println("ANSWER: " + sum);
		return sum + "";
	}

}
