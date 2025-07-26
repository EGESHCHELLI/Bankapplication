package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Accountdto;
@Service
public interface Accountservice {
          
	Accountdto createaccount(Accountdto accountdto);
	
	Accountdto getAccountById(int id);
	
	Accountdto deposit(int id,double amount);
	
	Accountdto withdraw(int id,double amount);
	
	List<Accountdto> getallaccounts();
	
	void deleteaccount(int id); 
}
