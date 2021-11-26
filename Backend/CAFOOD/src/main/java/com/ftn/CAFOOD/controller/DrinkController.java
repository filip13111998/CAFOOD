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

import com.ftn.CAFOOD.dto.request.AddDrinkDTO;
import com.ftn.CAFOOD.dto.request.DeleteDrinkDTO;
import com.ftn.CAFOOD.dto.request.EditMenuDrinkDTO;
import com.ftn.CAFOOD.dto.request.UpdateDrinkDTO;
import com.ftn.CAFOOD.model.Drink;
import com.ftn.CAFOOD.service.DrinkService;

@RestController
@RequestMapping("/drink")
public class DrinkController {

	@Autowired
	DrinkService ds;
	
	@GetMapping(value = {"/get" , "/getara"})
	public static String getFood() {
		return "Drink";
	}
	
	//@RequestParam(required =  true,value = "imageFile") MultipartFile file,
	@PostMapping(value = "/saveDrink",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Boolean> saveDrink(@RequestPart("file") MultipartFile file , @RequestPart("dd") AddDrinkDTO addt  ) throws IOException, ParseException{

		Boolean b = ds.saveDrink(addt, file);
		
		return new ResponseEntity<Boolean>(b,HttpStatus.OK);
		
	} 
	
	
	@GetMapping(value="/getDrinks")
    public ResponseEntity<Page<Drink>> findAll(Pageable pageable) {

        Page<Drink> drinks = ds.findAll(pageable);

        System.out.println("NEGDE OVDE" + drinks.getNumberOfElements());
        return new ResponseEntity<>(drinks, HttpStatus.OK);
    }

	@PutMapping(value="/updateDrink")
    public ResponseEntity<Boolean> updateDrink(@RequestBody UpdateDrinkDTO udd) throws ParseException {

        Boolean b = ds.updateDrink(udd);

        return new ResponseEntity<>(b, HttpStatus.OK);
    }
	
	
	@DeleteMapping(value="/deleteDrink")
    public ResponseEntity<Boolean> deleteDrink(@RequestBody DeleteDrinkDTO ddd) {

		Boolean b = ds.deleteDrink(ddd);

        return new ResponseEntity<>(b, HttpStatus.OK);
    }
	
	@PutMapping(value="/addInMenuDrink")
    public ResponseEntity<Boolean> addMenuDrink(@RequestBody EditMenuDrinkDTO emdd) {

		Boolean b = ds.addInMenu(emdd);

        return new ResponseEntity<>(b, HttpStatus.OK);
    }
	
	@DeleteMapping(value="/deleteInMenuDrink")
    public ResponseEntity<Boolean> deleteMenuDrink(@RequestBody EditMenuDrinkDTO emdd) {

		Boolean b = ds.deleteInMenu(emdd);

        return new ResponseEntity<>(b, HttpStatus.OK);
    }
}
