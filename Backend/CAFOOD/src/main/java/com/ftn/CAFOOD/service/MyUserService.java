package com.ftn.CAFOOD.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ftn.CAFOOD.dto.MyUserDTO;
import com.ftn.CAFOOD.dto.SalaryDTO;
import com.ftn.CAFOOD.model.MyUser;
import com.ftn.CAFOOD.model.Salary;
import com.ftn.CAFOOD.repository.MyUserRepository;

@Service
public class MyUserService {
	
	@Autowired
	private MyUserRepository mur;
	
	@Autowired
	private ImageService is;
	
	@Autowired
	private SalaryService ss;
	
	public MyUser findOne(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean saveMyUser(MyUserDTO mud,MultipartFile mpf) throws IOException {
		
		is.save(mpf);
		System.out.println("TU");
		
		MyUser mu = new MyUser(mud.getUsername(),mud.getPass() , mud.getFn() , mud.getLn() , true , mud.getRole() 
				,is.findByName(mpf.getOriginalFilename()));
		
		Salary ms = ss.saveSalary(mud.getSal_id());

		mu.getSalary().add(ms);
		
		mur.save(mu);
		
//		System.out.println("IZAOO0O");
		
		return true;
	}

	public Page<MyUser> findAll(Pageable pageable) {
		
		return  mur.findAll(pageable);
	}

	
	
	
}
