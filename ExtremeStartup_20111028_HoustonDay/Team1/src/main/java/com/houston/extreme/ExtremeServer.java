package com.houston.extreme;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExtremeServer {
	static Map<String, String> answers = new HashMap<String, String>();
	static {
		answers.put("who played James Bond in the film Dr No", "Sean Connery");
		answers.put("onko hauki kala", "on");
		answers.put("who is your BOSS", "Tomi Ruotimo");
		answers.put("which city is the Naesinneula in", "Tampere");
	}

	public String read() {
		try {
			FileInputStream stream = new FileInputStream("input.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					stream));
			return reader.readLine();
		} catch (IOException e) {
			System.err.println(e);
			return "";
		}
	}

	public String add(String q) {
		String[] parts = q.split(" ");
		return String.valueOf(Integer.parseInt(parts[3])
				+ Integer.parseInt(parts[5]));
	}

	public String addTwice(String q) {
		String[] parts = q.split(" ");
		return String.valueOf(Integer.parseInt(parts[3])
				+ Integer.parseInt(parts[5]) + Integer.parseInt(parts[7]));
	}

	public String minus(String q) {
		String[] parts = q.split(" ");
		return String.valueOf(Integer.parseInt(parts[3])
				- Integer.parseInt(parts[5]));
	}

	public String multiple(String q) {
		String[] parts = q.split(" ");
		return String.valueOf(Integer.parseInt(parts[3])
				* Integer.parseInt(parts[6]));
	}

	public String multiplyAndAdd(String q) {
		String[] parts = q.split(" ");
		return String.valueOf(Integer.parseInt(parts[3])
				* Integer.parseInt(parts[6]) + Integer.parseInt(parts[8]));
	}

	public String addAndMultiply(String q) {
		String[] parts = q.split(" ");
		return String.valueOf(Integer.parseInt(parts[3])
				+ Integer.parseInt(parts[5]) * Integer.parseInt(parts[8]));
	}

	public String power(String q) {
		String[] parts = q.split(" ");
		return String.valueOf((long) Math.pow(Double.parseDouble(parts[3]),
				Double.parseDouble(parts[8])));
	}

	public String sort(String q) {
		String[] parts = q.split("[, ]");
		int largest = Integer.MIN_VALUE;
		for (String part : parts) {
			try {
				int value = Integer.parseInt(part);
				if (value > largest) {
					largest = value;
				}
			} catch (NumberFormatException ex) {
			}
		}
		return String.valueOf(largest);
	}

	public String squareAndCube(String q) {
		String[] parts = q.split("[, ]");
		for (String part : parts) {
			try {
				int value = Integer.parseInt(part);
				for (int i = 1; i < value; i++) {
					if (i * i == value) {
						for (int j = 1; j < value; j++) {
							if (j * j * j == value) {
								return String.valueOf(value);
							}
						}
					}
				}
			} catch (NumberFormatException ex) {
			}
		}
		return "";
	}

	public String fibo(long previous, long last, int lastIndex, int searchIndex) {
		if (searchIndex == lastIndex) {
			return String.valueOf(last);
		}

		return fibo(last, previous + last, lastIndex + 1, searchIndex);
	}

	public String primes(String q) {
		String[] parts = q.split("[, ]");
		StringBuilder primes = new StringBuilder();
		for (String part : parts) {
			try {
				int value = Integer.parseInt(part);
				int i = 2;
				for (; i < value; i++) {
					if (value % i == 0) {
						break;
					}
				}
				if (i == value) {
					if (primes.length() > 0) {
						primes.append(", ");
					}
					primes.append(value);
				}
			} catch (NumberFormatException ex) {
			}
		}
		return primes.toString();
	}

	// http://localhost:8080/extreme/?q=LOL
	@RequestMapping("/")
	public @ResponseBody
	String get(@RequestParam String q) {
		System.out.println(q);
		String a = null;
		int indexOfPlus = q.indexOf("plus");
		int indexOfMultiplied = q.indexOf("multiplied");
		if (q.indexOf("what is") > 0 && indexOfPlus > 0
				&& (indexOfMultiplied < 0 || indexOfMultiplied > indexOfPlus)) {
			if (q.split("plus").length > 2) {
				a = addTwice(q);
			} else if (q.indexOf("multiplied") > 0) {
				a = addAndMultiply(q);
			} else {
				a = add(q);
			}
		} else if (q.indexOf("what is") > 0 && q.indexOf("minus") > 0) {
			a = minus(q);
		} else if (q.indexOf("what is") > 0 && q.indexOf("multiplied") > 0) {
			if (q.indexOf("plus") > 0) {
				a = multiplyAndAdd(q);
			} else {
				a = multiple(q);
			}
		} else if (q.indexOf("what is") > 0 && q.indexOf("to the power") > 0) {
			a = power(q);
		} else if (q.indexOf("which of the") > 0 && q.indexOf("larges") > 0) {
			a = sort(q);
		} else if (q.indexOf("which of the") > 0 && q.indexOf("square") > 0) {
			a = squareAndCube(q);
		} else if (q.indexOf("which of the") > 0 && q.indexOf("primes") > 0) {
			a = primes(q);
		} else if (q.indexOf("where do you work") > 0) {
			a = "Houston Inc.";
		} else if (q.indexOf("what colour is a banana") > 0) {
			a = "yellow";
		} else if (q.indexOf("Fibonacci") > 0) {
			String[] index = q.split(" ");
			String index2 = index[4].substring(0, index[4].length() - 2);
			if (index2.equals("1")) {
				a = "0";
			} else {
				try {
					a = fibo(0, 1, 2, Integer.parseInt(index2));
				} catch (NumberFormatException nex) {
				}
			}
		} else {
			for (String question : answers.keySet()) {
				if (q.indexOf(question) > 0) {
					a = answers.get(question);
					break;
				}
			}
		}
		if (a != null) {
			System.out.println(q + "=" + a);
			return a;
		}
		try {
			Thread.sleep(30000L);
		} catch (InterruptedException e) {
		}
		a = read();
		System.out.println(q + "=" + a);
		return a;
	}
}
