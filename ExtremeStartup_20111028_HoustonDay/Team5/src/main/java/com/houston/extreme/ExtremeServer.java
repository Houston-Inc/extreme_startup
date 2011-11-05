package com.houston.extreme;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExtremeServer {

	// http://localhost:8080/extreme/?q=LOL
	@RequestMapping("/")
	public @ResponseBody
	String get(@RequestParam String q) {
		System.out.println(q);

		String[] question = q.split(": ");

		if (q.contains("who is your BOSS")) {
			return "Tomi Ruotimo";

		}

		if (q.contains("which city is the Naesinneula in")) {
			return "Tampere";

		}

		if (q.contains("what colour is a banana")) {
			return "Yellow";

		}

		if (q.contains("onko hauki kala")) {
			return "On";

		}

		if (question.length == 3) {

			if (question[1].contains("largest")) {
				String[] values = question[2].split(", ");

				Integer largest = -Integer.MAX_VALUE;
				for (String value : values) {

					Integer currentNum = Integer.parseInt(value);

					if (currentNum > largest) {
						largest = currentNum;
					}

				}

				return largest.toString();
			}
			if (question[1].contains("square")) {
				String[] values = question[2].split(", ");

				for (String value : values) {
					Double sqr = Math.sqrt(Integer.parseInt(value));
					Double cube = Math.cbrt(Integer.parseInt(value));
					if (sqr - Math.floor(sqr) == 0
							&& cube - Math.floor(cube) == 0) {
						return value.toString();
					}
				}
				return "";
			}
			if (question[1].contains("primes")) {
				String[] values = question[2].split(", ");
				StringBuilder builder = new StringBuilder();
				for (String value : values) {
					Integer i = Integer.parseInt(value);
					if (isPrime(i)) {
						builder.append(i);
						builder.append(",");
					}

				}

				if (builder.toString().length() > 1) {

					return builder.toString().substring(0,
							builder.toString().length() - 1);
				} else {
					return "";
				}

			}

		}

		if (question.length == 2) {
			if (question[1].contains("plus") && !question[1].contains("multi")) {
				String[] words = question[1].split(" ");
				Integer res = 0;
				for (String w : words) {
					try {
						Integer i = Integer.parseInt(w);
						res = res + i;
					} catch (Exception e) {
					}
				}
				return res.toString();
			}

			if (question[1].contains("multiplied") && !question[1].contains("plus")) {
				String[] words = question[1].split(" ");
				Integer res = 1;
				for (String w : words) {
					try {
						Integer i = Integer.parseInt(w);
						res = res * i;
					} catch (Exception e) {
					}
				}
				return res.toString();
			}

			if (question[1].contains("plus") && question[1].contains("multi")) {
				String[] words = question[1].split(" ");
				List<Integer> numbers = new LinkedList<Integer>();
				for (String w : words) {
					try {
						Integer i = Integer.parseInt(w);
						numbers.add(i);
					} catch (Exception e) {
					}
				}

				return String.valueOf(numbers.get(0) * numbers.get(1)
						+ numbers.get(2));
			}


			if (question[1].contains("power")) {
				String[] words = question[1].split(" ");
				Integer res = 1;
				List<Double> numbers = new LinkedList<Double>();
				for (String w : words) {
					try {
						Double i = Double.parseDouble(w);
						numbers.add(i);
					} catch (Exception e) {
					}
				}
				return String.valueOf(((int) Math.pow(numbers.get(0),
						numbers.get(1))));
			}

			if (question[1].contains("minus")) {
				String[] words = question[1].split(" ");
				Integer res = 0;
				List<Integer> numbers = new LinkedList<Integer>();
				for (String w : words) {
					try {
						Integer i = Integer.parseInt(w);
						numbers.add(i);
					} catch (Exception e) {
					}
				}

				return String.valueOf((numbers.get(0) - numbers.get(1)));
			}

			if (question[1].contains("Fibonacci")) {
				String[] words = question[1].split(" ");
				Integer res = 0;
				for (String w : words) {
					try {
						w = StringUtils.remove(w, "st");
						w = StringUtils.remove(w, "nd");
						w = StringUtils.remove(w, "rd");
						w = StringUtils.remove(w, "th");

						Integer i = Integer.parseInt(w);

						return getFibonacciSequence(i).toString();
					} catch (Exception e) {
					}
				}
				return res.toString();
			}

		}
		return "Houston Inc.";

	}

	private Integer getFibonacciSequence(Integer i) {

		if (i < 2) {
			return i;
		} else {
			return getFibonacciSequence(i - 1) + getFibonacciSequence(i - 2);
		}
	}

	private boolean isPrime(int num) {
		boolean prime = true;
		int limit = (int) Math.sqrt(num);

		for (int i = 2; i <= limit; i++) {
			if (num % i == 0) {
				prime = false;
				break;
			}
		}

		return prime;
	}

}
