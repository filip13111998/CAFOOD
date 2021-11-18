package com.ftn.CAFOOD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.CAFOOD.dto.SalaryDTO;
import com.ftn.CAFOOD.service.SalaryService;

@RestController
@RequestMapping(value = "admin")
public class SalaryController {
	
	@Autowired
	SalaryService ss;
	
	@PostMapping(value = "/saveSalary")
	public ResponseEntity<Boolean> saveSalary(@RequestBody SalaryDTO sd){
		
		Boolean b = true;
		
		return new ResponseEntity<Boolean>(b,HttpStatus.OK);
		
	} 
	
}
