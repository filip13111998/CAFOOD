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

import com.ftn.CAFOOD.dto.request.DeleteFoodDTO;
import com.ftn.CAFOOD.dto.request.EditMenuFoodDTO;
import com.ftn.CAFOOD.dto.request.FoodDTO;
import com.ftn.CAFOOD.dto.request.UpdateFoodDTO;
import com.ftn.CAFOOD.model.Food;
import com.ftn.CAFOOD.model.FoodPrice;
import com.ftn.CAFOOD.model.MyUser;
import com.ftn.CAFOOD.model.Salary;
import com.ftn.CAFOOD.repository.FoodPriceRepository;
import com.ftn.CAFOOD.repository.FoodRepository;

@Service
public class FoodService {
	
	
	@Autowired
	FoodRepository fr;
	
	@Autowired 
	ImageService is;
	
	@Autowired
	FoodPriceRepository fpr;
	
	@Autowired
	FoodPriceService fpc;
	
	

	public Boolean saveFood(FoodDTO fd, MultipartFile file) throws ParseException, IOException {
		is.save(file);
		System.out.println("TU");
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		Date d = (Date) sdf.parse(fd.getTimeOfPreparation());
		Food f = new Food(fd.getName(),fd.getDescription() , fd.getFoodAllergens(),is.findByName(file.getOriginalFilename()),d
							,true,fd.isInMenu(),fd.getFood_type());
		
		FoodPrice fp = fpc.saveFoodPrice(fd.getPrice());

		f.getPricesHistory().add(fp);
		
		fr.save(f);
		
//		System.out.println("IZAOO0O");
		
		return true;
	}

	public Page<Food> findAll(Pageable pageable) {
		
		return fr.findAll(pageable);
	}

	public Boolean updateFood(UpdateFoodDTO ufd) throws ParseException {
		Food f = fr.findOneByName(ufd.getName());
		if(!ufd.getDescription().equals("null")) {
			f.setDescription(ufd.getDescription());
		}
		if(!ufd.getFoodAllergens().isEmpty()) {
			f.setFoodAllergens(ufd.getFoodAllergens());
		}
		
		if(!ufd.getTimeOfPreparation().equals("null")) {
			SimpleDateFormat sdf = new SimpleDateFormat("mm");
			Date d = (Date) sdf.parse(ufd.getTimeOfPreparation());
			f.setTimeOfPreparation(d);
		}
		
	
		if(!ufd.getFoodPrice().equals("null")) {
			FoodPrice fp = f.getPricesHistory().stream().filter(d -> d.isActive() == true).findFirst().orElse(null);
			fp.setActive(false);
			fpr.save(fp);
			FoodPrice foodPrice = fpc.saveFoodPrice(ufd.getFoodPrice());
			f.getPricesHistory().add(foodPrice);
			
		}
		fr.save(f);
		return true;
	}

	public Boolean deleteFood(DeleteFoodDTO dfd) {
		Food f = fr.findOneByName(dfd.getName());
		f.setDelete(false);
		fr.save(f);
		return true;
	}
	
	public Boolean addInMenu(EditMenuFoodDTO efd) {
		Food f = fr.findOneByName(efd.getName());
		f.setInMenu(true);
		fr.save(f);
		return true;
	}
	
	public Boolean DeleteInMenu(EditMenuFoodDTO efd) {
		Food f = fr.findOneByName(efd.getName());
		f.setInMenu(false);
		fr.save(f);
		return true;
	}
}
