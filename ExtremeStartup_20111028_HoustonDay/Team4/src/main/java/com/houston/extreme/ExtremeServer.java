package com.houston.extreme;

import java.math.BigInteger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExtremeServer {
	
	// http://localhost:8080/extreme/?q=LOL
	@RequestMapping("/")
	public @ResponseBody String get(@RequestParam String q) {
		System.out.println(q);
		String answer =  paramSplitter(q);
		System.out.println("-->" + answer);
		return answer;
	}
	
	protected String paramSplitter(String qq) {
		try {
			String q = qq.substring(qq.indexOf(":") +1 ).trim();
			System.out.println("q String " + q);
			
			if( q.contains("which of the following numbers is the largest")) {
				String[] heips = q.split(", ");
				String eka = heips[0].substring(heips[0].lastIndexOf(":") + 1).trim();
				Integer ekaNro = Integer.parseInt(eka.trim());
				for(int i = 1 ; i < heips.length ; i++) {
					if(ekaNro < Integer.parseInt(heips[i].trim())) {
						ekaNro =  Integer.parseInt(heips[i].trim());
					} 
				}
				return String.valueOf(ekaNro);
			}  
			else if (q.contains("what is") && q.contains("plus") && !q.contains("multi")) {
				String x = q.substring(q.indexOf("is")+2);
				System.out.println("x: "+x);
				String[] numbers = x.split(" plus ");
				int answer = 0;
				for(String n : numbers) {
					answer += Integer.parseInt(n.trim());
				}
				return String.valueOf(answer);
			}
			
			else if (q.contains("what is") && q.contains("minus")) {
				String x = q.substring(q.indexOf("is")+2);
				System.out.println("x: "+x);
				String[] numbers = x.split(" minus ");
				int answer = Integer.parseInt(numbers[0].trim()) - Integer.parseInt(numbers[1].trim());
				return String.valueOf(answer);
			}
			
			else if(q.contains("what is") && q.contains("multi") && !q.contains("plus")){
				String x = q.substring(q.indexOf("is")+2);
				System.out.println("x: "+x);
				String[] numbers = x.split(" multiplied by ");
				int answer = Integer.parseInt(numbers[0].trim()) * Integer.parseInt(numbers[1].trim());
				return String.valueOf(answer);
			}
			
			else if(q.contains("which of the following numbers is both a square and a cube:")){
				String x = q.replace("which of the following numbers is both a square and a cube: ", "");
				System.out.println("x: "+x);
				String[] numbers = x.split(", ");
				for(String n : numbers) {
					double cc =  Double.parseDouble(numbers[0].trim());
					if((Math.floor(Math.sqrt(cc)) == Math.sqrt(cc)) && 
							(Math.floor(Math.cbrt(cc)) == Math.cbrt(cc)))  {
						System.out.println("JEEEEE " + cc);
						return String.valueOf((int)cc);
					}
				}
				return "";
			}
			
			else if(q.contains("which of the following numbers are primes:")){
				String x = q.replace("which of the following numbers are primes: ", "");
				System.out.println("x: "+x);
				String[] numbers = x.split(", ");
				String retval = "";
				for(String n : numbers) {
					int cc =  Integer.parseInt(n.trim());
					BigInteger bi = BigInteger.valueOf(cc);
					
					if(bi.isProbablePrime(10)){
						if(!retval.equals("")){
							retval += ", ";
						}
						retval += bi.toString();
					}
					
				}
				return retval;
			}
			
			else if(q.contains("where do you work")){
				return "Houston Inc.";
			}
			else if(q.contains("which city is the Naesinneula in")){
				return "Tampere";
			}
			else if(q.contains("who played James Bond in the film Dr No")){
				return "Sean Connery";
			}
			else if(q.contains("who is your BOSS")){
				return "Tomi Ruotimo";
			}
			
			else if(q.contains("Fibonacci")){
				String x = q.replace("what is the ", "");
				x = x.replace("th", "");
				x = x.trim();
				String numb = x.split(" ")[0];
				System.out.println("number: "+numb);
				long nro = Long.parseLong(numb);
				
				long prev1 =0;
				long prev2 =1;
				
				for(long i=0; i<nro; i++){
					long savePrev1 = prev1;
					prev1 = prev2;
					prev2 = savePrev1 + prev2;
				}
				
				return String.valueOf(prev1);
			}
			
			else if(q.contains("what colour is a banana")) {
				return "Yellow";
			}
			
			else if(q.contains( "to the power of")) {
				String x = q.replace("what is ", "").trim().replace("to the power of ", "").trim();
				System.out.println(x);
				String[] vv = x.split(" ");
				double base = Double.parseDouble(vv[0].trim());
				double power = Double.parseDouble(vv[1].trim());
				
				return String.valueOf((int) Math.pow(base, power));
			}
			
			else if(q.contains("plus") && q.contains("multiplied")) {
				String x = q.replace("what is ", "").trim();
				String eka = x.substring(0, x.indexOf(" "));
				String toka = x.substring(x.indexOf(" ", x.indexOf("plus")), x.indexOf(" ", x.indexOf("plus") + 1)).trim();
				String vika = x.substring(x.lastIndexOf(" ")).trim();
				
				System.out.println(eka + " " + toka + " " + vika);
				String retval =  String.valueOf(Integer.parseInt(eka) + Integer.parseInt(toka) * Integer.parseInt(vika));
				System.out.println(" tulos " + retval);
				return retval;
			}
			
			else if( q.contains("onko hauki kala")) {
				return "on";
			}
			
			
		}catch (Exception e) {
			return "11";
		}
		
		return"********************************************";
	}
}
