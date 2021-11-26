package com.ftn.CAFOOD.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.CAFOOD.model.DrinkPrice;
import com.ftn.CAFOOD.repository.DrinkPriceRepository;

@Service
public class DrinkPriceService {

	@Autowired
	DrinkPriceRepository dpr;
	
	public DrinkPrice saveDrinkPrice(Long foodPrice) {
	
		DrinkPrice dp = dpr.save(new DrinkPrice(foodPrice , new Date(),true));
		return dp;
		
	}
}
