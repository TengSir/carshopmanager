package com.oracle.strutsdemo.action;

import com.opensymphony.xwork2.ActionSupport;

public class OrderAction  extends ActionSupport{
	
	public String addOrder() {
		
		
		System.out.println("addOrder ");
		return "aaaa";
	}
	public String deleteOrder() {
		System.out.println("deleteOrder ");
		return "aaaa";
	}
	public String update() {
		System.out.println("update ");
		return "aaaa";
	}
	public String list() {
		System.out.println("list ");
		return "aaaa";
	}
	public String other() {
		System.out.println("here ");
		return "aaaa";
	}

}
