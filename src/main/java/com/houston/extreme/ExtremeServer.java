package com.houston.extreme;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExtremeServer {

	@RequestMapping("/")
	public @ResponseBody String get(@RequestParam String q) {
		throw new IllegalArgumentException("Not implemented!");
	}
}
