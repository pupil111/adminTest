package com.zy.aop;

public class Student implements IAopTest {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void showName() {
		
		System.out.println("我的名字是"+name);
	}

}
