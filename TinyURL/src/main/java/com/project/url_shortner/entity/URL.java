package com.project.url_shortner.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class URL {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq_gen")
	@SequenceGenerator(name = "my_seq_gen", sequenceName = "GEN_SEQUENCE")
	private Integer id;
	private String longURL;
	private String shortURL;


	public URL() {
		super();
	}

	public URL(String longURL, String shortURL) {
		super();
		this.longURL = longURL;
		this.shortURL = shortURL;
	}
	public String getLongURL() {
		return longURL;
	}
	public void setLongURL(String longURL) {
		this.longURL = longURL;
	}
	public String getShortURL() {
		return shortURL;
	}
	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



}
