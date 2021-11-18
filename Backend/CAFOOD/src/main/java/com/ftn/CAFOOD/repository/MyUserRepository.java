package com.ftn.CAFOOD.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.CAFOOD.model.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser,Long>{
	@Transactional 
	@Query("SELECT u FROM MyUser u WHERE u.delete = 'true' AND u.role <> 'ADMIN'")
	Page<MyUser> findAll(Pageable pageable);
	
}
