package com.ftn.CAFOOD.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	@GetMapping(value = {"/get" , "/getara"})
	public static String getFood() {
		return "FOOD";
	}
}
