package com.ftn.CAFOOD.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.CAFOOD.model.Image;

public interface ImageRepository extends JpaRepository<Image,Long> {
	@Transactional 
	@Query("FROM Image WHERE name = ?1")
	public Optional<Image> findOneByName(String myName);
}