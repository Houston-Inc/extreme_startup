package com.houston.extreme;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExtremeServer {
	enum Operation {
		Plus,
		Minus,
		Multiply,
		Divide,
		Unknown
	}
	
	String multi = " multiplied by ";
	String plus =  " plus ";
	String minus =  " minus ";
	
	// http://localhost:8080/extreme/?q=LOL
	@RequestMapping("/")
	public @ResponseBody String get(@RequestParam String q) {
		System.out.println("kysymys: " + q);
		//return "ExtremeStartup" + q;

		return handleQuestion(filter(q));
	}
	//kysymys: 4a7f1d00: which of the following numbers is both a square and a cube: 121, 196, 16, 918
	//kysymys: 4d910e50: what is 11 multiplied by 9
	//  what is 4 multiplied by 19
	// kysymys: 79074990: which of the following numbers are primes: 644, 307
	//ysymys: dc373b50: what colour is a banana
	//what is 13 plus 0 plus 4

	private String filter(String q) {
		String args = q.substring(q.indexOf(": ")+2);
		System.out.println("PARSED: " + args);
		return args;
	}
// : where do you work

	private String handleQuestion(String question) {
		String answer = "";
		Integer result = 0;
		
		if (question.contains("which of the following numbers is the largest: ")) {
			String math = question.replace("which of the following numbers is the largest: ", "");
			String[] args = math.split(", ");
			Integer largest = Integer.MIN_VALUE;
			
			for (String string : args) {
				Integer val = Integer.valueOf(string);
				
				if (val > largest) {
					largest = val;
				}
			}
			
			answer = largest.toString();
		} else if (question.contains("which of the following numbers is both a square and a cube: ")) {
			// which of the following numbers is both a square and a cube: 1849, 46, 46656, 198

			String math = question.replace("which of the following numbers is both a square and a cube: ", "");
			String[] args = math.split(", ");
			StringBuilder results = new StringBuilder();
			for (String string : args) {
				Integer val = Integer.valueOf(string);
				if (isValidNumber(Math.pow(val, 1.0/2)) && 
						isValidNumber(Math.pow(val, 1.0/3))) {
			
					if (results.toString().length()> 0) {
						results.append(", ");
					}
					results.append(string);
					}
			}
			answer = results.toString();

		} else if (question.contains("what is ")) {
			// what is 19 plus 16
			String math = question.replace("what is ", "");
			Operation operation = detectOperation(math);
			String[] args;
			
			switch (operation) {
			case Plus:
				args = getArgs(math, plus);
				result = Integer.valueOf(args[0]) + Integer.valueOf(args[1]);
				answer = result.toString();
				break;		
			case Minus:
				args = getArgs(math, minus);
				result = Integer.valueOf(args[0]) - Integer.valueOf(args[1]);
				answer = result.toString();
				break;		
			case Multiply:
				args = getArgs(math, multi);
				result = Integer.valueOf(args[0]) * Integer.valueOf(args[1]);
				answer = result.toString();
				break;
			default:
				answer = "";
			}
				
		
		} else if (question.contains("what colour is a banana")) {
			answer = "yellow";
		} else if (question.contains("which city is the Naesinneula in")) {
			answer = "Tampere";
		} else if (question.contains("onko hauki kala")) {
			answer = "on";
		} else if (question.contains("where do you work")) {
			answer = "Houston Inc.";
		} else if (question.contains("who is your BOSS")) {
			answer = "Tomi Ruotimo";
		} else if (question.contains(" number in the Fibonacci sequence")) {
			//what is the 5th number in the Fibonacci sequence
			Integer sequence = Integer.parseInt(question);
			System.out.println("sequence: " + sequence);
			answer = fib(sequence).toString();
			//answer = "5";
		}
		
		if ("".equals(answer)) {
			answer = "None";
		}
		System.out.println(answer.toString());
		return answer;
	}

	private Integer fib(Integer sequence) {
		if (sequence < 2) {
			return sequence;
		} else{
			return fib(sequence-1) + fib(sequence-2);
		}
}
	private boolean isValidNumber(Double doubleValue) {
		Integer intValue = doubleValue.intValue();
		if (doubleValue.equals(intValue)) {
			return true;
		}
		return false;
	}
	private String[] getArgs(String math, String splitter) {
		return argParser(math, splitter);
	}
	
	private Operation detectOperation(String math) {
		Operation operation = Operation.Unknown;

		
		if (math.contains(plus)) {
			operation = Operation.Plus;
		
		} else if (math.contains(multi)) {
				operation = Operation.Multiply;

		} else if (math.contains(minus)) {
			operation = Operation.Minus;

	}
		
		return operation;
	}
	private String[] argParser(String math, String string) {	
		return math.split(string);
	}
	
	private String trial() {
		return "TeeJii";
	}
	
	private String temp1() {
		String foo = new String();
		foo = "";
		return foo;
	}
	
	private String temp2() {
		String foo = new String();
		foo = "";
		return foo;
	}
}
