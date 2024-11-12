package com.app.blogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ScopesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ScopesApplication.class, args);
		
//		SingletonScope obj1= context.getBean(SingletonScope.class);
//		obj1.setObjName("Vibhuti");
//		SingletonScope obj2= context.getBean(SingletonScope.class);
//		System.out.println(obj2.getObjName());
		
		PrototypeScope obj3= context.getBean(PrototypeScope.class);
		obj3.setObjName("Pooja");
		PrototypeScope obj4= context.getBean(PrototypeScope.class);
		System.out.println(obj4.getObjName());

	}

}
