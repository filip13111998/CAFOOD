package com.ftn.CAFOOD.service;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ftn.CAFOOD.dto.request.AddDrinkDTO;
import com.ftn.CAFOOD.dto.request.DeleteDrinkDTO;
import com.ftn.CAFOOD.dto.request.EditMenuDrinkDTO;
import com.ftn.CAFOOD.dto.request.UpdateDrinkDTO;
import com.ftn.CAFOOD.model.Drink;
import com.ftn.CAFOOD.model.DrinkPrice;
import com.ftn.CAFOOD.model.Food;
import com.ftn.CAFOOD.model.FoodPrice;
import com.ftn.CAFOOD.repository.DrinkPriceRepository;
import com.ftn.CAFOOD.repository.DrinkRepository;
import com.ftn.CAFOOD.repository.FoodPriceRepository;
import com.ftn.CAFOOD.repository.ImageRepository;

@Service
public class DrinkService {
	@Autowired
	DrinkRepository dr;
	
	@Autowired
	ImageService is;
	
	@Autowired
	DrinkPriceService dps;
	
	@Autowired
	DrinkPriceRepository dpr;

	public Boolean saveDrink(AddDrinkDTO addt, MultipartFile file) throws ParseException, IOException {
		is.save(file);

		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		
		Date d = (Date) sdf.parse(addt.getTimeOfPreparation());

		Drink drink = new Drink(addt.getName(),addt.getDescription(),d ,addt.isInMenu(),true
				,is.findByName(file.getOriginalFilename()));
		
		DrinkPrice dp = dps.saveDrinkPrice(addt.getFoodPrice());

		drink.getPricesHistory().add(dp);
		
		dr.save(drink);
		
		return true;
	}

	public Page<Drink> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return dr.findAll(pageable);
	}

	public Boolean updateDrink(UpdateDrinkDTO udd) throws ParseException {
		Drink d = dr.findOneByName(udd.getName());
		if(!udd.getDescription().equals("null")) {
			d.setDescription(udd.getDescription());
		}
		
		if(!udd.getTimeOfPreparation().equals("null")) {
			SimpleDateFormat sdf = new SimpleDateFormat("mm");
			Date date = (Date) sdf.parse(udd.getTimeOfPreparation());
			d.setTimeOfPreparation(date);
		}
		
	
		if(!udd.getFoodPrice().equals("null")) {
			DrinkPrice dp = d.getPricesHistory().stream().filter(x -> x.getActive() == true).findFirst().orElse(null);
			dp.setActive(false);
			dpr.save(dp);
			DrinkPrice drinkPrice = dps.saveDrinkPrice(udd.getFoodPrice());
			d.getPricesHistory().add(drinkPrice);
			
		}
		dr.save(d);
		return true;
	}

	public Boolean deleteDrink(DeleteDrinkDTO ddd) {
		Drink d = dr.findOneByName(ddd.getName() );
		d.setDeleted(false);
		dr.save(d);
		return true;
	}

	public Boolean addInMenu(EditMenuDrinkDTO emdd) {
		Drink d = dr.findOneByName(emdd.getName() );
		d.setInMenu(true);
		dr.save(d);
		return true;
	}

	public Boolean deleteInMenu(EditMenuDrinkDTO emdd) {
		Drink d = dr.findOneByName(emdd.getName() );
		d.setInMenu(false);
		dr.save(d);
		return true;
	}
}
