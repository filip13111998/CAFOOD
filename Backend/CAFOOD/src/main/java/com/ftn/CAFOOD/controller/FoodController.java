package com.ftn.CAFOOD.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ftn.CAFOOD.dto.request.DeleteFoodDTO;
import com.ftn.CAFOOD.dto.request.EditMenuFoodDTO;
import com.ftn.CAFOOD.dto.request.FoodDTO;
import com.ftn.CAFOOD.dto.request.UpdateFoodDTO;
import com.ftn.CAFOOD.model.Food;
import com.ftn.CAFOOD.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	FoodService fs;
	
	@GetMapping(value = {"/get" , "/getara"})
	public static String getFood() {
		return "FOOD";
	}
	
	//@RequestParam(required =  true,value = "imageFile") MultipartFile file,
	@PostMapping(value = "/saveFood",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Boolean> saveSalary(@RequestPart("file") MultipartFile file , @RequestPart("fd") FoodDTO fd  ) throws IOException, ParseException{

		Boolean b = fs.saveFood(fd, file);
		
		return new ResponseEntity<Boolean>(b,HttpStatus.OK);
		
	} 
	
	
	@GetMapping(value="/getFoods")
    public ResponseEntity<Page<Food>> findAll(Pageable pageable) {

        Page<Food> foods = fs.findAll(pageable);

        System.out.println("NEGDE OVDE" + foods.getNumberOfElements());
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

	@PutMapping(value="/updateFood")
    public ResponseEntity<Boolean> updateUser(@RequestBody UpdateFoodDTO ufd) throws ParseException {

        Boolean b = fs.updateFood(ufd);

        return new ResponseEntity<>(b, HttpStatus.OK);
    }
	
	
	@DeleteMapping(value="/deleteFood")
    public ResponseEntity<Boolean> deleteFood(@RequestBody DeleteFoodDTO dfd) {

		Boolean b = fs.deleteFood(dfd);

        return new ResponseEntity<>(b, HttpStatus.OK);
    }
	
	@PutMapping(value="/addInMenuFood")
    public ResponseEntity<Boolean> addMenuFood(@RequestBody EditMenuFoodDTO emfd) {

		Boolean b = fs.addInMenu(emfd);

        return new ResponseEntity<>(b, HttpStatus.OK);
    }
	
	@DeleteMapping(value="/deleteInMenuFood")
    public ResponseEntity<Boolean> deleteMenuFood(@RequestBody EditMenuFoodDTO emfd) {

		Boolean b = fs.DeleteInMenu(emfd);

        return new ResponseEntity<>(b, HttpStatus.OK);
    }
	
}
