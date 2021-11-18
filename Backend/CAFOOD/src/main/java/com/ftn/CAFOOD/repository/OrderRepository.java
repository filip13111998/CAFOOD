package com.ftn.CAFOOD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.CAFOOD.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
