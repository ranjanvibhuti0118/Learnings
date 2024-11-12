package com.app.blogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBeanLifeCycleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBeanLifeCycleApplication.class, args);
		
		TestBean bean=context.getBean(TestBean.class);
		bean.method();
	}

}
