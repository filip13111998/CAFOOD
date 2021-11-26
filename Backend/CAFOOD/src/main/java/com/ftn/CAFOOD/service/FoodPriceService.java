package com.ftn.CAFOOD.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.CAFOOD.model.FoodPrice;
import com.ftn.CAFOOD.model.Salary;
import com.ftn.CAFOOD.repository.FoodPriceRepository;
@Service
public class FoodPriceService {

	@Autowired
	FoodPriceRepository fpr;
	
	public FoodPrice saveFoodPrice(Long foodPrice) {
	
		FoodPrice fp = fpr.save(new FoodPrice(foodPrice , new Date(),true));
		return fp;
		
	}

}
