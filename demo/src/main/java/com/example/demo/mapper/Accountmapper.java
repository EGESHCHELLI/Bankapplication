package com.example.demo.mapper;

import com.example.demo.dto.Accountdto;
import com.example.demo.entity.Account;

public class Accountmapper {
          
	public static Account maptoaccount(Accountdto accountdto) {
		Account account=new Account(accountdto.getId(), accountdto.getAcchlodername(),accountdto.getAge(), accountdto.getAccbalance());
		return account;
	}
	
	public static Accountdto maptoaccountdto(Account account) {
		 Accountdto accountdto=new Accountdto(account.getId(), account.getAccholdername(), account.getAge(), account.getBalance());
		 return accountdto;
	}
	
}
