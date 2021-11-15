package com.vinaemter.BAI1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@GetMapping("/hello")
	public String index(@RequestParam(value = "hello" , required = false) String name, Model model) {
		model.addAttribute("hello",name);
		return "index";
	}
}
