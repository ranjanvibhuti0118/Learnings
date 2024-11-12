package com.project.url_shortner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.url_shortner.dao.URLRepository;
import com.project.url_shortner.entity.URL;

@Service
public class URLService   {

	@Autowired
	private URLRepository repo;
	
	private static final String BASE62_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//	private int counter;

	public URLService() {
//		URL url= repo.findFirstByOrderByIdDesc();
//		if(url==null) {
//			counter = 0;	
//		}else {
//			counter = url.getId()+1;	
//		}
	}


	public String shortenUrl(String url) {

//		url=url+counter;
		// Generate a unique hash for the URL
		String urlHash = generateBase62Hash(url);
		return urlHash;
	}

	private String generateBase62Hash(String input) {
		long hashValue = input.hashCode(); // Get the hash code of the input string
		StringBuilder base62Hash = new StringBuilder();

		while (hashValue > 0) {
			int index = (int) (hashValue % 62);
			base62Hash.append(BASE62_CHARACTERS.charAt(index));
			hashValue /= 62;
		}

		return base62Hash.toString();
	}

}
