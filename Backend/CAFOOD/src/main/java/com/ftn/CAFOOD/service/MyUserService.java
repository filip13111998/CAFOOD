package com.ftn.CAFOOD.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ftn.CAFOOD.dto.MyUserDTO;
import com.ftn.CAFOOD.dto.SalaryDTO;
import com.ftn.CAFOOD.dto.request.DeleteUserDTO;
import com.ftn.CAFOOD.dto.request.EditUserDTO;
import com.ftn.CAFOOD.dto.request.UpdateUserDTO;
import com.ftn.CAFOOD.model.MyUser;
import com.ftn.CAFOOD.model.Salary;
import com.ftn.CAFOOD.repository.MyUserRepository;
import com.ftn.CAFOOD.repository.SalaryRepository;

@Service
public class MyUserService {
	
	@Autowired
	private MyUserRepository mur;
	
	@Autowired
	private ImageService is;
	
	@Autowired
	private SalaryService ss;
	
	@Autowired
	private SalaryRepository sr;
	
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
	
	public MyUser findOneByUsername(String username) {
		System.out.println("USO");
		return mur.findOneByUsername(username);
	}


	public Boolean updateUser(UpdateUserDTO uud) {
		MyUser mu = findOneByUsername(uud.getUsername());
		if(!uud.getFn().equals("null")) {
			mu.setFirstName(uud.getFn());
		}
		if(!uud.getLn().equals("null")) {
			mu.setLastName(uud.getLn());
		}
		if(!uud.getPassword().equals("null")) {
			mu.setPassword(uud.getPassword());
		}
		if(!uud.getSalary().equals("null")) {
			Salary sa = mu.getSalary().stream().filter(a -> a.isActive() == true).findFirst().orElse(null);
			sa.setActive(false);
			sr.save(sa);
			Salary s = ss.saveSalary(uud.getSalary());
			mu.getSalary().add(s);
			
		}
		
		mur.save(mu);
		return true;
	}

	public Boolean deleteOneByUsername(DeleteUserDTO dud) {
		MyUser mu = findOneByUsername(dud.getUsername());
		mu.setDelete(false);
		mur.save(mu);
		return true;
	}

	public Boolean editUser(EditUserDTO eud) {
		MyUser mu = findOneByUsername(eud.getUsername());
		if(!eud.getFn().equals("null")) {
			System.out.println("TUUUU");
			mu.setFirstName(eud.getFn());
		}
		if(!eud.getLn().equals("null")) {
			mu.setLastName(eud.getLn());
		}
		if(!eud.getPassword().equals("null")) {
			mu.setPassword(eud.getPassword());
		}
		mur.save(mu);
		return true;
	}
	
	
}
