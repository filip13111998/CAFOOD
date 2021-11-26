package com.ftn.CAFOOD.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.CAFOOD.model.Drink;

public interface DrinkRepository extends JpaRepository<Drink,Long>{
	@Transactional 
	@Query("SELECT d FROM Drink d WHERE d.name = ?1")
	Drink findOneByName(String drinkName);
	
	@Transactional 
	@Query("SELECT d FROM Drink d WHERE d.deleted = 'true'")
	Page<Drink> findAll(Pageable pageable);
}
