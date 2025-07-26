package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Account {
	@Id
	private int id;
	private String accholdername;
	private int age;
	private double accbalance;
	
	public Account() {
		super();
	}
	
	public Account(int id, String accholdername, int age, double d) {
		super();
		this.id = id;
		this.accholdername = accholdername;
		this.age = age;
		this.accbalance = d;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccholdername() {
		return accholdername;
	}
	public void setAccholdername(String accholdername) {
		this.accholdername = accholdername;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getBalance() {
		return accbalance;
	}
	public void setBalance(double balance) {
		this.accbalance = balance;
	}	

}
