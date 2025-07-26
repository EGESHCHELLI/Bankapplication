package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Accountdto;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.Accountservice;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	Accountservice accountservice;
	
	@PostMapping("/save")
	public ResponseEntity<Accountdto> addaccount(@RequestBody Accountdto acc) {
		return new ResponseEntity<Accountdto>(accountservice.createaccount(acc), HttpStatus.CREATED);
	}
     
	@GetMapping("/{id}")
	public ResponseEntity<Accountdto> getAccountById(@PathVariable int id){
		Accountdto acdt=accountservice.getAccountById(id);
		return ResponseEntity.ok(acdt);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<Accountdto> deposit(@PathVariable int id,@RequestBody Map<String,Double> request){
		     Double amount=request.get("amount");
		     Accountdto accountdto=accountservice.deposit(id, amount);
		     return ResponseEntity.ok(accountdto);
		
		}
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<Accountdto> withdraw(@PathVariable int id,@RequestBody Map<String, Double> request){
		Double amount=request.get("amount");
		Accountdto accountdto=accountservice.withdraw(id, amount);
		return ResponseEntity.ok(accountdto);
	}
	@GetMapping
	public ResponseEntity<List<Accountdto>> getallaccounts(){
		List<Accountdto> accounts=accountservice.getallaccounts();
		return ResponseEntity.ok(accounts);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteaccount( @PathVariable int id){
		accountservice.deleteaccount(id);
		return ResponseEntity.ok("Account deleted");
	}
	}

