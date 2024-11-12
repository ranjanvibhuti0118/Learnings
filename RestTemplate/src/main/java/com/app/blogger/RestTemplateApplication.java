package com.app.blogger;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
		
		RestTemplate restTemplate= new RestTemplate();
		UserDto[] user = restTemplate.getForObject("http://localhost:8081/getAllUser", UserDto[].class);
		
		
		ResponseEntity<UserDto[]> userRes =restTemplate.getForEntity("http://localhost:8081/getAllUser", UserDto[].class);
		
		UserDto[] data = userRes.getBody();
		show(data);
		
		
	}

	private static void show(UserDto[] user) {
		
		List<UserDto> list = Arrays.asList(user);
		for(UserDto users: list) {
			System.out.println(users.getFirstName());
		}
	}

}
