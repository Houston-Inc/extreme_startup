package com.houston.extreme;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SquareCubeAnswer implements Answer {

	@Override
	public boolean canAnswer(String question) {
		// which of the following numbers is both a square and a cube: 559, 400,
		// 537, 1681

		if (question
				.startsWith("which of the following numbers is both a square and a cube:")) {

			System.out.println("SQUAREQUESTION, we can answer this...");
			return true;
		}
		return false;
	}

	@Override
	public String answer(String question) {
		// TODO Auto-generated method stub
		StringTokenizer stringTokenizer = new StringTokenizer(question, " ");
		List<Integer> list = new ArrayList<Integer>();

		while (stringTokenizer.hasMoreElements()) {
			try {
				list.add(Integer.parseInt(stringTokenizer.nextToken()));

			} catch (Exception e) {

			}
		}

		for (Integer item : list) {
			if (isCube(item) && isSquare(item)) {
				System.out.println("Answering: " + item);
				return item + "";
			}
		}

		System.out.println("Answering empty string. ");
		return "";
	}

	private boolean isSquare(Integer i) {
		double sqrt = Math.sqrt(i);
		if (sqrt == Math.floor(sqrt)) {
			return true;
		}
		return false;
	}

	private boolean isCube(Integer i) {
		double cube = Math.cbrt(i);

		if (cube == Math.floor(cube)) {
			return true;
		}
		return false;
	}
}
