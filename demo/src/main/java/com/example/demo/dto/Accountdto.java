package com.example.demo.dto;

public class Accountdto {
        
	private int id;
	private String acchlodername;
	private int age;
	private double accbalance;
	
	
	public Accountdto(int id, String acchlodername,int age, double accbalance) {
		super();
		this.id = id;
		this.acchlodername = acchlodername;
		this.age=age;
		this.accbalance = accbalance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcchlodername() {
		return acchlodername;
	}
	public void setAcchlodername(String acchlodername) {
		this.acchlodername = acchlodername;
	}
	public double getAccbalance() {
		return accbalance;
	}
	public void setAccbalance(double accbalance) {
		this.accbalance = accbalance;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
