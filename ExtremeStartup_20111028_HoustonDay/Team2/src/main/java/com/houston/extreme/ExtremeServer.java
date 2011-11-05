package com.houston.extreme;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExtremeServer {
	
	// http://localhost:8080/extreme/?q=LOL
	@RequestMapping("/")
	public @ResponseBody String get(@RequestParam String q) {
		if (messageIs(q, "what is your name")) {
			return a1();
		}
		if (messageIs(q, "which of the following numbers is the largest")) {
			return a2(q);
		}
		if (messageIs(q, "plus")) {
			return a3(q);
		}
		if (messageIs(q, "multiplied by")) {
			return a4(q);
		}
		if (messageIs(q, "hich of the following numbers is both a square and a cube")) {
			return a5(q);
		}
		if (messageIs(q, "colour")) {
			return a6(q);
		}
		if (messageIs(q, "BOSS")) {
			return a7(q);
		}
		if (messageIs(q, "which of the following numbers are primes")) {
			return a8(q);
		}
		if (messageIs(q, "minus")) {
			return a9(q);
		}
		if (messageIs(q, "hauki")) {
			out("hauki");
			return "on";
		}
		if (messageIs(q, "bond")) {
			out("bond");
			return "Sean Connery";
		}
		if (messageIs(q, "naesin")) {
			out("naesin");
			return "Tampere";
		}
		if (messageIs(q, "where do you work")) {
			out("work");
			return "Houston Inc.";
		}
		if (messageIs(q, "fibonacci")) {
			return a10(q);
		}
		if (messageIs(q, "the power")) {
			return a11(q);
		}
		out("VIELA TEKEMATTA: " + q);
		return "KOOODAAAA AKKIA PERHAANAAAAA";
	}
	
	private String a1() {
		out("Name done.");
		return "HeSa";
	}
	
	private String a2(String q) {
		out("Largest: " + q);//which of the following numbers is the largest: 15, 700, 46, 258

		String[] split = q.split(" ");
		ArrayList<Integer> numbers = extractNumbers(split);
		int max = extractMax(numbers);
		out("Result: " + max);
		return "" + max;
    }
	private String a3(String str) {
		out("Plus: " + str);
		String[] arr = str.split(" ");
		ArrayList<Integer> list = extractNumbers(arr);
		int res = 0;
		for (Integer i : list) {
			res += i;
		}
		
		out("Result: " + res);
		return "" +res;
	}
	private String a4(String str) {
		out("multiply:" + str);
		String[] arr = str.split(" ");
		ArrayList<Integer> list = extractNumbers(arr);
		int res = 1;
		for (Integer i : list) {
			res *= i;
		}
		out("Result: " + res);
		return res + "";
	}
	private String a5(String str) {
		out("square etc:" + str);
		String[] arr = str.split(" ");
		List<Integer> list = extractNumbers(arr);
		int res = -1;
		for (Integer i : list) {
			if (isCube(i) && isSquare(i)) {
				res = i;
			}
		}
		out("Result: " + res);
		if (res == -1) {
			return "";
		}
		return ""+res;
	}
	private String a6(String q) {
		out("colour: " + q);
		return "yellow";
	}
	private String a7(String q) {
		out("BOSS: " + q);
		return "Tomi Ruotimo";
	}

	boolean isPrime(Integer n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
/*	
	private boolean  IsPrime(int number) 
	{
		if (number == 1 || number == 2)
			return true;
		for (int i=2; i<(int)(number/2); i++)//assumes number is unsigned...I don't even know that you *can* have unsigned numbers in Java...in either case, I'm sure there's a Math.abs() or something similar that you could use
			{
			if ( (number/i)==(int)(number/i) )
			return false;
			}
			return true;
	}
	*/
	private ArrayList<Integer> extractNumbers(String[] arr) {
		ArrayList nums = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			Integer num = null;
			try {
				
				num = Integer.parseInt(arr[i].replaceAll(",",""));
			} catch (Exception e) {
				continue;
			}
			nums.add(num);
		}
		return nums;
	}
	
	
	private int extractMax(ArrayList<Integer> list) {
		int max = -1;
		for (Integer i : list) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	private String a8(String nums) {
		out("prime " + nums);
		ArrayList<Integer>  l = extractNumbers(nums.split(" "));
		String res = "";
		for (Integer i : l) {
			if (isPrime(i)) {
				if (res.length() > 0)
					res += ", ";
				res += i;
			}
		}
		out("Result: " + res);
		return res;
	}
	private String a9(String str) {
		out("multiply:" + str);
		String[] arr = str.split(" ");
		ArrayList<Integer> list = extractNumbers(arr);
		int res = list.get(0) - list.get(1);
		out("Result: " + res);
		return res + "";
	}
	
	private int multiply(int i1, int i2) {
		return i1*i2;
	}
	
	private String a10(String q) {
		out("Fibonacci: " + q);
		String beg = q.split("the ")[1];
		beg = beg.replaceAll("th","");
		beg = beg.split(" ")[0];
		int begInt = Integer.parseInt(beg);
		BigInteger prevNum = new BigInteger("0");
		BigInteger num = new BigInteger("1");
		BigInteger temp = new BigInteger("0");
		BigInteger res = new BigInteger("0");
		if (begInt == 1) {
			out("Result: 0");
			return "0";
		} else if (begInt == 2) {
			out("Result: 1");
			return "1";
		}
		for (int i = 0; i < begInt -1; i++) {
			temp = new BigInteger(num.toString());
			out("temp: " + temp.toString());
//			temp = num;
			res = prevNum.add(num);
//			prevNum = temp;
			prevNum = new BigInteger(temp.toString());
//			num = res;
			num = new BigInteger(res.toString());
		}
		out("Result: " + res);
		return "" + res.toString();
	}
	private String a11(String str) {
		out("power:" + str);
		String[] arr = str.split(" ");
		ArrayList<Integer> list = extractNumbers(arr);
		BigInteger val1 = new BigInteger(list.get(0) + "");
		BigInteger val2 = new BigInteger(list.get(1) + "");
		BigInteger result = val1.pow(val2.intValue());
		long res = (long) Math.pow(list.get(0), list.get(1));
		out("Result: " + result.toString());
		return result.toString() + "";
	}

	private boolean isCube(int i) {
		double res = Math.cbrt(i);
		int resint = (int)res;
		if (resint == res) {
			return true;
		}
		return false;
	}

	private boolean isSquare(int i) {
		double res = Math.sqrt(i);
		int resint = (int)res;
		if (resint == res) {
			return true;
		}
		return false;
	}
	
	private boolean messageIs(String q, String string) {
		return q.toLowerCase().indexOf(string.toLowerCase()) != -1;
	}

	private void out(String str) {
		System.out.println(str);
	}
}
