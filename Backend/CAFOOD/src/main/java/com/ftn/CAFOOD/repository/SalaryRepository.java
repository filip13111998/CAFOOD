package com.ftn.CAFOOD.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ftn.CAFOOD.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary,Long>{
//	@Query("FROM Salary WHERE active = true")
//	Salary findOneByActive();
//	@Modifying   
//	@Query("FROM Salary WHERE username = ?1  ORDER BY salary_date_of_created ASC")
//	public List<Salary> findAllByUsername(String username);
	
//	@Query("FROM Salary ORDER BY salary_date_of_created ASC")
//	public Salary findOneByUsername(Pageable limit);
	
}
