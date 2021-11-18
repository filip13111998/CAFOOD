package com.ftn.CAFOOD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.CAFOOD.model.Food;

public interface FoodRepository extends JpaRepository<Food,Long>{

}
