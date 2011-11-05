package com.houston.extreme;

import java.util.HashMap;
import java.util.Map;

public class TextAnswer implements Answer {

	private Map<String, String> answers = new HashMap<String, String>();

	public TextAnswer() {

		answers.put("what is your name", "KustaaKassu");
		answers.put("which city is the Naesinneula in", "Tampere");
		answers.put("who is your BOSS", "Tomi Ruotimo");
		answers.put("who played James Bond in the film Dr No", "Sean Connery");
		answers.put("what colour is a banana", "yellow");
		answers.put("where do you work", "Houston Inc.");
	}

	@Override
	public boolean canAnswer(String question) {

		return answers.containsKey(question);
	}

	@Override
	public String answer(String question) {
		return answers.get(question);

	}

}
