package com.app.blogger;

import org.springframework.stereotype.Component;

@Component //Eager Loaded
public class SingletonScope {

	private String objName;
	public SingletonScope() {
		super();
		
		//By default scope of a bean is singleton
		//Eager Loaded
		System.out.println("SingletonScope Object Created");
	
	}
	public String getObjName() {
		return objName;
	}
	public void setObjName(String objName) {
		this.objName = objName;
	}
	
}
//IoC Creates single bean and assigns it every time an obj is requested