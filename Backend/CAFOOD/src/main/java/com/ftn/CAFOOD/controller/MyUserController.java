package com.ftn.CAFOOD.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ftn.CAFOOD.dto.MyUserDTO;
import com.ftn.CAFOOD.model.MyUser;
import com.ftn.CAFOOD.service.MyUserService;



@RestController
public class MyUserController {

	@Autowired
	MyUserService mus;
	
	
	
	//@RequestParam(required =  true,value = "imageFile") MultipartFile file,
	@PostMapping(value = "/saveUser",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Boolean> saveSalary(@RequestPart("file") MultipartFile file , @RequestPart("mud") MyUserDTO mud  ) throws IOException{

		Boolean b = mus.saveMyUser(mud, file);
		
		return new ResponseEntity<Boolean>(b,HttpStatus.OK);
		
	} 
	
	
	@GetMapping(value="/getUsers")
    public ResponseEntity<Page<MyUser>> findAll(Pageable pageable) {

        Page<MyUser> myUsers = mus.findAll(pageable);
        
//        List<MyUser> myUser = new ArrayList<>();
//		for (MyUser mu : myUsers) {
//			myUser.add(mu);
//		}
		 
        System.out.println("NEGDE OVDE" + myUsers.getNumberOfElements());
        return new ResponseEntity<>(myUsers, HttpStatus.OK);
    }

	
}
