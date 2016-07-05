package com.bzu.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	@Override
	public String execute() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		System.out.println("filter invoke");

		if(type==0)
			return "student";
		
		else
			return "admin";
	
	}
}
