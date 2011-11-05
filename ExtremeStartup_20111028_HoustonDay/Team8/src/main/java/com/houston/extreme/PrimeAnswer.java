package com.houston.extreme;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PrimeAnswer implements Answer {

	@Override
	public boolean canAnswer(String question) {
		if (question.startsWith("which of the following numbers are primes:")) {

			System.out.println("PRIMEQUESTION, we can answer this...");
			return true;
		}
		return false;

	}

	@Override
	public String answer(String question) {

		// TODO Auto-generated method stub
		StringTokenizer stringTokenizer = new StringTokenizer(question, " ");
		List<Integer> list = new ArrayList<Integer>();

		List<Integer> primes = new ArrayList<Integer>();

		while (stringTokenizer.hasMoreElements()) {
			try {
				String token = stringTokenizer.nextToken();
				if (token.lastIndexOf(",") == token.length()) {
					token = token.substring(0, token.indexOf(","));
				}

				list.add(Integer.parseInt(token));

			} catch (Exception e) {

			}
		}

		for (Integer item : list) {
			if (isPrime(item)) {
				primes.add(item);
			}
		}

		String answer = "";
		int index = 0;
		for (Integer i : primes) {

			if (primes.size() == index + 1) {
				answer += i;
			} else {
				answer += i + ", ";
			}
		}

		return answer;
	}

	boolean isPrime(Integer n) {
		boolean prime = true;
		for (long i = 3; i <= Math.sqrt(n); i += 2)
			if (n % i == 0) {
				prime = false;
				break;
			}
		if ((n % 2 != 0 && prime && n > 2) || n == 2) {
			return true;
		} else {
			return false;
		}

	}

}
