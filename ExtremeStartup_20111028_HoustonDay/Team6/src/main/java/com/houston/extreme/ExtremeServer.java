package com.houston.extreme;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class ExtremeServer {
    /*
        add(q, new Answer() {
            @Override
            public String run(Object... args) {
                Long first = get(new Long(1), 0, args);

                return null;
            }
        });
        */

	private static interface Answer {
        public String run(String... args);
    }

    private Map<String, Answer> answers = new HashMap<String, Answer> (){{
        put("what is your name", new Answer() {
            @Override
            public String run(String... args) {
                return "KiMi";
            }
        });

        put("which of the following numbers is the largest", new Answer() {
            @Override
            public String run(String... args) {
                List<String> arguments = new ArrayList<String>();

                for (String arg : args) {
                    arguments.add(arg.trim());
                }

                if(args.length == 2){

                    Integer first = Integer.parseInt(arguments.get(0));
                    Integer sec = Integer.parseInt(arguments.get(1));

                    return first > sec ? ""+first : ""+sec;
                } else {
                    Set<Integer> values = new TreeSet<Integer>(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o2.compareTo(o1);
                        }
                    });

                    for (String arg : arguments) {
                        Integer value = Integer.parseInt(arg);
                        values.add(value);
                    }

                    return ""+values.iterator().next();
                }
            }
        });

        put("where do you work", new Answer() {
            @Override
            public String run(String... args) {
                return "Houston Inc.";
            }
        });

        put("what colour is a banana", new Answer() {
            @Override
            public String run(String... args) {
                return "yellow";
            }
        });

        put("who is your BOSS", new Answer() {
            @Override
            public String run(String... args) {
                return "Tomi Ruotimo";
            }
        });

        put("which city is the Naesinneula in", new Answer() {
            @Override
            public String run(String... args) {
                return "Tampere";
            }
        });

        put("who played James Bond in the film Dr No", new Answer() {
            @Override
            public String run(String... args) {
                return "Sean Connery";
            }
        });

        put("which of the following numbers is both a square and a cube", new Answer() {
            @Override
            public String run(String... args) {
                List<String> arguments = new ArrayList<String>();

                for (String arg : args) {
                    arguments.add(arg.trim());
                }

                List<Integer> ints = new ArrayList<Integer>();

                 for (String arg : arguments) {
                        Integer value = Integer.parseInt(arg);
                        ints.add(value);
                    }

                System.out.println("square+cube:"+ints);

                for (Integer integer : ints) {
                    Double d = Math.sqrt(integer);

                    try {
                        Integer a = Integer.valueOf(d.toString());
                    } catch (NumberFormatException nfe){
                        continue;
                    }

                    return ""+d;
                }


                return "foobar";
            }
        });

        put("which of the following numbers are primes", new Answer() {
            @Override
            public String run(String... args) {
                List<String> arguments = new ArrayList<String>();

                for (String arg : args) {
                    arguments.add(arg.trim());
                }



                List<Long> longs = new ArrayList<Long>();

                for (String arg : arguments) {
                        Long value = Long.parseLong(arg);
                        longs.add(value);
                    }

                System.out.println("primes:"+longs);


                StringBuilder sb = new StringBuilder();
                int i = 0;

                for (Long l : longs) {


                    if(isPrime(l)){
                        if(i > 0){
                        sb.append(", ");

                    }

                        i++;
                        sb.append(l);
                    }
                }


                return sb.toString();
            }
        });

        put("onko hauki kala", new Answer() {
            @Override
            public String run(String... args) {
                return "on";
            }
        });

        put("what is the 9th number in the Fibonacci sequence", new Answer() {
            @Override
            public String run(String... args) {
                return "34";
            }
        });
    }};

    public boolean isPrime(long n) {
		boolean prime = true;
		for (long i = 3; i <= Math.sqrt(n); i += 2)
			if (n % i == 0) {
				prime = false;
				break;
			}
		if (( n%2 !=0 && prime && n > 2) || n == 2) {
			return true;
		} else {
			return false;
		}
	}

    //what is 0 plus 14

	// http://localhost:8080/extreme/?q=LOL
	@RequestMapping("/")
	public @ResponseBody String get(@RequestParam String q) {
        System.out.println("--------\n string: "+q+"\n-------");

        return parseQuestions(q);
	}

    private String parseQuestions(String question){
         List<String> strings = Arrays.asList(question.split(":"));

        String nameOfTheQuestion = strings.get(1).trim();

        if(answers.containsKey(nameOfTheQuestion)){
            String answer;

            if(strings.size() == 3){
                answer = answers.get(nameOfTheQuestion).run(strings.get(2).trim().split(","));
            } else {
                answer = answers.get(nameOfTheQuestion).run("foo");
            }

            System.out.println("--------\n Q: "+nameOfTheQuestion+" A: "+answer+"\n-------");


            return answer;
        }

        for (Validate validate : list) {
            String answer = validate.check(nameOfTheQuestion);

            System.out.println("--------\n Q: "+nameOfTheQuestion+" A: "+answer+"\n-------");

            if(answer != null){
                return answer;
            }
        }

        System.out.println("--------\n Q: "+question+" A: "+null+"\n-------");

        return "foobar";
    }

    //what is the 9th number in the Fibonacci sequence
    private List<Validate> list = new ArrayList<Validate>(){{
        add(new Validate() {
            @Override
            public String check(String arg) {

                List<String> args = new ArrayList<String>(Arrays.asList(arg.trim().split(" ")));
                //what is X plus Y
                if(args.size() == 5 && args.get(3).equals("plus")){
                    Integer first = Integer.parseInt(args.get(2));
                    Integer second = Integer.parseInt(args.get(4));

                    return  ""+(first+second);

                }

                // what is 12 multiplied by 8
                if(args.size() == 6){
                    Integer first = Integer.parseInt(args.get(2));
                    Integer second = Integer.parseInt(args.get(5));

                    return ""+(first * second);

                }

                //what is the 6th number in the Fibonacci sequence
                if(args.size() == 9 && args.get(7).equals("Fibonacci")){
                    String ar = args.get(3);

                    int xx = 0;

                    for(int x = 0; x < ar.length(); ++x){
                        try {
                            Integer foo = Integer.parseInt(""+ar.charAt(x));
                        } catch (NumberFormatException nfe){
                            continue;
                        }

                        xx++;
                    }


                    Integer i = Integer.parseInt("" + args.get(3).substring(0, xx));

                    return ""+fibonacci(i);


                }

                //what is 1 to the power of 18
                if(args.size() == 8 && args.get(5).equals("power")){
                    Long first = Long.parseLong(args.get(2));
                    Long second = Long.parseLong(args.get(7));

                    Long answer = first;

                    System.out.println("power:"+first+","+second);
                    for(int x = 1; x < second; ++x){
                        answer *= answer;
                    }

                    return ""+answer;
                }

                //what is 18 plus 9 plus 0
                if(args.size() == 7 && args.get(5).equals("plus")){
                    Integer first = Integer.parseInt(args.get(2));
                    Integer second = Integer.parseInt(args.get(4));
                    Integer third = Integer.parseInt(args.get(6));

                    return ""+(first+second+third);
                }

                //what is 10 plus 15 multiplied by 0
                if(args.size() == 8 && args.get(5).equals("multiplied")){
                    Integer first = Integer.parseInt(args.get(2));
                    Integer second = Integer.parseInt(args.get(4));
                    Integer third = Integer.parseInt(args.get(7));

                    return ""+(first+second*third);

                }

                //what is 3 minus 18
                if(args.size() == 5 && args.get(3).equals("minus")){
                    Integer first = Integer.parseInt(args.get(2));
                    Integer second = Integer.parseInt(args.get(4));


                    return ""+(first-second);
                }

                // what is 7 multiplied by 6 plus 13 A
                if(args.size() == 8 && args.get(3).equals("multiplied") && args.get(6).equals("plus") ){
                    Integer first = Integer.parseInt(args.get(2));
                    Integer second = Integer.parseInt(args.get(5));
                    Integer third = Integer.parseInt(args.get(7));

                    return ""+((first*second)+third);

                }

                return null;
            }
        });
    }};

    public int fibonacci(int n){
        int a=0,b=1;
        int v = 0;
        int y = 0;


        for (int i=0;i<n;i++){
            y = v;
            v = b + a;
            b = v;
            a = y;
        }

        return v;
    }

    private static interface Validate {
        public String check(String arg);
    }

}
