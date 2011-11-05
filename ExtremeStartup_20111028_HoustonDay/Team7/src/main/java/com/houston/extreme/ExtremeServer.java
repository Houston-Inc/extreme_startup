package com.houston.extreme;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// http://10.200.43.255:8080/extreme/
@Controller
public class ExtremeServer {
    public static String Q2 = "which of the following numbers is the largest: ";
    public static String Q3 = "which of the following numbers is both a square and a cube: ";
    public static String Q4 = "which of the following numbers are primes: ";
    public static String Q5 = "what is the 10th number in the Fibonacci sequence";
    public static String Q6 = "which of the following numbers are primes: ";

    // http://localhost:8080/extreme/?q=LOL
    @RequestMapping("/")
    public
    @ResponseBody
    String get(@RequestParam String q) {
        System.out.println(q);
        q = q.substring(10);
        //System.out.println(q);

        if (q.startsWith("what is ")) {
            if (q.indexOf(" multiplied by ") > -1) {
                String[] tokens = q.split(" ");
                Integer result = Integer.parseInt(tokens[2]) * Integer.parseInt(tokens[5]);
                System.out.println(result);
                return result.toString();
            } else if (q.indexOf("Fibonacci") > -1) {
                String[] tokens = q.split(" ");
                String number = tokens[3].substring(0, tokens[3].length() - 2);
                long result = fib(Integer.parseInt(number));
                System.out.println(result);
                return "" + result;
            } else if (q.indexOf("minus") > -1) {
                String[] tokens = q.split(" ");
                Integer result = (Integer.parseInt(tokens[2]) - Integer.parseInt(tokens[4]));
                System.out.println(result);
                return "" + result;
            } else if (q.indexOf("power") > -1) {
                String[] tokens = q.split(" ");
                Double result = Math.pow(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[7]));
                System.out.println(result);
                return "" + result;
            } else {
                String[] tokens = q.split(" ");
                Integer result = (Integer.parseInt(tokens[2]) + Integer.parseInt(tokens[4]));
                System.out.println(result);
                return "" + result;
            }
        } else if (q.startsWith(Q2)) {

            String nums = q.substring(Q2.length());
            String[] n2 = nums.split(", ");
            Integer max = -1;
            for (int j = 0; j < n2.length; j++) {
                Integer i = Integer.parseInt(n2[j]);
                if (i > max) max = i;
            }
            System.out.println(max);
            return "" + max;
        } else if (q.startsWith(Q3)) {
            // which of the following numbers is both a square and a cube:  541, 961
            String nums = q.substring(Q3.length());
            String[] n2 = nums.split(", ");
            for (String n : n2) {
                Integer number = Integer.parseInt(n);

                //System.out.println(number + " "+ Math.sqrt(number)+ " " + Math.cbrt(number));
                //System.out.println(Math.sqrt(number) % 0);
                Double sq = Math.sqrt(number);
                Double cb = Math.cbrt(number);
                boolean isSquare = (sq.intValue() * sq.intValue()) == number;
                boolean isCube = (cb.intValue() * cb.intValue() * cb.intValue()) == number;
                if (isSquare && isCube) {
                    return number.toString();
                }
            }
            return "";


        } else if (q.startsWith(Q4)) {
            // which of the following numbers are primes: 263, 61, 608, 277
            String nums = q.substring(Q4.length());
            String[] n2 = nums.split(", ");

            List<Integer> list = new ArrayList<Integer>();
            for (String n : n2) {
                Integer number = Integer.parseInt(n);
                System.out.println(number + " " + isPrime(number));
                if (isPrime(number)) {
                    list.add(number);
                }
            }
            String result = "";
            for (Integer a : list) {
                result += a.toString() + ",";
            }
            if (result.length() > 0) 
            result = result.substring(0, result.length()-1);
            return result;
        }
        else if (q.startsWith(Q5)) {

        }
        else if (q.startsWith("where do you work")) {
            return "Houston Inc.";
        }
        else if (q.startsWith("who is your BOSS")) {
            return "Tomi Ruotimo";
        } else if (q.startsWith("who played James Bond in the film Dr No")) {
            return "Sean Connery";
        }


        System.out.println("ei toteutettu");
        return "";
    }

    boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

public static long fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }

}
