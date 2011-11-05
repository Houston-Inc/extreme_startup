package com.houston.extreme;

public class NumericAnswer implements Answer {

	@Override
	public boolean canAnswer(String question) {
		if (question
				.startsWith("which of the following numbers is the largest")) {
			return true;
		}
		return false;
	}

	@Override
	public String answer(String question) {
		System.out.println("question: " + question);
		String[] strings = question.split(":");
		String numbers = strings[1];
		String[] split = numbers.split(",");
		int maxValue = 0;
		for (int i = 0; i < split.length; i++) {
			if (Integer.valueOf(split[i].trim()) > maxValue) {
				maxValue = Integer.valueOf(split[i].trim());
			}

		}

		System.out.println("MAX VALUE: " + maxValue);

		return maxValue + "";
	}

}
