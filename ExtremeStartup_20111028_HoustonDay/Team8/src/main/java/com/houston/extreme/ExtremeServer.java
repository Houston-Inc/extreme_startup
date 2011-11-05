package com.houston.extreme;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExtremeServer {

	List<Answer> answers = new ArrayList<Answer>();

	public ExtremeServer() {
		super();
		answers.add(new PlusAnswer());
		answers.add(new MinusAnswer());
		answers.add(new PowerAnswer());
		answers.add(new NumericAnswer());
		answers.add(new MultipliedAnswer());
		answers.add(new SquareCubeAnswer());
		answers.add(new PrimeAnswer());
		answers.add(new TextAnswer());
	}

	// http://localhost:8080/extreme/?q=LOL
	@RequestMapping("/")
	public @ResponseBody
	String get(@RequestParam String q) {
		System.out.println("==== QUESTION" + q);

		String trimmedQuestion = q.substring(q.indexOf(":") + 1, q.length());

		trimmedQuestion = trimmedQuestion.trim();
		System.out.println("TRIMMED QUESTION: " + trimmedQuestion);

		for (Answer a : answers) {
			if (a.canAnswer(trimmedQuestion)) {
				return a.answer(trimmedQuestion);
			}
		}

		System.out.println("==== CAN NOT ANSWER!!!: " + trimmedQuestion);

		return "KassuKustaa";
	}
}
