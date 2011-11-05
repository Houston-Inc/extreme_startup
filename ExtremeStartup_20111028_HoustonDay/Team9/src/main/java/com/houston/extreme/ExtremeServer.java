package com.houston.extreme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExtremeServer {

    /**
     * If you're reading this, you gotta be out of your mind
     * @param q
     * @return pelkkiä oikeita vastauksia
     */
    
    // http://localhost:8080/extreme/?q=LOL
    @RequestMapping("/")
    public @ResponseBody
    String get(@RequestParam String q) {

        System.out.println( q);
        if (q.contains("which of the following numbers is the largest")) {
            System.out.println("LOHKO: which of the following numbers is the largest");
            String[] numbers = q.split(":")[2].split(",");

            LinkedList<Integer> numbers2 = new LinkedList<Integer>();
            for (String s : Arrays.asList(numbers)) {
                numbers2.add(Integer.valueOf(s.trim()));
            }

            Collections.sort(numbers2);

            return "" + numbers2.getLast();
        } 
        else if (q.contains("plus") && q.contains("multiplied")){
            System.out.println("LOHKO: plus multiplied");

            
            String[] numbers = q.replaceAll(".*what is", "").split(" plus ");
            
            int num1 = Integer.valueOf(numbers[0].trim());
            int num2 = Integer.valueOf(numbers[1].split(" multiplied by ")[0].trim());
            int num3 = Integer.valueOf(numbers[1].split(" multiplied by ")[1].trim());

            
            
            int sum = (num3 * num2) + num1;
            System.out.println("LOHKO: plus multiplied vastaus " + sum);
            
            return "" + sum;
        }         
        else if (q.contains("plus")){
            System.out.println("LOHKO: plus");
            String[] numbers = q.replaceAll(".*what is", "").split(" plus ");
            int sum = Integer.valueOf(numbers[0].trim()) + Integer.valueOf(numbers[1].trim());
            
            return "" + sum;
        } else if (q.contains("multiplied")) {
            System.out.println("LOHKO: multiplied");
            String[] numbers = q.replaceAll(".*what is", "").split(" multiplied by ");
            int m = Integer.valueOf(numbers[0].trim()) * Integer.valueOf(numbers[1].trim());
            return "" + m;
        }
        else if (q.contains("square")) {
            System.out.println("LOHKO: square");
            String[] numbers = q.split(":")[2].split(",");

            LinkedList<Double> numbers2 = new LinkedList<Double>();
            for (String s : Arrays.asList(numbers)) {
                numbers2.add(Double.valueOf(s.trim()));
            }

            ArrayList<Double> matches = new ArrayList<Double>();
            
            ArrayList<Double> squares = new ArrayList<Double>();
            for (int sq = 1; sq < 100; sq++) {
                double square = Math.pow(sq, 2);
                squares.add(square);
            }
            
            ArrayList<Double> cubes = new ArrayList<Double>();
            for (int c = 1; c < 100; c++) {
                double cube = Math.pow(c, 3);
                cubes.add(cube);
            }
            
            for (Double i : numbers2) {
                if (squares.contains(i) && cubes.contains(i)) {
                    matches.add(i);
                }
            }
               
            if (matches.size() == 0) {
                return "";
            }

            return "" + matches.get(0).intValue();
            
        }
        else if (q.contains("which city is the Naesinneula in")) {
            return "Tampere";
        }
        else if (q.contains("where do you work")) {
            return "Houston Inc";
        }
        else if (q.contains("onko hauki kala")) {
            return "On";
        }
        else if (q.contains("who is your BOSS")) {
            return "Tomi Ruotimo";
        }
        else if (q.contains("who played James Bond in the film Dr No")) {
            return "Sean Connery";
        }
        
        else if (q.contains("minus")){
            System.out.println("LOHKO: minus");
            String[] numbers = q.replaceAll(".*what is", "").split(" minus ");
            int sum = Integer.valueOf(numbers[0].trim()) - Integer.valueOf(numbers[1].trim());
            
            return "" + sum;
        } 
        
        else if (q.contains("primes")){
            System.out.println("LOHKO: primes");
            String[] numbers = q.replaceAll(".*primes:", "").split(",");
            
            List<Integer> matches = new ArrayList<Integer>();
            for (String s : numbers) {
                Integer nro = Integer.valueOf(s.trim());
                if (nro.intValue()%2 == 0) {
                    continue;
                }
                boolean onko = true;
                for (int i = 3; i < nro.intValue(); i+=2) {
                    if (nro.intValue()%i == 0) {
                        onko = false;
                    }
                }
                if (onko) {
                    matches.add(nro);
                }
            }
            
            String r = "";
            Iterator<Integer> iter = matches.iterator();
            while (iter.hasNext()) {
                Integer i = iter.next();
                r += i.toString();
                if (iter.hasNext()) {
                    r += ", ";
                }
            }
            System.out.println("Prime vastaus: " + r);
            return r;
        } 
        
        else if (q.contains("Fibonacci")){
            System.out.println("LOHKO: Fibonacci");
//            String[] numbers = q.replaceAll(".*what is", "").split(" minus ");
//            int sum = Integer.valueOf(numbers[0].trim()) - Integer.valueOf(numbers[1].trim());

            return "";

        } 
        
        
        return "";
    }
}
