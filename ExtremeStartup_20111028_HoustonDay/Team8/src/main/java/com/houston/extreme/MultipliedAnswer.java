package com.houston.extreme;

import java.util.StringTokenizer;

public class MultipliedAnswer implements Answer {

	@Override
	public boolean canAnswer(String question) {

		if (question.matches("what is \\d+ multiplied by \\d+")) {

			System.out.println("MULTIQUESTION, we can answer this...");
			return true;
		}

		return false;
	}

	@Override
	public String answer(String question) {
		StringTokenizer stringTokenizer = new StringTokenizer(question, " ");
		int multi = 1;

		while (stringTokenizer.hasMoreElements()) {
			try {

				multi = multi * Integer.parseInt(stringTokenizer.nextToken());

			} catch (Exception e) {

			}
		}

		System.out.println("ANSWER: " + multi);
		return multi + "";

	}

}
