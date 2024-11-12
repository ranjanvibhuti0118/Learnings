package com.app.blogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class WebClientApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(WebClientApplication.class, args);
		System.out.println("Start");

		WebClient webClient= WebClient.create();
		
		webClient.get()
		.uri("http://localhost:8081/getAllUser")
		.retrieve()
		.bodyToMono(String.class).subscribe(WebClientApplication::showMethod);
		
		System.out.println("End");
		
//		System.out.println(data);
//		showMethod(data);
//		Can handle timeout's / Exception with WebClient
		
	}
	public static void showMethod(String data) {

		System.out.println(data);
	}

}
