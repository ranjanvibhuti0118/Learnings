package com.project.url_shortner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.url_shortner.dao.URLRepository;
import com.project.url_shortner.entity.URL;
import com.project.url_shortner.service.URLService;

//@RestController
public class TinyURLController {
	
	@Value("${server.port}")
	private Integer port;
	private URLService service;
	private URLRepository repo;
	@Autowired
	public void setRepo(URLRepository repo) {
		this.repo = repo;
	}
	

	//Setting AutoWired on a variable vs on setter or constructor 
	@Autowired
	public void setService(URLService service) {
		this.service = service;
	}


	
	@GetMapping("/getTinyURL")
	public String getShortURL(@RequestParam String url) {
		
		String shortUrl = service.shortenUrl(url);
		
		URL urlObject= new URL(url,shortUrl);
		
		repo.save(urlObject);
		
		return "http://localhost:"+port+"/"+ shortUrl;
	}
	
	
	
}
