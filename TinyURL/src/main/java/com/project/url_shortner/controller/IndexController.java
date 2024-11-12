package com.project.url_shortner.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.url_shortner.dao.URLRepository;
import com.project.url_shortner.entity.URL;
import com.project.url_shortner.service.URLService;

import ch.qos.logback.core.model.Model;

@Controller
public class IndexController {

	@Value("${server.port}")
	private String port;
	
	private URLRepository repo;
	@Autowired
	public void setRepo(URLRepository repo) {
		this.repo = repo;
	}
	
	private URLService service;
	@Autowired
	public void setService(URLService service) {
		this.service = service;
	}

	
	@GetMapping
	public String getHomepage(Model model) {
		
				return "error";
	}
	
	@GetMapping("/{shortURL}")
	public String getLongURL(@PathVariable String shortURL,Map<String,String> map) {
		
		map= new HashMap<>();
		URL urlExist= repo.findByShortURL(shortURL);
				
		if(urlExist!=null) {
			map.put("shortURL","redirect:"+urlExist.getLongURL());
		}

		return "showLongURL";
	}
	
	@PostMapping
	public String getShortURL(@RequestParam String url,Model model) {
		
		String shortUrl = service.shortenUrl(url);
		
		URL urlObject= new URL(url,shortUrl);
		
		repo.save(urlObject);
		
		
		return shortUrl;
		
	}
}
