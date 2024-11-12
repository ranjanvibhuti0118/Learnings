package com.project.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.project.springboot3.autowire.Developer;

//This annotation = @SpringBootConfiguration + @EnableAutoConfiguration +@ComponentScan
@SpringBootApplication
public class SpringConceptsApplication {

	//The package where we start IOC container will be considered as base package
		
	 
	 
	public static void main(String[] args) {
		
		//First step is to start IOC Container using SpringApplication run method
		ApplicationContext context= SpringApplication.run(SpringConceptsApplication.class, args);
		
		//AnnotationConfigApplicationContext , the class which starts IOC when spring-boot-starter is used
		//AnnotationConfigServletWebServerApplicationContext , the class which starts IOC when web-flux-starter is used
		//The implementation class  IOC container (AppContext) may change based on starter dependency used
		
		System.out.println(context.getClass().getName());
		
		Developer d1= context.getBean(Developer.class);
		System.out.println(d1.role());
		d1.setExperience(10);
		
		System.out.println(d1.getExperience());
		
		Developer d2= context.getBean(Developer.class);
		System.out.println(d2.role());
		System.out.println(d2.getExperience());

		
		
		//Learnings
		/*
		 * @Scope("singleton")
		 * @Scope("prototype")
		 * @Autowired vs @Bean 
		 * 
		 */
	}

}
