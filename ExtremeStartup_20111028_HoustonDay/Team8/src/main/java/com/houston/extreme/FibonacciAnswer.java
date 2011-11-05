package com.houston.extreme;

import java.util.StringTokenizer;

public class FibonacciAnswer implements Answer {

	@Override
	public boolean canAnswer(String question) {
		if (question
				.matches("what is the \\d+th number in the Fibonacci sequence")) {

			System.out.println("FIBONACCIQUESTION, we can answer this...");
			return true;
		}

		return false;
	}

	@Override
	public String answer(String question) {

		// what is the 5th number in the Fibonacci sequence
		StringTokenizer st = new StringTokenizer(question, "th ");
		StringTokenizer stringTokenizer = new StringTokenizer(st.nextToken(),
				" ");
		int sum = 0;
		while (stringTokenizer.hasMoreElements()) {
			try {

				sum = Integer.parseInt(stringTokenizer.nextToken());
				break;

			} catch (Exception e) {

			}
		}

		String result = fib(sum) + "";
		System.out.println("fiboresu=" + result);
		return result;

	}

	public static int fib(int n) {
		if (n < 2) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
}
