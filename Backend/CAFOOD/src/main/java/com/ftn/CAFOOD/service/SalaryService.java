package com.ftn.CAFOOD.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.CAFOOD.dto.SalaryDTO;
import com.ftn.CAFOOD.model.MyUser;
import com.ftn.CAFOOD.model.Salary;
import com.ftn.CAFOOD.repository.SalaryRepository;

@Service
public class SalaryService {

	@Autowired
	SalaryRepository sr;
	
	@Autowired
	MyUserService mus;
	
	public Salary saveSalary(Long sd) {
//		System.out.println("SERVICE");
		Salary s = sr.save(new Salary(sd , new Date(),true));
//		System.out.println("SERVICE22");
		return s;
	}

//	public Salary findOneByUsername(String username) {
//		List<Salary> sal = sr.findAllByUsername(username);
//		
//		return sal.get(0);
//	}
	public Salary findByID(Long id) {
		Salary sal = sr.findById(id).orElse(null);
		
		return sal;
	}


	
}
