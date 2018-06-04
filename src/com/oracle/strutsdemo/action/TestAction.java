package com.oracle.strutsdemo.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Action("TestAction")
@Results({@Result(name="ok",location="/t.jsp")})
public class TestAction {
	private ArrayList<String> names;//action类中的所有属性都默认放在值栈里面
	

	public ArrayList<String> getNames() {
		return names;
	}


	public void setNames(ArrayList<String> names) {
		this.names = names;
	}


	public String test() {
		System.out.println("testAction  --testMethod");
		ServletActionContext.getRequest().setAttribute("user", "zhangsa");
		ServletActionContext.getRequest().getSession().setAttribute("users", "lisi");
		
		names=new ArrayList<>();
		names.add("jack");
		names.add("rose123");
		names.add("mike");
		names.add("tom");
		return "ok";
	}
}
