package com.ftn.CAFOOD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ftn.CAFOOD.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary,Long>{
	@Modifying   
	@Query("FROM Salary WHERE username = ?1  ORDER BY salary_date_of_created ASC")
	public List<Salary> findAllByUsername(String username);
	
}
