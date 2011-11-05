package com.houston.extreme;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExtremeServer {
	
	// http://localhost:8080/extreme/?q=LOL
	@RequestMapping("/extreme")
	public @ResponseBody String get(@RequestParam String q) {
		/*System.out.println(""+q);
		System.out.println(q.substring(8));
		String a = "";
		if (q.indexOf(":") > 0) {
			q = q.substring(q.indexOf(":")+2).trim();
		}*/
		
		String id = "";
		if (q.indexOf(":") > 0) {
			id = q.substring(0, q.indexOf(":"));
			q = q.substring(q.indexOf(":")+2).trim();
		}
		
		
		String a = "";
		
		if (q.equals("what is your name")) {
			a = "buddhateam";
		} else if (q.indexOf("which of the following numbers is the largest:") == 0) {
			String temp = q.substring(q.indexOf("which of the following numbers is the largest:") + "which of the following numbers is the largest:".length());
			String[] t = temp.split(",");
			int largest = -1;
			for (String n : t) {
				int i = new Integer(n.trim()).intValue();
				if (i > largest) {
					largest = i;
				}				
			}
			a = largest+ "";
		} else if (q.indexOf("what is ") == 0 && q.indexOf(" plus ") > 0 && (q.indexOf(" multiplied by ") > q.indexOf(" plus "))) { 
			String firstPart = q.substring(q.indexOf("what is ") + "what is ".length());
			firstPart = firstPart.substring(0, firstPart.indexOf(" plus "));
			String secondPart = q.substring(q.indexOf(" plus ") + " plus ".length());
			String thirdPart = secondPart.substring(0, secondPart.indexOf(" multiplied by "));
			secondPart = secondPart.substring(0, secondPart.indexOf(" multiplied by "));
			
			int first = 0;
			int second = 0;
			int third = 0;
			
			first = new Integer(firstPart.trim()).intValue();
			second = new Integer(secondPart.trim()).intValue();
			third = new Integer(thirdPart.trim()).intValue();
			
			int answer = first;
			answer += second;
			answer = answer * third;
			
			a = answer +"";
		} else if (q.indexOf("what is ") == 0 && q.indexOf(" plus ") > 0 && (q.lastIndexOf(" plus ") != q.indexOf(" plus "))) { 
			String firstPart = q.substring(q.indexOf("what is ") + "what is ".length());
			firstPart = firstPart.substring(0, firstPart.indexOf(" plus "));
			String secondPart = q.substring(q.indexOf(" plus ") + " plus ".length());
			String thirdPart = secondPart.substring(0, secondPart.indexOf(" plus "));
			secondPart = secondPart.substring(0, secondPart.indexOf(" plus "));
			
			int first = 0;
			int second = 0;
			int third = 0;
			
			System.out.println(q + " : " + firstPart + " + " + secondPart + " + " + thirdPart);
			
			first = new Integer(firstPart.trim()).intValue();
			second = new Integer(secondPart.trim()).intValue();
			third = new Integer(thirdPart.trim()).intValue();
			
			int answer = first;
			answer += second;
			answer += third;
			
			
			
			a = answer +"";

		} else if (q.indexOf("what is ") == 0 && q.indexOf(" plus ") > 0) { 
try {			
			String firstPart = q.substring(q.indexOf("what is ") + "what is ".length());
			firstPart = firstPart.substring(0, firstPart.indexOf(" plus "));
			String secondPart = q.substring(q.indexOf(" plus ") + " plus ".length());
			
			int first = 0;
			int second = 0;
			first = new Integer(firstPart.trim()).intValue();
			second = new Integer(secondPart.trim()).intValue();
			
			a = first + second + "";
} catch (Exception e) {
	
	
	
	System.out.println(e);
	System.out.println(q);
}
		} else if (q.indexOf("what is ") == 0 && q.indexOf(" minus ") > 0) { 
			String firstPart = q.substring(q.indexOf("what is ") + "what is ".length());
			firstPart = firstPart.substring(0, firstPart.indexOf(" minus "));
			String secondPart = q.substring(q.indexOf(" minus ") + " minus ".length());
			
			int first = 0;
			int second = 0;
			first = new Integer(firstPart.trim()).intValue();
			second = new Integer(secondPart.trim()).intValue();
			
			a = first - second + "";
		} else if (q.indexOf("what is ") == 0 && q.indexOf(" multiplied by ") > 0) {
			String firstPart = q.substring(q.indexOf("what is ") + "what is ".length());
			firstPart = firstPart.substring(0, firstPart.indexOf(" multiplied by "));
			String secondPart = q.substring(q.indexOf(" multiplied by ") + 
					" multiplied by ".length());
			
			int first = 0;
			int second = 0;
			first = new Integer(firstPart.trim()).intValue();
			second = new Integer(secondPart.trim()).intValue();
			
			a = first * second + "";			
		} else if (q.indexOf("which of the following numbers is both a square and a cube:") == 0) {
			String temp = q.substring(q.indexOf("which of the following numbers is both a square and a cube:") + "which of the following numbers is both a square and a cube:".length());
			String[] t = temp.split(",");
			for (String n : t) {
				int i = new Integer(n.trim()).intValue();
				
				int square = (int)Math.sqrt(i);
				int cube = (int)Math.pow(i, 1.0/3);
				
				
				
System.out.println(i + " sq: " + square + " cube: " + cube + " sq * sq: " + (square * square) + " cube * cube * cube: " + (cube * cube * cube));				
				
				if (i == square * square) {
					if (i == cube * cube * cube) {
						a = i + "";
					}
				}
			}
		}
		else if (q.indexOf("what colour is a banana") == 0) {
			a= "yellow";
			
		} else if (q.indexOf("where do you work") == 0) {
			a= "Houston Inc.";
			
		} else if (q.indexOf("what is ") == 0 && q.indexOf(" to the power of ") > 0) {
			String firstPart = q.substring(q.indexOf("what is ") + "what is ".length());
			firstPart = firstPart.substring(0, firstPart.indexOf(" to the power of "));
			String secondPart = q.substring(q.indexOf(" to the power of ") + " to the power of ".length());
			
			int first = 0;
			int second = 0;
			first = new Integer(firstPart.trim()).intValue();
			second = new Integer(secondPart.trim()).intValue();
			
			System.out.println("first: " + first + ", second: " + second);
			
			a = (int)Math.pow((double)first, (double)second) + "";
	
			
		}

		
		else if (q.indexOf("onko hauki kala") == 0) {
			a= "on";
		} else if (q.indexOf("which of the following numbers are primes:") == 0) {
			String temp = q.substring(q.indexOf("which of the following numbers are primes:") + "which of the following numbers are primes:".length());
			String[] t = temp.split(",");
			String results = "";
			for (String n : t) {
				boolean isPrime = true;
				int num = new Integer(n.trim()).intValue();		
			
				for (int i = 2; i < num ;i++ ) {
				  int nn = num % i;
				  if (nn==0) {
					  isPrime = false;
			  		  break;
				  }
				}
				if (isPrime) {
					if (results.length() > 0) { results += ", "; }  
					results = results + num;
				}
			}

			a= results;
		}			else if (q.indexOf("which city is the Naesinneula in") == 0) {
			a = "Tampere";
			
		}			else if (q.indexOf("who is your BOSS") == 0) {
			a= "Tomi Ruotimo";
			
			
		}			else if (q.indexOf("who played James Bond in the film Dr No") == 0) {
			a= "Sean Connery";
			
		} else if (q.indexOf("what is the ") == 0 && q.indexOf(" number in the Fibonacci sequence") > 0) {
			String temp = q.substring("what is the ".length());
			temp = temp.substring(0, temp.indexOf(" number in the Fibonacci sequence") - 2);
			System.out.println(temp);
			long target = new Long(temp.trim()).longValue();
			long prev = 1;
			long prevTwo = 1;
			
			if (target < 3) { return "1"; }
			
			long answer = 0;
			for (long i = 2; i < target; ++i) {
				long newFib = prev + prevTwo;
				answer = newFib;
				prevTwo = prev;
				prev = newFib;
			}
			a = "" + answer;
		}				
		
		
		

		
		
		System.out.println("q: " + q + ", a: " + a + ", id: " + id);
		return a;
	}
}
