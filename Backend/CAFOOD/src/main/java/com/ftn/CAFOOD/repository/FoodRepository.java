package com.ftn.CAFOOD.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.CAFOOD.model.Food;
import com.ftn.CAFOOD.model.MyUser;

public interface FoodRepository extends JpaRepository<Food,Long>{
	@Transactional 
	@Query("SELECT f FROM Food f WHERE f.name = ?1")
	Food findOneByName(String foodName);
	
	@Transactional 
	@Query("SELECT f FROM Food f WHERE f.delete = 'true'")
	Page<Food> findAll(Pageable pageable);
}
