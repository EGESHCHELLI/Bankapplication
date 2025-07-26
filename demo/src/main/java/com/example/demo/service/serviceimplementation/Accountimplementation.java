package com.example.demo.service.serviceimplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.Accountdto;
import com.example.demo.entity.Account;
import com.example.demo.mapper.Accountmapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.Accountservice;
@Component
public class Accountimplementation implements Accountservice {
    
	@Autowired
	AccountRepository accountrepository;
	@Override
	public Accountdto createaccount(Accountdto accountdto) {
		Account acc=Accountmapper.maptoaccount(accountdto);
		Account accountsave=accountrepository.save(acc);
		return Accountmapper.maptoaccountdto(accountsave);
		
	}
	@Override
	public Accountdto getAccountById(int id) {
		Account account=accountrepository.findById(id).orElseThrow(() ->new RuntimeException("id does not exists"));
		return Accountmapper.maptoaccountdto(account);
	}
	@Override
	public Accountdto deposit(int id, double amount) {
		Account account1=accountrepository.findById(id).orElseThrow(() ->new RuntimeException("id does not exists"));
		double balance=account1.getBalance();
		balance=balance+amount;
		account1.setBalance(balance);
		Account savedaccount=accountrepository.save(account1);
		return Accountmapper.maptoaccountdto(savedaccount);
	}
	@Override
	public Accountdto withdraw(int id, double amount) {
		Account account=accountrepository.findById(id).orElseThrow(() ->new RuntimeException("id does not exists"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		double totalbalance=account.getBalance()-amount;
		account.setBalance(totalbalance);
		Account savedaccount=accountrepository.save(account);
		return Accountmapper.maptoaccountdto(savedaccount);
	}
	@Override
	public List<Accountdto> getallaccounts() {
		List<Account> accounts=accountrepository.findAll();
		return(List<Accountdto>)accounts.stream().map((account)->Accountmapper.maptoaccountdto(account)).collect(Collectors.toList());
	}
	@Override
	public void deleteaccount(int id) {
		Account account=accountrepository.findById(id).orElseThrow(() ->new RuntimeException("id does not exists"));
		accountrepository.deleteById(id);
	}
	
	
	


}
