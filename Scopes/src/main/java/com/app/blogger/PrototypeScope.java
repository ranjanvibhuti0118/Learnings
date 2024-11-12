package com.app.blogger;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")  // Lazy loaded
public class PrototypeScope {

	private String objName;
	public PrototypeScope() {
		super();
		
		System.out.println("PrototypeScope Object Created");
	
	}
	public String getObjName() {
		return objName;
	}
	public void setObjName(String objName) {
		this.objName = objName;
	}

}
//IoC creates a new bean every time it is requested